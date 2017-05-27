package agent;


//TODO: (NOTA) A Acçáo precisa de saber que peça vai mexer Actualmente só está a passar o estado
public abstract class Action <S extends State>{
    private double cost; // em alguns problemas o custo pode mudar exemplo caminhos que custem mais a percorrer a pe de carro etc neste programa é sempre 1

    public Action(double cost){
        this.cost = cost;
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