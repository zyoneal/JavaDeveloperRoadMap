public class MainApp {

    public static void main(String[] args) {
        System.out.println("Start dog count value = " + Dog.dogCount);

        Dog lab = new Dog();
        lab.setName("Max");
        lab.setBreed("Spaniel");
        /* lab.setSize(Size.VERY_BIG);*/
        lab.bite();

        Dog ovcharka = new Dog();
        ovcharka.setName("Petya");
        ovcharka.setBreed("Ovcharka");
        ovcharka.setSize(Size.AVERAGE);
        ovcharka.bite();

        Dog sheppard = new Dog();
        sheppard.setName("Vasya");
        sheppard.setBreed("Sheppard");
        sheppard.setSize(Size.SMALL);
        sheppard.bite();

      /*  Size size = Size.SMALL;
        Size s = Size.valueOf("BIG");
        System.out.println(s);*/

      /*  Size[] values = Size.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }*/
    }

}
