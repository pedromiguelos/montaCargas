package agent;

import forkliftPuzzle.Obstacle;



public abstract class Action <S extends State>{
    private double cost; 
    protected Obstacle obstacle;

    public Action(double cost, Obstacle obstacle){
        this.cost = cost;
        this.obstacle = obstacle;
    }

    //Chama os executes das classes Action[Down | Left | Right | Up]
    public abstract void execute(S State);

    //TODO: (NOTA) Chama os isValid das classes Action[Down | Left | Right | Up] que por sua vez pergunta ao estado se a accao é válida
    //Actualmente a unica validação que está a fazer é se está dentro da matriz
    public abstract boolean isValid(S State);

    public double getCost(){
        return cost;
    }
}