package JavaCore.OOP.SOLID.LiskovSubstitution;

public class Main {

    // Подклассы должны заменять свои базовые классы.
    // 1) Если есть дочерний класс, то он должен полностью повторять базовый функционал своего базового класса
    // Можно только расширять функционал, но никок не менять существуещее присвоение.

    // 2) Дочерний метод должен соответствовать той же БАЗОВОЙ СИГНАТУРЕ, что и родительский.
    // т.е. если у тебя базовый метод принимает число, как аргумент, и возвращает число, то и дочерний метод должен делать то же самое:
    // иметь ПЕРВЫМ аргументом число, и возвращать число.

    // Но это не значит, что я в дочерний метод не могу вторым аргументом добавить строку, например.
    // и это не означает, что в теле метода я не могу реализовать другую работу, нежели в базовом.

    public static void main(String[] args) {
        Computer computer = new Computer("IBM", 5000);

        test();
    }

    public static void test() {
        Computer computer = new Computer("IBM", 5000);
        Computer computer2 = new OmenHP("Omen HP", 5000);

        computer2.setData("IBM"); // -> тут должно поменяться только поле name, как написано в базовом классе.
        if ((computer.name.compareTo(computer2.name) == 0) && (computer.memorySize == computer2.memorySize)) {
            System.out.println("Test OK");
        } else System.out.println("Test failed");
    }

}
