package JavaCore.DesignPatterns.behavioral.templateMethod.ExampleMessages;

import java.time.LocalDateTime;

public class Demo {

    public static void main(String[] args) {
        MessagesSearcher searcher = new UselessMessageSearcher(LocalDateTime.now(),"Viktor");
        searcher.search();

        MessagesSearcher searcher2 = new ImportantMessagesSearcher(LocalDateTime.now(),"Killer");
        searcher.search();
    }

}
