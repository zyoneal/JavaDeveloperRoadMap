package JavaCore.OOP.SOLID.SingleResponsibility;

// Не создавать класс который делает все. Разделять на разные классы, которые выполняют свою работу.

// Класс должен иметь причину для изменения.
// Если Это компьютер, то изменять только то, что с ним связано. Логику других моделей сюда впутывать не надо.
public class Computer {

    String name;

    int memorySize;

    public Computer(String name, int memorySize) {
        this.name = name;
        this.memorySize = memorySize;
    }
    //================== NOT VALID ==============
//    public void saveToFile() {
//        System.out.println("Save to file");
//    }
//
//    public void saveToDB() {
//        System.out.println("Save to DB");
//    }

}
