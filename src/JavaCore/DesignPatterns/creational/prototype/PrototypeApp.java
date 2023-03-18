package JavaCore.DesignPatterns.creational.prototype;

//Прототип позволяет нам создавать копии объектов, уже определенных на
//стадии дизайна (например, список возможных типов встреч) или же
//определяются во время выполнения программы («пятничная вечеринка»), таким
//Таким образом, отпадает необходимость заполнения всех элементов объекта от А до Я.
//Уже созданные или определенные экземпляры объекта называются
//прототипическими экземплярами (prototypical instances).

public class PrototypeApp {

    public static void main(String[] args) {
        Human original = new Human(18,"Vasya");
        System.out.println(original);
        Human copy = (Human)original.copy();
        System.out.println(copy);

        //через фабрику
        HumanFactory factory = new HumanFactory(copy);
        Human h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setPrototype(new Human(30,"Valeria"));
        Human h2 = factory.makeCopy();
        System.out.println(h2);
    }

}
