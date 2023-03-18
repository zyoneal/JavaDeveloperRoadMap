package Polymorphism;

public class Drum extends Instrument {

    public Drum(String name) {
        super(name);
    }

    @Override
    protected void playNote(char note) {
        System.out.print("d:" + note + " ");
    }

}
