package JavaCore.DesignPatterns.structural.composite.ExampleDocuments;

import java.util.ArrayList;
import java.util.List;

public class DocumentComponent implements IDocumentComponent {

    public String name;

    private List<IDocumentComponent> documentComponentList;

    public DocumentComponent(String name) {
        this.name = name;
        this.documentComponentList = new ArrayList<>();
    }

    @Override
    public String gatherData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        for (IDocumentComponent documentComponent : documentComponentList) {
            documentComponent.gatherData();
            stringBuilder.append(documentComponent.gatherData());
        }
        stringBuilder.append(name);
        return stringBuilder.toString();
    }

    @Override
    public void addComponent(IDocumentComponent documentComponent) {
        documentComponentList.add(documentComponent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IDocumentComponent> getDocumentComponentList() {
        return documentComponentList;
    }

    public void setDocumentComponentList(List<IDocumentComponent> documentComponentList) {
        this.documentComponentList = documentComponentList;
    }

}
