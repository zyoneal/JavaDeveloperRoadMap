package JavaCore.DesignPatterns.behavioral.observer.ExampleBoxers;

public class ConservativePlayer implements IObserver{

    public String boxerToPutMoneyOn;

    @Override
    public void update(ISubject subject) {
        var boxFight = (BoxFight) subject;
        if (boxFight.boxerAScore < boxFight.boxerBScore) {
            boxerToPutMoneyOn = "I put on boxer B, better be safe!";
        } else {
            boxerToPutMoneyOn = "I put on boxer A, better be safe!";
        }
        System.out.println(boxerToPutMoneyOn);
    }

}
