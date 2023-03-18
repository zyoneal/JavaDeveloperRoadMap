import SetAndMap.Map.TreeMap.AverageStudentGrade;
import SetAndMap.Map.TreeMap.SubjectGrade;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Write {

    public void writeToFileFromConsole() throws FileNotFoundException {
        // ЗАПИСЬ В ФАЙЛ ЧЕРЕЗ КОНСОЛЬ
        Formatter formatter = new Formatter("BankAccounts.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter client id, client name, balance");
        int i = 0;
        while (i < 3) {
            try {
                formatter.format("%d. %s %s %.2f%n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Input is incorrect. Please try again");
                scanner.nextLine();
            }
        }
        formatter.close();
    }

    public void writeToFile(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, String fileName) throws IOException {
        // можно использовать просто FileWriter, а можно обернуть его в PrintWriter или в BufferedWriter. Одно и тоже.
        // PrintWriter набирает в буфер и потом уже записывает
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (AverageStudentGrade gradeKey : grades.keySet()) {
                writer.write("=============================\n");
                writer.write("Student " + gradeKey.getName() + " Average Grade " + gradeKey.getAverageGrade() + "\n");
                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("Subject: " + grade.getSubject() + " Grade: " + grade.getGrade() + "\n");
                }
            }
        }
    }

    public void writeObject(List<Student> students, String fileName) {
        //для записи в бинарный файл используется ObjectOutputStream, в его конструктор передаетсся другой стрим куда надо сохранять обьекты
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            // проходимся по листу студентов
            for (Student student : students) {
                // записываем каждого студента
                out.writeObject(student);
            }
            // записываем еще 1 студента для инициализации конца чтобы можно было прочитать
            out.writeObject(new Student("", -1, null));
            // ловим ошибку если файл не удается открыть
        } catch (IOException e) {
            System.out.println("File cannot be opened. Program terminates");
            e.printStackTrace();
        }
    }

    public void nioWriteWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            writer.write(fileName, 0, fileName.length());
        }
    }

    public void nioWriteWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String str = "File cannot be opened. Program terminates";
        byte[] bytes = str.getBytes();
        try (OutputStream stream = Files.newOutputStream(path, CREATE, APPEND)) {
            stream.write(bytes, 0, bytes.length);
        }
    }

    public void nioWriteWithChannel(String fileName) throws IOException {
        String str = "I don't need an excuse to squeeze her in my arms and heal her burns.";
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();
        //ИЛИ
        // ByteBuffer buffer = ByteBuffer.allocate(str.getBytes().length);

        //ИЛИ
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        channel.write(buffer);
        channel.close();

        // у ByteBuffer есть такие методы:
        // buffer.clear();
        //удалить все данные которые были прочитаны, и начать читаь где мы остановились в прошлый раз
        // buffer.compact();
        //обозначить позицию
        // buffer.mark();
        //отресетить наш позишн до того места где мы поставили марк
        // buffer.reset();
    }

    public void writeWithRandomAccess(String fileName) throws IOException {
        ByteBuffer mark = ByteBuffer.wrap("MARKED AREA".getBytes());

        ByteBuffer buffer = ByteBuffer.allocate(100);
        Path path = Paths.get(fileName);
        try (FileChannel openedFile = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            // прочитали первых 10 символов и сохранили в буффер
            int numBytes = 0;
            while (buffer.hasRemaining() && numBytes != -1) {
                numBytes = openedFile.read(buffer);
            }
            // переходим в начало нашего файла и записываем строку
            openedFile.position(0);
            openedFile.write(mark);
            long size = openedFile.size();
            openedFile.position(size / 2);
            // устанавливает позицию на 0 точку
            mark.rewind();
            openedFile.write(mark);
            openedFile.position(size - 1);
            mark.rewind();
            openedFile.write(mark);
            buffer.rewind();
            openedFile.write(buffer);
        }
    }

}
