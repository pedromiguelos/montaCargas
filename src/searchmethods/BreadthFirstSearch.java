package searchmethods;

import agent.State;
import java.util.List;
import utils.NodeLinkedList;

public class BreadthFirstSearch extends GraphSearch<NodeLinkedList> {

    public BreadthFirstSearch() {
        frontier = new NodeLinkedList();
    }
    
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        
        for (State s : successors) {
            if(!frontier.containsState(s) && !explored.contains(s)){
                frontier.add(new Node(s, parent));
            }
        }
    }

    @Override
    public String toString() {
        return "Breadth first search";
    }
}