package forkliftPuzzle;

import agent.Action;
import agent.State;
import java.util.ArrayList;
import java.util.Arrays;

public class ForklifttPuzzleState extends State implements Cloneable {
    
    private int matrix[][];
    ArrayList<Obstacle> obstacles; // array com os obstáculos
    private int carColumn;

    public ForklifttPuzzleState(int[][] matrix) {

        obstacles = new ArrayList<Obstacle>();

        //Percorre a matriz
        this.matrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j]; //adiciona a matriz
                if (matrix[i][j] == 1) {
                    carColumn = j;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int number = matrix[i][j];
                int size = 0;
                if (number != 0 && !(number % 2 == 0)) { //se diferente de 0 e ímpar -> peça vertical
                    
                    if (number == 3) {
                        size = 1;
                    }
                    if (number == 5) {
                        size = 2;
                    }
                    if (number == 7) {
                        size = 3;
                    }
                    if (number == 9) {
                        size = 4;
                    }
                    obstacles.add(new Obstacle(i, j, number, size, Direction.VERTICAL)); //i-> row; j-> column
                }
                    if (number != 0 && (number % 2 == 0)) //se for par -> peça horizontal
                    {
                        
                        if (number == 2 || number == 1) {
                            size = 1;
                        }

                        if (number == 4) {
                            size = 2;
                        }
                        if (number == 6) {
                            size = 3;
                        }
                        if (number == 8) {
                            size = 4;
                        }

                        obstacles.add(new Obstacle(i, j, number, size, Direction.HORIZONTAL)); //i-> row; j-> column
                    }
                
            }
        }
    }

//NOTE: adicionei este getter para poder no isGoal verificar o estado da matrix
    public int[][] getMatrix() {
        return matrix;
    }

    public void executeAction(Action action) {
        action.execute(this);
        firePuzzleChanged(null);
    }

    //TODO: (NOTA) Sei que esta solução não é a melhor/mais otimizada, nem sei se funciona! Mas penso que deve funcionar e ao menos é nosso, ninguém que eu saiba fez assim.
    public boolean canMoveRight(Obstacle obstacle) {
        for (int i = 0; i < obstacles.size(); i++) {
        if(obstacles.get(i).getColumn() >= matrix.length -1) //não pode andar mais para a direita
            return false;
        
        if(obstacle.getDirection() != Direction.HORIZONTAL)
            return false;
        
        if(matrix[obstacles.get(i).getRow()][obstacles.get(i).getColumn() + 1] != 0) //se , por exemplo, tiver uma peça ao lado não pode mover
            return false;
        
        return true;
        }
        return true;
    }

    public boolean canMoveLeft(Obstacle obstacle) {
        for (int i = 0; i < obstacles.size(); i++) {
        if(obstacles.get(i).getColumn() <= 0) //não pode andar mais para a esquerda
            return false;
        
        if(obstacles.get(i).getDirection() != Direction.HORIZONTAL)
            return false;
    
        if(matrix[obstacles.get(i).getRow()][obstacles.get(i).getColumn() - 1] != 0)
            return false;
        
        return true;
        }
        return true;
    }

    public boolean canMoveDown(Obstacle obstacle) {
        for (int i = 0; i < obstacles.size(); i++) {
        if(obstacles.get(i).getRow() >= matrix.length - 1) //não pode andar mais para baixo
           return false;
       
       if(obstacles.get(i).getDirection() != Direction.VERTICAL)
           return false;
       
       if(matrix[obstacles.get(i).getRow() + 1][obstacles.get(i).getColumn()] != 0)
           return false;
       
       return true;
        }
        return true;
    }

    public boolean canMoveUp(Obstacle obstacle) {
        for (int i = 0; i < obstacles.size(); i++) {
            if(obstacles.get(i).getRow() <= 0) //se estiver no topo não pode andar mais para cima
            return false;
            
            if(obstacles.get(i).getDirection() != Direction.VERTICAL) 
            return false;
        
            if(matrix[obstacles.get(i).getRow() - 1][obstacles.get(i).getColumn()] != 0)
            return false;
            
            return true;
        }

        return true;
    }


    /*
     * Nos metodos move[Down|Up|Right|Left] não há validação(canMove), já foi feita na class EightPuzzelProblem no executeActions().
     * Saber que peça quer mover e actualizar na matriz
     */
    
    //Aqui o problema é o facto de haver peças com tamanhos diferentes
    public void moveUp(Obstacle obstacle) {
        matrix[obstacle.getRow()-1][obstacle.getColumn()] = matrix[obstacle.getRow()][obstacle.getColumn()];
        matrix[obstacle.getRow()+obstacle.getSize()][obstacle.getColumn()] = 0; //a posição onde a peça se encontrava fica vazia
             
        
        //falta atualizar a posição do obstaculo na lista de obstaculos
    }

    public void moveRight(Obstacle obstacle) {
        matrix[obstacle.getRow()][obstacle.getColumn()+1] = matrix[obstacle.getRow()][obstacle.getColumn()];
        matrix[obstacle.getRow()][obstacle.getColumn()-obstacle.getSize()] = 0;
        
        //falta atualizar a posição do obstaculo na lista de obstaculos
    }

    public void moveDown(Obstacle obstacle) {
        matrix[obstacle.getRow()+1][obstacle.getColumn()] = matrix[obstacle.getRow()][obstacle.getColumn()];
        matrix[obstacle.getRow()-obstacle.getSize()][obstacle.getColumn()] = 0; //a posição onde a peça se encontrava fica vazia
        
        //falta atualizar a posição do obstaculo na lista de obstaculos
    }

    public void moveLeft(Obstacle obstacle) {
        matrix[obstacle.getRow()][obstacle.getColumn()-1] = matrix[obstacle.getRow()][obstacle.getColumn()];
        matrix[obstacle.getRow()][obstacle.getColumn()+obstacle.getSize()] = 0;
        
        //falta atualizar a posição do obstaculo na lista de obstaculos
    }

    public int getNumLines() {
        return matrix.length;
    }

    public int getNumColumns() {
        return matrix[0].length;
    }

    public int getTileValue(int line, int column) {
        if (!isValidPosition(line, column)) {
            throw new IndexOutOfBoundsException("Invalid position!" + "line:" + line + " column:" + column + "Matrix[" + matrix.length + "][" + matrix[0].length + "]");
        }
        return matrix[line][column];
    }

    //TODO: (NOTA) Atenção que peças não podem sobrepor-se
    public boolean isValidPosition(int line, int column) {
        return line >= 0 && line < matrix.length && column >= 0 && column < matrix[0].length;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ForklifttPuzzleState)) {
            return false;
        }

        ForklifttPuzzleState o = (ForklifttPuzzleState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public Object clone() {
        return new ForklifttPuzzleState(matrix);
    }
    //Listeners
    private transient ArrayList<EightPuzzleListener> listeners = new ArrayList<EightPuzzleListener>(3);

    public synchronized void removeListener(EightPuzzleListener l) {
        if (listeners != null && listeners.contains(l)) {
            listeners.remove(l);
        }
    }

    public synchronized void addListener(EightPuzzleListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public void firePuzzleChanged(EightPuzzleEvent pe) {
        for (EightPuzzleListener listener : listeners) {
            listener.puzzleChanged(null);
        }
    }

       public int getColumnCar() {
        return carColumn;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

        
}
