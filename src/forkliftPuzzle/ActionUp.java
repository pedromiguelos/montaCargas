package forkliftPuzzle;

import agent.Action;

public class ActionUp extends Action<ForklifttPuzzleState>{

    public ActionUp(Obstacle obstacle){
        super(1, obstacle);
    }

    public void execute(ForklifttPuzzleState state){
        state.moveUp(this.obstacle);
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveUp(this.obstacle);
    }
}