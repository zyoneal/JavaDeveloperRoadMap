package JavaCore.Collections.SetAndMap.Map.TreeMap;

import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapRunner {

    public static void main(String[] args) {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
        printGrades(grades, false);
        // вывести больше заданого ключа
        AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade("", 80));
        //tailMap - от параметра до конца
        //headMap - от начала до параметра
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);

        System.out.println("=========================================");
        System.out.println("Scolarship students");
        // descendingMap - перевернуть коллекцию (мапу)
        printGrades(scholarshipStudents.descendingMap(), false);

        System.out.println("=========================================");
        System.out.println("Contender student");
        // ближайший студент меньше чем барьер
        AverageStudentGrade contender = grades.lowerKey(border);
        System.out.println(contender);
        System.out.println("=========================================");
        System.out.println("Highest student");
        // firstEntry - первый из мапы
        // lastEntry - последний из мапы
        System.out.println(grades.lastEntry());
    }

    private static void printGrades(Map<AverageStudentGrade, Set<SubjectGrade>> grades, boolean printValue) {
        // проходимся по мапе
        Set<AverageStudentGrade> averageStudentGrades = grades.keySet();
        // проходимся по ключам
        for (AverageStudentGrade gr : averageStudentGrades) {
            //печатаем ключ
            System.out.println(gr);
            // если передаем в метод true, то будет печататься и значение ключа, если false, то не будет
            if (printValue) {
                // по ключу выводим значение
                System.out.println(grades.get(gr));
            }
        }
    }

    public static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {
        // Создаем сеты , они будут как значения в мапе
        Set<SubjectGrade> alexGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 89));
        alexGrades.add(new SubjectGrade("Physics", 65));
        alexGrades.add(new SubjectGrade("History", 95));
        alexGrades.add(new SubjectGrade("Literature", 90));
        alexGrades.add(new SubjectGrade("Chemistry", 75));

        Set<SubjectGrade> jamesGrades = new HashSet<>();
        jamesGrades.add(new SubjectGrade("Mathematics", 75));
        jamesGrades.add(new SubjectGrade("Physics", 80));
        jamesGrades.add(new SubjectGrade("History", 55));
        jamesGrades.add(new SubjectGrade("Literature", 70));
        jamesGrades.add(new SubjectGrade("Chemistry", 80));

        Set<SubjectGrade> antonyGrades = new HashSet<>();
        antonyGrades.add(new SubjectGrade("Mathematics", 93));
        antonyGrades.add(new SubjectGrade("Physics", 91));
        antonyGrades.add(new SubjectGrade("History", 82));
        antonyGrades.add(new SubjectGrade("Literature", 78));
        antonyGrades.add(new SubjectGrade("Chemistry", 88));

        Set<SubjectGrade> victorGrades = new HashSet<>();
        victorGrades.add(new SubjectGrade("Mathematics", 73));
        victorGrades.add(new SubjectGrade("Physics", 65));
        victorGrades.add(new SubjectGrade("History", 75));
        victorGrades.add(new SubjectGrade("Literature", 66));
        victorGrades.add(new SubjectGrade("Chemistry", 50));

        Set<SubjectGrade> alinaGrades = new HashSet<>();
        alinaGrades.add(new SubjectGrade("Mathematics", 90));
        alinaGrades.add(new SubjectGrade("Physics", 70));
        alinaGrades.add(new SubjectGrade("History", 78));
        alinaGrades.add(new SubjectGrade("Literature", 88));
        alinaGrades.add(new SubjectGrade("Chemistry", 89));

        // создаем отсортированую мапу , в качестве ключа будет имя + средний бал,
        // в качестве значения будет Сет из того что мы создали.
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        // Кладем в мапу Имя + Средний бал , в качестве значения сет определенного обьекта с оценками
        map.put(new AverageStudentGrade("Alex", calcAverage(alexGrades)), alexGrades);
        map.put(new AverageStudentGrade("James", calcAverage(jamesGrades)), jamesGrades);
        map.put(new AverageStudentGrade("Antony", calcAverage(antonyGrades)), antonyGrades);
        map.put(new AverageStudentGrade("Victor", calcAverage(victorGrades)), victorGrades);
        map.put(new AverageStudentGrade("Alina", calcAverage(alinaGrades)), alinaGrades);
        //Возвращаем мапу
        return new TreeMap<>(map);
    }

    // Средний бал студента
    private static float calcAverage(Set<SubjectGrade> grades) {
        float sum = 0f;
        // В качестве параметра передаем сет определенного студента, проходим по нему
        for (SubjectGrade subjectGrade : grades) {
            // достаем оценки из каждого обьекта который хранится в хешсете и плюсуем все оценки
            sum += subjectGrade.getGrade();
        }
        // делим суму оценок на количество обьектов в хешсете
        return sum / grades.size();
    }

}
