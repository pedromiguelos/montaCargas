package forkliftPuzzle;

import agent.Action;

public class ActionLeft extends Action<ForklifttPuzzleState>{

    public ActionLeft(){
        super(1);
    }

    public void execute(ForklifttPuzzleState state){
        state.moveLeft();
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveLeft();
    }
}
