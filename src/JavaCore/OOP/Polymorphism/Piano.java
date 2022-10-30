package JavaCore.OOP.Polymorphism;

public class Piano extends Instrument {

    public Piano(String name) {
        super(name);
    }

    @Override
    protected void playNote(char note) {
        System.out.print("p:" + note + " ");
    }

}
