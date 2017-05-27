package forkliftPuzzle;

import agent.Action;

public class ActionDown extends Action<ForklifttPuzzleState>{

    public ActionDown(){
        super(1); 
    }


    public void execute(ForklifttPuzzleState state){
        state.moveDown();
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveDown();
    }
}