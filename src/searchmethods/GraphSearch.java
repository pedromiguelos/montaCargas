package searchmethods;

import agent.Problem;
import agent.Solution;
import agent.State;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.NodeCollection;

public abstract class GraphSearch<L extends NodeCollection> implements SearchMethod {

    protected L frontier;
    protected Set<State> explored = new HashSet<State>();
    protected Statistics statistics = new Statistics();    
    protected boolean stopped;

    @Override
    public Solution search(Problem problem) {
        statistics.reset();
        stopped = false;
        return graphSearch(problem);
    }


    protected Solution graphSearch(Problem problem) {

        statistics.reset();
        frontier.clear();
        explored.clear();
        frontier.add(new Node(problem.getInitialState()));
        
        while(!frontier.isEmpty() && !stopped) {
            Node n = frontier.poll();
            if (problem.isGoal(n.getState())) {
                return new Solution(problem, n);
            }
            explored.add(n.getState());
            List<State> sucessors = problem.executeActions(n.getState());
            addSuccessorsToFrontier(sucessors, n);
            computeStatistics(sucessors.size());
        }
        
        return null;
    }

    public abstract void addSuccessorsToFrontier(List<State> successors, Node parent);

    protected void computeStatistics(int successorsSize) {
        statistics.numExpandedNodes++;
        statistics.numGeneratedNodes += successorsSize;
        statistics.maxFrontierSize = Math.max(statistics.maxFrontierSize, frontier.size());
    }
    
    public Statistics getStatistics(){
        return statistics;
    }

    public void stop() {
        stopped = true;
    }

    public boolean hasBeenStopped() {
        return stopped;
    }
}
    