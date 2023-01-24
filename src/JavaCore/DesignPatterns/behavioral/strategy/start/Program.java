package JavaCore.DesignPatterns.strategy.start;

// Выбор одного из семейства алгоритмов для выполнения действия
// Выбор алгоритма зависит от переданой реализации в параметр
// Не зависит от конкретных реализаций
// Смысл действия один, реализации - разные
// Классический пример - сортировка JavaCore.Collections.sort()
//===================== Отличия от паттерна State =====================
// Не хранит ссылку на обьект
// Одноразовое действие


import JavaCore.DesignPatterns.strategy.DBAuth;
import JavaCore.DesignPatterns.strategy.FileAuth;
import JavaCore.DesignPatterns.strategy.auth.UserChecker;

import java.io.File;

public class Program {

    public static void main(String[] args) {
        UserChecker userChecker = new UserChecker();
        userChecker.check(new DBAuth("students:db"));
        userChecker.check(new FileAuth(new File("c:\\file.txt")));
    }

}
