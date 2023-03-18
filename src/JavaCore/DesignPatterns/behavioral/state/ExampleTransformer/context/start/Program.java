package JavaCore.DesignPatterns.behavioral.state.ExampleTransformer.context.start;

// Состояние позволяет вынести логику определения состояния объекта и его
//поведение, характерное для этого состояния, в других классах.

// Обьект который меняет свое поведение в зависимости от своего состояния
// позволяет избегать мгогочисленных if

import JavaCore.DesignPatterns.behavioral.state.ExampleTransformer.context.FireState;
import JavaCore.DesignPatterns.behavioral.state.ExampleTransformer.context.MoveState;
import JavaCore.DesignPatterns.behavioral.state.ExampleTransformer.context.TransformerState;
import JavaCore.DesignPatterns.behavioral.state.ExampleTransformer.context.TransformerContext;

public class Program {

    public static void main(String[] args) {
        TransformerContext context = new TransformerContext();

        TransformerState stateMove = new MoveState();
        TransformerState stateFire = new FireState();

        context.setState(stateFire);
        context.action();

        context.setState(stateMove);
        context.action();
    }

}
