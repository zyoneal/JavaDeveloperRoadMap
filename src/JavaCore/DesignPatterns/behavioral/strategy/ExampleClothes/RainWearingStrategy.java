package JavaCore.DesignPatterns.behavioral.strategy.ExampleClothes;

public class RainWearingStrategy implements IWearingStrategy {

    @Override
    public String getClothes() {
        return "coat";
    }

    @Override
    public String getAccessories() {
        return "umbrella}";
    }

}
