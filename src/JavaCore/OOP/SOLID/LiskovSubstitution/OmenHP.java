package JavaCore.OOP.SOLID.LiskovSubstitution;

public class OmenHP extends Computer {

    public OmenHP(String name, int memorySize) {
        super(name, memorySize);
    }

    // Нарушение принцип Барбары Лисков ( Если вызывать этот метод у базового класса, то он будет изменять только переменную name)
    // если вызывать из этого класса этот же метод, то он меняет name + memorySize)
//    @Override
//    public void setData(String name) {
//        this.name = name;
//        this.memorySize = 8000;
//    }

    // Valid -> расширяем функционал, но не меняем то, что уже есть
    @Override
    public void setData(String name) {
        super.setData(name);
        System.out.println("hello " + name);
    }

}
