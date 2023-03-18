package behavioral.strategy.ExampleAuth.start;// Выбор одного из семейства алгоритмов для выполнения действия
// Выбор алгоритма зависит от переданой реализации в параметр
// Не зависит от конкретных реализаций
// Смысл действия один, реализации - разные
// Классический пример - сортировка JavaCore.Collections.sort()
//===================== Отличия от паттерна State =====================
// Не хранит ссылку на обьект
// Одноразовое действие


import behavioral.strategy.ExampleAuth.DBAuth;
import behavioral.strategy.ExampleAuth.FileAuth;
import behavioral.strategy.ExampleAuth.auth.UserChecker;

import java.io.File;

public class Program {

    public static void main(String[] args) {
        UserChecker userChecker = new UserChecker();
        userChecker.check(new DBAuth("students:db"));
        userChecker.check(new FileAuth(new File("c:\\file.txt")));
    }

}
