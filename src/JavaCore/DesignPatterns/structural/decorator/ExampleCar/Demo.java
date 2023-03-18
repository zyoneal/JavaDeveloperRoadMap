package structural.decorator.ExampleCar;

public class Demo {

    public static void main(String[] args) {
        AmbulanceCar doctorDreams = new AmbulanceCar(new Mercedes());
        doctorDreams.go();
    }

}
