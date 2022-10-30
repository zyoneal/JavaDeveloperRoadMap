package JavaCore.OOP.SOLID.DependencyInversion;

public class WebFramework {
    // Так как форм может быть много, то нужно передавать в метод абстракцию форм (Интерфейс который будут имплементить классы форм)
    public void save(IForm modelForm) {
        // Так как может быть много разных баз данных, то для них тоже надо создать интерфейс-абстракцию
        Database db = new MySQL();
        db.save(modelForm);
    }

}
