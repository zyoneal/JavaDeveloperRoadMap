package behavioral.strategy.ExampleClothes;

public class DefaultWearingStrategy implements IWearingStrategy {
    @Override
    public String getClothes() {
        return "sockers";
    }

    @Override
    public String getAccessories() {
        return "glasses";
    }
}
