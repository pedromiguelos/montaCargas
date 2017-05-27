package forkliftPuzzle;

import agent.Action;

public class ActionRight extends Action<ForklifttPuzzleState>{

    public ActionRight(Obstacle obstacle){
        super(1,obstacle);
    }

    public void execute(ForklifttPuzzleState state){
        state.moveRight(this.obstacle);
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveRight(this.obstacle);
    }
}