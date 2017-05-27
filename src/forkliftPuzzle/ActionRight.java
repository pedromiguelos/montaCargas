package forkliftPuzzle;

import agent.Action;

public class ActionRight extends Action<ForklifttPuzzleState>{

    public ActionRight(){
        super(1);
    }

    public void execute(ForklifttPuzzleState state){
        state.moveRight();
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveRight();
    }
}