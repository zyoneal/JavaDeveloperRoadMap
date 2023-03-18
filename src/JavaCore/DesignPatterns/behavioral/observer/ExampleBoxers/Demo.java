package JavaCore.DesignPatterns.behavioral.observer.ExampleBoxers;

public class Demo {

    public static void main(String[] args) {
        BoxFight boxFight = new BoxFight();
        RiskyPlayer riskyPlayer = new RiskyPlayer();
        ConservativePlayer conservativePlayer = new ConservativePlayer();

        boxFight.attachObserve(riskyPlayer);
        boxFight.attachObserve(conservativePlayer);

        boxFight.nextRound();
        boxFight.nextRound();
        boxFight.nextRound();
        boxFight.nextRound();
    }

}
