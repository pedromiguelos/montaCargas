package agent;

import java.util.List;

public abstract class Problem <S extends State>{

    private S initialState;
    
    protected List<Action> actions;
    private Heuristic heuristic;

    public Problem(S initialState, List<Action> actions) {
        this.initialState = initialState;
        this.actions = actions;
    }
    
    //abstracto porq depende do problema, uma vez que existem problemas diferentes
    public abstract boolean isGoal(S state);
    
    public abstract List<S> executeActions(S state);
    
    public double computePathCost(List<Action> path){
        double cost = 0;
        for(Action act : actions){
            cost += act.getCost();
        }
        return cost;
    }

    public S getInitialState() {
        return initialState;
    }

    public Heuristic getHeuristic() {
        return heuristic;
    }
    
    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }
}
