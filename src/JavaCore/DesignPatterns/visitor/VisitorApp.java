package JavaCore.DesignPatterns.visitor;
// Посетитель (Visitor) позволяет отделить определенный алгоритм от элементов,
//на каких алгоритм должен быть выполнен, таким образом позволяя легко
//добавить или изменить алгоритм без изменения элементов системы.

// Используется что бы не делать действия (логику не в самом классе, а в посетителе)
public class VisitorApp {

    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor mechanic = new MechanicVisitor();

        body.accept(mechanic);
        engine.accept(mechanic);
    }

}

// Посетитель(Визитор)
interface Visitor {

    void visit(EngineElement engine);

    void visit(BodyElement body);

}

// Элемент - Автозапчасть
interface Element {

    void accept(Visitor visitor);

}

// Кузов
class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

// Двигатель
class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по корпусу");
    }

}

class MechanicVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Отполировал кузов");
    }

}