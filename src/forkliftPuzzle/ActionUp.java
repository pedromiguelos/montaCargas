package forkliftPuzzle;

import agent.Action;

public class ActionUp extends Action<ForklifttPuzzleState>{

    public ActionUp(){
        super(1);
    }

    public void execute(ForklifttPuzzleState state){
        state.moveUp();
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveUp();
    }
}