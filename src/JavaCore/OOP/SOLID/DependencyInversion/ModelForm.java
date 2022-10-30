package JavaCore.OOP.SOLID.DependencyInversion;

public class ModelForm implements IForm{

    private int id;

    private int old;

    private String fio;

    public ModelForm(int id, int old, String fio) {
        this.id = id;
        this.old = old;
        this.fio = fio;
    }

}
