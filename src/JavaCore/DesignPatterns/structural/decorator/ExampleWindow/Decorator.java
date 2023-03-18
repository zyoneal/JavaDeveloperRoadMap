package JavaCore.DesignPatterns.structural.decorator.ExampleWindow;
// Другое название - обертка
// Расширение функционала обьекта без дочерних классов (альтернатива наследованию)
// Более гибкий способ добавить новый функционал к любому существующему обьекту
// Возможность включения и исключения нового поведения для любого обьекта в любое время
//(в отличии от статичного способа с помощью наследования)
// Когда нельзя создвавать дочерний класс, но можно добавить новое поведение,
// которое может быть не связано по смыслу (в наследовании желательно поддерживать связь "является")
// Декораторы могут вкладываться друг в друга

import JavaCore.DesignPatterns.structural.decorator.ExampleWindow.objects.Component;

public abstract class Decorator implements Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public abstract void afterDraw();

    @Override
    public void draw() {
        component.draw();
        afterDraw();
    }

}
