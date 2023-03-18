package JavaCore.DesignPatterns.behavioral.templateMethod.ExampleMessages;

import java.time.LocalDateTime;

public class ImportantMessagesSearcher extends MessagesSearcher {
    public ImportantMessagesSearcher(LocalDateTime dateTime, String personName) {
        super(dateTime, personName, 3);
    }

    @Override
    void createDateCriteria() {

    }

    @Override
    void createSentPersonCriteria() {

    }

    @Override
    void createImportanceCriteria() {
        System.out.println("Important");
    }

}
