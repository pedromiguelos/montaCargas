package forkliftPuzzle;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TODO: (NOTA) Este objeto é chamado pelos algoritmos de procura enquant estiverem á procura da solução
//os algoritmos vão sempre verificando o isGoal() e se não encontrarem continuam para o executeActions()

public class ForkliftPuzzleProblem extends Problem<ForklifttPuzzleState> {
    
    public ForkliftPuzzleProblem(ForklifttPuzzleState initialState ){ //, List<Action> actions) {
        //Criar lista das pecas
        super(initialState, new ArrayList<Action>());
                       
    }
   
    //O goal é a coluna do carro chegar a ultima coluna, onde está a porta
    @Override
    public boolean isGoal(ForklifttPuzzleState state) {
        return state.getColumnCar() == state.getNumColumns() - 1;
    }
    
    
    @Override
    public List<ForklifttPuzzleState> executeActions(ForklifttPuzzleState state) {
        List<ForklifttPuzzleState> successors = new LinkedList<ForklifttPuzzleState>();

        actions = new ArrayList<Action>();
        
        for(Obstacle o: state.getObstacles()){
            if(o.isHorizontal()){
                actions.add(new ActionRight(o));
                actions.add(new ActionLeft(o));
                
            }else{
                actions.add(new ActionUp(o));
                actions.add(new ActionDown(o));
            }
        }
        
        
        
        for (Action a : actions) {
            if( a.isValid(state) ){ //Este if pode ficar no loop das peças para não preencher a lista actions com movimentos inválidos(menos iterações)
                ForklifttPuzzleState sucessor = (ForklifttPuzzleState) state.clone();
                a.execute(sucessor);
                successors.add(sucessor);
            }
        }
        return successors;
    }
    
    @Override
    public double computePathCost(List<Action> path) {//so para otimizacao não é genérico...
        return path.size();
    }
    
    
}
