package structural.flyweight.ExampleShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Легковаговик обеспечивает поддержку большого количества объектов путем
//выделение общей информации для сохранения в одном
//экземпляре.

// Шаблон проектирования Flyweight (Приспособленец) предназначен для уменьшения количества объектов в приложении путем совместного их использования.
// Flyweight дополняет шаблон Factory Method таким образом, что при обращении клиента к Factory Method
// для создания нового объекта ищет уже созданный объект с такими же параметрами, что и у требуемого, и возвращает его клиенту.
// Если такого объекта нет, то фабрика создаст новый.

public class FlyweightApp {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("точка"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("точка"));

        Random rand = new Random();
        for (Shape shape : shapes) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x, y);
        }
    }

}

// flyweight
interface Shape {

    void draw(int x, int y);

}

class Point implements Shape {

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + ") : рисуем точку");
    }

}

class Circle implements Shape {

    int r = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + ") : рисуем круг с радиусом " + r);
    }

}

class Square implements Shape {

    int a = 10;

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + ") : рисуем квадрат со строной " + a);
    }

}

class ShapeFactory {
    public static final Map<String, Shape> shapes = new HashMap<>();


    public Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if (shapeName == null) {
            switch (shapeName) {
                case "круг":
                    shape = new Circle();
                    break;
                case "квадрат":
                    shape = new Square();
                    break;
                case "точка":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }

}