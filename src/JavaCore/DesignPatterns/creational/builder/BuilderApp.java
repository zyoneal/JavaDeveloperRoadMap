package JavaCore.DesignPatterns.creational.builder;

//Строитель - вырисовывает стандартный процесс создания сложного
//объекта, отделяя логику строительства объекта от его представления.

public class BuilderApp {

    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Mercedes")
                .buildTransmition(Transmition.AUTO)
                .buildMaxSpeed(200)
                .build();

        System.out.println(car);
    }

}
