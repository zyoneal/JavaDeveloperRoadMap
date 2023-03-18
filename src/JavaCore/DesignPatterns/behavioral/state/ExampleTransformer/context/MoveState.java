package JavaCore.DesignPatterns.behavioral.state.ExampleTransformer.context;

public class MoveState implements TransformerState{

    @Override
    public void action() {
        System.out.println("move!!!");
    }

}
