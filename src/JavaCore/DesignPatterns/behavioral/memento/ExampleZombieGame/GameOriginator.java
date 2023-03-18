package behavioral.memento.ExampleZombieGame;

public class GameOriginator {

    private GameState state = new GameState(100, 0);

    public void play() {
        System.out.println(state.toString());
        state = new GameState( state.health * 2, state.numberOfZombies + 2);
    }

    public GameMemento gameSave() {
        return new GameMemento(state);
    }

    public void loadGame(GameMemento gameMemento) {
        state = gameMemento.getState();
    }

}
