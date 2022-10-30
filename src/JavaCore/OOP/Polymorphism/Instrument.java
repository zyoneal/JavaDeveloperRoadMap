package JavaCore.OOP.Polymorphism;

// Нельзя создать обьект этого класса. (abstract)
// final class - не позволяет от него наследоваться. final class не может быть abstract
public abstract class Instrument {

    private final String name;

    public Instrument(String name) {
        this.name = name;
    }


    public void play(String melody) {
        System.out.println(name);
        for (int i = 0; i < melody.length(); i++) {
            playNote(melody.charAt(i));
        }
        System.out.println();
    }

    // Чисто виртуальная функция (abstract - этот метод могут использовать только наследники.
    // Нельзя писать реализацию метода в этом классе, а будет только в его наследниках .
    protected abstract void playNote(char note);

}
