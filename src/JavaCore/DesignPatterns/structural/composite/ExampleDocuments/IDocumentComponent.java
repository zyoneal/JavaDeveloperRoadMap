package JavaCore.DesignPatterns.structural.composite.ExampleDocuments;

public interface IDocumentComponent {

    String gatherData();

    void addComponent(IDocumentComponent documentComponent);

}
