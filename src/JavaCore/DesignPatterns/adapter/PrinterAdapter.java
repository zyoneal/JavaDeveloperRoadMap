package JavaCore.DesignPatterns.adapter;


import JavaCore.DesignPatterns.adapter.objects.Printer;

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
