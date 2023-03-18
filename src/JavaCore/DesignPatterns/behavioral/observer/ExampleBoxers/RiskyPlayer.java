package JavaCore.DesignPatterns.behavioral.observer.ExampleBoxers;

public class RiskyPlayer implements IObserver {

    public String boxerToPutMoneyOn;

    @Override
    public void update(ISubject subject) {
        var boxFight = (BoxFight) subject;
        if (boxFight.boxerAScore > boxFight.boxerBScore) {
            boxerToPutMoneyOn = "I put on boxer B, if he win I get more!";
        } else {
            boxerToPutMoneyOn = "I put on boxer A, if he win I get more!";
        }
        System.out.println(boxerToPutMoneyOn);
    }
}
