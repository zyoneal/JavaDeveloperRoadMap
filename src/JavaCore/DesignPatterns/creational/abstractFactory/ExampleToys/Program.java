package creational.abstractFactory.ExampleToys;

// Один интерфейс мешка, но разные его реализации.
// Из одного достаем мягкие игрушки, из другого деревянные.
// План: 1) Создать фабрику-интерфейс который в методах возвращает обьекты абстрактного класса
//       2) Создать разные реализации фабрики которые реализуют методы абстрактной фабрики и возвращают в них определенные обьекты. (конкретно под определенную фарбрику)
public class Program {
    public static void main(String[] args) {
        ToysFactory toysFactory = new TeddyToysFactory();
        toysFactory.getBear();
        toysFactory.getCat();

        ToysFactory woodenToysFactory = new WoodenToysFactory();
        woodenToysFactory.getBear();
        woodenToysFactory.getCat();
    }
}
