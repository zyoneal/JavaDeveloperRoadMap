package JavaCore.DesignPatterns.state.start;

// Состояние позволяет вынести логику определения состояния объекта и его
//поведение, характерное для этого состояния, в других классах.

// Обьект который меняет свое поведение в зависимости от своего состояния
// позволяет избегать мгогочисленных if

import JavaCore.DesignPatterns.state.FireState;
import JavaCore.DesignPatterns.state.MoveState;
import JavaCore.DesignPatterns.state.TransformerState;
import JavaCore.DesignPatterns.state.context.TransformerContext;

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
