package SOLID.OpenClosed;

public class Main {

    // Open-Closed Principle -> добавлять новый код не меняя старый. (Создать интерфейс с методом который могут юзать разные классы,
    // потом не добавлять много методов с одинаковым телом в один класс, а добалять новые классы реализуя метод в интерфейсе)
    // Существующие классы не нужно модифицировать, что бы добавить новый функционал

    public static void main(String[] args) {
        Computer computer = new Computer("IBM", 8000);
        Saveable saverToFile = new SaveComputerToFile();
        Saveable saverToDB = new SaveComputerToDB();
        saverToFile.save("out.dat", computer);
        saverToDB.save("postgesql", computer);
    }

}
