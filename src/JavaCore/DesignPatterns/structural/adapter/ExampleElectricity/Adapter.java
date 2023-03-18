package structural.adapter.ExampleElectricity;

public class Adapter implements INewElectricitySystem {

    private OldElectricitySystem oldElectricitySystem;

    public Adapter(OldElectricitySystem oldElectricitySystem) {
        this.oldElectricitySystem = oldElectricitySystem;
    }

    @Override
    public String matchWideSocket() {
        return oldElectricitySystem.matchThisSocket();
    }

}
