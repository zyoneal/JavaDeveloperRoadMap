package structural.adapter.ExampleElectricity;

public class CarElectricityConsumer {

    public static void chargeNotebook(INewElectricitySystem electricitySystem) {
        System.out.println(electricitySystem.matchWideSocket());
    }
}
