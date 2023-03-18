package JavaCore.DesignPatterns.behavioral.strategy.ExampleClothes;

public class Demo {

    public static void main(String[] args) {
        Myself me = new Myself();
        me.changeStrategy(new RainWearingStrategy());
        me.goOutside();
    }

}
