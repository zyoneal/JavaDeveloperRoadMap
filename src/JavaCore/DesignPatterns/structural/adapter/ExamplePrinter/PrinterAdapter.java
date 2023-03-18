package JavaCore.DesignPatterns.structural.adapter.ExamplePrinter;


import JavaCore.DesignPatterns.structural.adapter.ExamplePrinter.objects.Printer;

import java.util.List;

// Адаптер который совмещаем желание клиента и возможности принтера
public class PrinterAdapter implements PageListPrinter{

    private Printer printer = new Printer();

    @Override
    public void print(List<String> list) {
        for (String text : list) {
            printer.print(text);
        }

    }

}
