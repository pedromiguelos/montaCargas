package forkliftPuzzle;

import agent.Action;

public class ActionLeft extends Action<ForklifttPuzzleState>{

    public ActionLeft(Obstacle obstacle){
        super(1, obstacle);
    }

    public void execute(ForklifttPuzzleState state){
        state.moveLeft(this.obstacle);
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveLeft(this.obstacle);
    }
}
