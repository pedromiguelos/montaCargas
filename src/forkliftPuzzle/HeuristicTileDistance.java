package forkliftPuzzle;

import agent.Heuristic;

public class HeuristicTileDistance extends Heuristic<EightPuzzleProblem, ForklifttPuzzleState>{

    public double compute(ForklifttPuzzleState state){
        return 0.0;
    }
    
    @Override
    public String toString(){
        return "Tiles distance to final position";
    }
}