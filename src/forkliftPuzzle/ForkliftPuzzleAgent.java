package forkliftPuzzle;

import agent.Agent;
import java.io.File;
import java.io.IOException;

public class ForkliftPuzzleAgent extends Agent<ForklifttPuzzleState>{
    
    protected ForklifttPuzzleState initialEnvironment;    
    
    public ForkliftPuzzleAgent(ForklifttPuzzleState environemt) {
        super(environemt);
        initialEnvironment = (ForklifttPuzzleState) environemt.clone();
        heuristics.add(new HeuristicDistanceToGoal());
        heuristics.add(new HeuristicObstaclesInTheWay());
        heuristic = heuristics.get(0);
    }
            
    public ForklifttPuzzleState resetEnvironment(){
        environment = (ForklifttPuzzleState) initialEnvironment.clone();
        return environment;
    }
                 
    public ForklifttPuzzleState readInitialStateFromFile(File file) throws IOException {
        java.util.Scanner scanner = new java.util.Scanner(file);
        
        int tableSize = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int [tableSize][tableSize];
        
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        initialEnvironment = new ForklifttPuzzleState(matrix);
        resetEnvironment();
        return environment;
    }
}
