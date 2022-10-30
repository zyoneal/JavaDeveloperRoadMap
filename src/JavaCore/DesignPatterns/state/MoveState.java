package JavaCore.DesignPatterns.state;

public class MoveState implements TransformerState{

    @Override
    public void action() {
        System.out.println("move!!!");
    }

}
