package behavioral.strategy.ExampleClothes;

public class Myself {

    IWearingStrategy wearingStrategy = new DefaultWearingStrategy();

    public void changeStrategy(IWearingStrategy wearingStrategy) {
        wearingStrategy = wearingStrategy;
    }

    public void goOutside() {
        String clothes = wearingStrategy.getClothes();
        String accessories = wearingStrategy.getAccessories();
        System.out.println("Today i " + clothes + " and " + accessories);
    }

}
