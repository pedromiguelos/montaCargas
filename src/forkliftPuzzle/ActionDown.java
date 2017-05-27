package forkliftPuzzle;

import agent.Action;

public class ActionDown extends Action<ForklifttPuzzleState>{

    public ActionDown(Obstacle obstacle){
        super(1, obstacle); 
    }


    public void execute(ForklifttPuzzleState state){
        state.moveDown(this.obstacle);
        state.setAction(this);
    }

    public boolean isValid(ForklifttPuzzleState state){
        return state.canMoveDown(this.obstacle);
    }
}