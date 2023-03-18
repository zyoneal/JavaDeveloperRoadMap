package JavaCore.DesignPatterns.behavioral.memento.ExampleZombieGame;

public class GameMemento {

    private GameState state;

    public GameMemento(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

}
