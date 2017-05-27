package forkliftPuzzle;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

    //TODO: (NOTA) Este objeto é chamado pelos algoritmos de procura enquant estiverem á procura da solução
    //os algoritmos vão sempre verificando o isGoal() e se não encontrarem continuam para o executeActions()
    
public class EightPuzzleProblem extends Problem<ForklifttPuzzleState> {
    
    public EightPuzzleProblem(ForklifttPuzzleState initialState ){ //, List<Action> actions) {
        //Criar lista das pecas
        super(initialState, new ArrayList<Action>());
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());
        
    }
    //TODO: (NOTA) Basta verificar se a coluna do carro é igual á ultima coluna da matriz (state.getPosDoCarro()?)
    @Override
    public boolean isGoal(ForklifttPuzzleState state) {
        return false;
    }

    
    //TODO: NOTE: Este metodo é chamado por todos os algoritmos de procura para criar um novo estado (Nó)
    //Neste tipo de problema todas as peças mexem-se e para 2 sentidos (Horizontal[LEFT|RIGHT] ou Vertical[UP|DOWN])
    //(Para cada Peça)
    //   Se [accao sobre o estado for válida]
    //        nova Accao
    //(Para cada Accao)
    //   a.execute(sucessor)
    @Override
    public List<ForklifttPuzzleState> executeActions(ForklifttPuzzleState state) {
        List<ForklifttPuzzleState> successors = new LinkedList<ForklifttPuzzleState>();
        //falta código..
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
