package JavaCore.Collections.SetAndMap.Map.HashMap;

import JavaCore.Collections.SetAndMap.Map.WordWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// HashMap - ассоциативный массив
// при использовании хешмапы, в ключ нужно имплементить equals() и hashCode()
// тип ключа должен быть неизменяемым (все поля должны быть файнал, и не должно быть сеттеров)
// не создавать подклассы нашего класса (обьявить класс как final)
// если переменная типа обьекта, то тот обьект тоже должен быть final

public class MapLauncher {

    public static void main(String[] args) {
        // Map<Car,Integer> map = new HashMap<>();
        // map.put(new Car("VW", "Golf", 45),45);
        // map.put(new Car("Audi", "A3", 60),60);
        // map.put(new Car("VW", "Polo", 35),35);   System.out.println(map.get(new Car("VW", "Polo", 35)));

        // Map<String,Integer> map = new HashMap<>();
        // map.put("VW",45);
        // map.put("Audi",60);
        // System.out.println(map.put("VW", 35));
        // System.out.println(map.put("VW", 25));

        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("Please enter some text");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] tokens = string.split(" ");
        for (String token : tokens) {
            String word = token.toLowerCase();
            // если нет такого слова , то нулл и пихаем в мапу это слово
            // Если есть такое слово и каунт не нулл, то значение ++
            Integer count = wordMap.get(word);
            if (count == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, count + 1);
            }
        }
        NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);
        // printMap(wordMap);
        printSet(wordWrappers);
    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {

        for (WordWrapper wordWrapper : wordWrappers) {
            System.out.println(wordWrapper);
        }
    }

    // ПРИМЕР КАК ПРОЙТИ ПО МАПЕ

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {
        // Удалить элемент
        // wordMap.remove("that");
        // заменить значение по ключу
        // wordMap.replace("voices", 1213);
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }
        // Возвращать коллекции в таком виде, только если мы хотим что бы наша коллекция не изменялась!!
        // return (NavigableSet<WordWrapper>) Collections.unmodifiableSet(wordSet);
        // Возвращать коллекции в таком виде!!
        return new TreeSet<>(wordSet);
    }

    private static void printMap(Map<String, Integer> wordMap) {
        // если надо отсортировать по ключу , используем TreeMap.
        Map<String, Integer> wordTreeMap = new TreeMap<>(wordMap);
        Set<String> keys = wordTreeMap.keySet();
        for (String key : keys) {
            System.out.printf("%-10s%-10s \n", key, wordMap.get(key));
        }
    }

}
