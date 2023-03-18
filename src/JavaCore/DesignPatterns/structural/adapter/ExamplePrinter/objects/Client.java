package JavaCore.DesignPatterns.structural.adapter.ExamplePrinter.objects;

//Адаптер предоставляет возможность пользоваться объектом, не являющимся
//приемлемым в нашей системе и нельзя изменить. Мы адаптируем
//его функциональность через другой, известный нашей системе, интерфейс

// помогает двум разным интерфейсам работать вместе
// реализуется 2 способами: наследованием и композицией

import JavaCore.DesignPatterns.structural.adapter.ExamplePrinter.PrinterAdapter;

import java.util.ArrayList;
import java.util.List;

// Клиент который хочет печатать сразу много текста
// работает с адаптером, а не с принтером напрямую

public class Client {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("text1");
        list.add("text2");
        list.add("text3");
        list.add("text4");

        PrinterAdapter printerAdapter = new PrinterAdapter();
        printerAdapter.print(list);
    }

}
