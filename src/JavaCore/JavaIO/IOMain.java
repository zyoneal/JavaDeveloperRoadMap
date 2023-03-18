import SetAndMap.Map.TreeMap.AverageStudentGrade;
import SetAndMap.Map.TreeMap.SubjectGrade;
import SetAndMap.Map.TreeMap.TreeMapRunner;

import java.io.*;
import java.util.*;

// byte based stream - байтовый поток
// character based stream - символьный поток
// символьный файл
// бинарный файл
// серриалзация

// ПУТЬ - адрес нашего файла в ный путь.файловой системе
//// есть абсолютный и относитель Относительный путь будет начинаться в том месте в котором была запущена jvm.
// ОТНОСИТЕЛЬНЫЙ ПУТЬ
// ./files - . (текущая дериктория), /(разделитель дерикторий)
// ../ - родительская дериктория относительно той в которой мы находимся
// System.out.println(System.getProperty("user.dir")); - получение текущей дериктории

//ПРЕФИКС
// D:\\ - в java; D:\ - в файловой системе. \\ используется для того чтобы показать что это именно слеш как символ
// \\\\hostname\share\ - для сети

// JAVA.IO vs JAVA.NIO
// java.io - блокирует потоки, а java.nio - не блокирует потоки (выполняет синхронизацию потоков)

public class IOMain {

    private static final String FILE_NAME = "gradeBook.txt";

    private static final String TEST_FILE_NAME = "test.txt";

    private static final String BINARY_FILE_NAME = "Students.bin";

    public static void main(String[] args) throws IOException {
    SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
    // РАБОТА С ТЕКСТОВЫМ ФАЙЛОМ
    Read reader = new Read();
    Write write = new Write();
    // запись в файл
    // write.writeToFile(grades, FILE_NAME);
    // запись в файл через консоль
    // write.writeToFileFromConsole();
    // чтение из файла
    // reader.readFromFile(FILE_NAME);
    // байтовый поток чтения и записи
    // readAndWriteToFileStreamsBadExample();

    // СОХРАНЕНИЕ ОБЬЕКТОВ В ФАЙЛ
    // запись в файл
    // processGrades(grades, write, BINARY_FILE_NAME);
    // чтение и вывод
    // outputObjects(reader,BINARY_FILE_NAME);

    FileUtils fileUtils = new FileUtils();
    //Информация о файле FILE_IO
//    fileUtils.printIOFileDetails(TEST_FILE_NAME);
        //Информация о директории FILE_IO
//        fileUtils.printIOFileDetails("./");
        //Информация о файле через FILE_NIO
//        fileUtils.printNioFileDetails(TEST_FILE_NAME);
        //Чтение файла через FILE_NIO
//        reader.readFileInFull("combinations.txt");
        //Чтение файла через FILE_NIO с использованием BufferedReader
//        reader.nioReadFileWithBuffer("combinations.txt");
        //Запись в файл через FILE_NIO
//        write.nioWriteWithBuffer("nio.txt");
        //Чтение файла через FILE_NIO с использованием InputStream который мы завернули в BufferedReader
//        reader.nioReadWithStream("nio.txt");
        //Запись в файл через OutputStream
//        write.nioWriteWithStream();
        //Чтение файла через FILE_NIO (Channel + Buffer)
//        reader.nioReadWithChannel("nio.txt");
        //Запись в файл через FILE_NIO (Channel + Buffer)
//        write.nioWriteWithChannel(BINARY_FILE_NAME);
        //Запись и чтение в случайную часть файла
//        write.writeWithRandomAccess(FILE_NAME);
        //Работа с директориями
        fileUtils.processDir();
    }

    // передаем в метод мапу из оценок, Клас с функциями записи, имя файла
    private static void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Write write, String fileName) {
        // создаем лист студентов
        List<Student> students = new ArrayList<>();
        // проходимся по ключам мапы , вытаскиваем оттуда все поля и значение мапы и добавляем все в лист студентов
        for (AverageStudentGrade gradeKey : grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }
        // записываем в бинарный файл лист студентов, передавая коллекцию + имя файла
        write.writeObject(students, fileName);


    }

    private static void outputObjects(Read read, String fileName) {
        //записываем прочитаный лист в переменную
        List<Student> students = read.readObjects(fileName);
        //проходимся по листу и выводим ключ
        for (Student student : students) {
            System.out.printf("%s %.2f %n",student.getStudentName(),student.getAverageGrade());
            //у каждого студента печатаем значение
            System.out.println(student.getGrades());
        }
    }


    private static void readAndWriteToFileStreamsBadExample() throws IOException {
        // читать и записывать по одному бату как показано ниже - не эфективно (Много повторов)
        // всегда надо использовать BufferedReader, BufferedWriter
        // При использовании BufferedReader, BufferedWriter есть возможность использовать flushing(выполнять запись всего, что записано в буфере на диск)
        try (FileInputStream reader = new FileInputStream(FILE_NAME);
             FileOutputStream writer = new FileOutputStream("gradeBookByte.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print(c);
                writer.write(c);
            }
        }
    }

}
