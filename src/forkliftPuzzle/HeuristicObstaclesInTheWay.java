package forkliftPuzzle;

import agent.Heuristic;

public class HeuristicObstaclesInTheWay extends Heuristic<ForkliftPuzzleProblem, ForklifttPuzzleState> {

    public double compute(ForklifttPuzzleState state) {
        return (state.getNumColumns() -1) - state.getColumnCar();
    }

    @Override
    public String toString() {
        return "Distance To Goal";
    }
}
