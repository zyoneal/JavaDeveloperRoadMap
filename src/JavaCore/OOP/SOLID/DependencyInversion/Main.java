package JavaCore.OOP.SOLID.DependencyInversion;

public class Main {

    public static void main(String[] args) {
        ModelForm form = new ModelForm(1, 30, "TEST");
        WebFramework webFramework = new WebFramework();
        webFramework.save(form);
    }

}
