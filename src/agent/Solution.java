package agent;

import java.util.LinkedList;
import java.util.List;
import searchmethods.Node;

//TODO: (NOTA) quando o metodo isGoal na class EightPuzzelProblem devolver true o algoritmo de procura vai criar um objeto Solution
public class Solution {
    private Problem problem;
    private LinkedList<Action> actions = new LinkedList<Action>();// [cima, direita, baixo, esquerda] movimentos para a peça até chegar á solução

    public Solution(Problem problem, Node goalNode){
        this.problem = problem;
        Node node = goalNode;
        //TODO: (NOTA) Apartir do nó que foi encontrado o goal vai guardando os nós pais até chegar ao fim
        while(node.getParent() != null){ 
            actions.addFirst(node.getState().getAction());
            node = node.getParent();
        }
    }

    public double getCost(){
        return problem.computePathCost(actions);
    }

    public List<Action> getActions(){
        return actions;
    }
}