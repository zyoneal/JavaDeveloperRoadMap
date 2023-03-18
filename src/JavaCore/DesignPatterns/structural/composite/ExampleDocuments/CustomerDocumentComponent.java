package JavaCore.DesignPatterns.structural.composite.ExampleDocuments;

public class CustomerDocumentComponent implements IDocumentComponent {

    private int customerIdToGatherData;

    public CustomerDocumentComponent(int customerIdToGatherData) {
        this.customerIdToGatherData = customerIdToGatherData;
    }

    @Override
    public String gatherData() {
        String customerData;
        switch (customerIdToGatherData) {
            case 41: customerData = "Viktor Piven";
            break;
            default: customerData = "Default";
            break;
        }
        return customerData;
    }

    @Override
    public void addComponent(IDocumentComponent documentComponent) {
        System.out.println("can't");
    }
}
