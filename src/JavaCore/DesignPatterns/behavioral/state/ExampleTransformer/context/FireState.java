package JavaCore.DesignPatterns.behavioral.state.ExampleTransformer.context;

public class FireState implements TransformerState{

    @Override
    public void action() {
        System.out.println("fire!!!");
    }

}
