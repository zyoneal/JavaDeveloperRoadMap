package JavaCore.OOP.Polymorphism;

// главный принцип полиморфизма - типо обьекта определяется не тем как он описан, а тем какой конструктор мы вызвали
public class Main {

    public static void main(String[] args) {
        Instrument instrument = new Piano("Piano");
        instrument.play("abvcbf");
        Instrument drum = new Drum("Drum");
        drum.play("gfdhfds");

        // ==============================================

        Instrument [] instruments = new Instrument[5];
        instruments[0] = new Drum("Drum");
        instruments[1] = new Drum("Drum2");
        instruments[2] = new Drum("Drum3");
        instruments[3] = new Drum("Drum4");
        instruments[4] = new Piano("Piano");

        for (int i = 0; i < instruments.length; i++) {
            instruments[i].play("safgsadf");
        }
    }

}
