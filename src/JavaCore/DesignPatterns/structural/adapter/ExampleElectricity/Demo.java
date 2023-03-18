package structural.adapter.ExampleElectricity;

public class Demo {

    public static void main(String[] args) {
        var newElectricitySystem = new NewElectricitySystem();
        CarElectricityConsumer.chargeNotebook(newElectricitySystem);

        var oldElectricitySystem = new OldElectricitySystem();
        var adapter = new Adapter(oldElectricitySystem);
        CarElectricityConsumer.chargeNotebook(adapter);
    }
    
}
