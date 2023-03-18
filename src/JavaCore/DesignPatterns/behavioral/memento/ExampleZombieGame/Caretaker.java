package behavioral.memento.ExampleZombieGame;

import java.util.Stack;

public class Caretaker {

    private GameOriginator game = new GameOriginator();

    private Stack<GameMemento> quickSaves = new Stack<>();

    public void shootThatDumbAss() {
        game.play();
    }

    public void F5() {
        quickSaves.push(game.gameSave());
    }

    public void F9() {
        game.loadGame(quickSaves.peek());
    }

}
