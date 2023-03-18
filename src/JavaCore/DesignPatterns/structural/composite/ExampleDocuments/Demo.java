package JavaCore.DesignPatterns.structural.composite.ExampleDocuments;

import java.awt.*;

public class Demo {

    public static void main(String[] args) {
        DocumentComponent composableDocument = new DocumentComponent("ComposableDocument");

        DocumentComponent body = new DocumentComponent("Body");

        composableDocument.addComponent(body);

        CustomerDocumentComponent customerDocumentComponent = new CustomerDocumentComponent(41);
        new DocumentComponent("Orders");

        body.addComponent(customerDocumentComponent);

        String gatherData = composableDocument.gatherData();

        System.out.println(gatherData);
    }

}
