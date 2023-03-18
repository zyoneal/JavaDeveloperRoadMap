package behavioral.templateMethod.ExampleMessages;

import java.time.LocalDateTime;

public class UselessMessageSearcher extends MessagesSearcher{
    public UselessMessageSearcher(LocalDateTime dateTime, String personName) {
        super(dateTime, personName, 1);
    }

    @Override
    void createDateCriteria() {

    }

    @Override
    void createSentPersonCriteria() {

    }

    @Override
    void createImportanceCriteria() {
        System.out.println("USELESS");
    }
}
