public class Dog {

    public static int dogCount;

    public static final int PAWS = 4;

    public static final int TAIL = 1;

    private String name;

    private String breed;

    private Size size = Size.UNDEFINED;

    public Dog() {
        dogCount++;
        System.out.println("Dog count = " + dogCount);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void bark() {
        switch (size) {
            case BIG, VERY_BIG -> System.out.println("wof-wof");
            case AVERAGE -> System.out.println("Raf - raf");
            case SMALL, VERY_SMALL -> System.out.println("Tiaf - tiaf");
            default -> System.out.println("Dog's size undefined");
        }
    }

    public void bite() {
        if (dogCount > 2) {
            System.out.println("Dogs can bite you!");
        } else bark();
    }

}
