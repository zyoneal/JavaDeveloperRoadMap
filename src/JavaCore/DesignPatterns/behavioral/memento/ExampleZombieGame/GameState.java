package behavioral.memento.ExampleZombieGame;

public class GameState {

    int health;

    int numberOfZombies;

    public GameState(int health, int numberOfZombies) {
        this.health = health;
        this.numberOfZombies = numberOfZombies;
    }
}
