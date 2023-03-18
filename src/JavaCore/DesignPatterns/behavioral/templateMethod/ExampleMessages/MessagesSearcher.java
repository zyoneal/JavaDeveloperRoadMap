package behavioral.templateMethod.ExampleMessages;

import java.time.LocalDateTime;

public abstract class MessagesSearcher {

    LocalDateTime dateTime;

    String personName;

    int importanceLevel;

    public MessagesSearcher(LocalDateTime dateTime, String personName, int importanceLevel) {
        this.dateTime = dateTime;
        this.personName = personName;
        this.importanceLevel = importanceLevel;
    }

    abstract void createDateCriteria();

    abstract void createSentPersonCriteria();

    abstract void createImportanceCriteria();

    //template method
    public String search() {
        createDateCriteria();
        createSentPersonCriteria();
        System.out.println("Template method does some verification accordingly to\n" +
                "search algo.");
        createImportanceCriteria();
        System.out.println("Template method verifies if message could be so\n" +
                "important or useless from person provided in criteria.");
        System.out.println();
        return "Some list of messages...";
    }

}
