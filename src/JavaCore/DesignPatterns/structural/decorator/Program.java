package JavaCore.DesignPatterns.decorator;

// Декоратор используется для предоставления некоторой дополнительной
//функциональности нашим объектам

import JavaCore.DesignPatterns.decorator.objects.Component;
import JavaCore.DesignPatterns.decorator.objects.TextView;
import JavaCore.DesignPatterns.decorator.objects.Window;

public class Program {

    private static Component window;

    private static Component textView;

    public static void main(String[] args) {
        // без декоратора
//        Component window = new Window();
//        window.draw();

        // использование декоратора (добаления нового функционала)
//        Component windowWithBorder = new BorderDecorator(new Window());
//        windowWithBorder.draw();

        // Вложение декоратора 1 в другой (2 новых функционала)
//        Component windowWithBorderСolor = new ColorDecorator(new BorderDecorator(new Window()));
//        windowWithBorderСolor.draw();

        boolean showBorder = true;
        if (!showBorder) {
            window = new Window();
            textView = new TextView();
        } else {
            window = new BorderDecorator(new Window());
            textView = new BorderDecorator(new TextView());
        }

        window.draw();
        textView.draw();
    }

}
