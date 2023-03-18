package behavioral.strategy.ExampleClothes;

public class SunshineWearingStrategy implements IWearingStrategy{
    @Override
    public String getClothes() {
        return "T-shirt";
    }

    @Override
    public String getAccessories() {
        return "sunglasses";
    }

}
