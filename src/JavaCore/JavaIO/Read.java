package JavaCore.JavaIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Read {

    public void readFromFile(String fileName) throws IOException {
        // читаем посимвольно, передаем это в bufferedReader, а он читает по строкам, пока не будет null
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String c;
        while ((c = reader.readLine()) != null) {
            System.out.println(c);
        }
    }

    public List<Student> readObjects(String fileName) {
        // инициализируем лист студентов который мы будем возвращать
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            boolean keepReading = true;
            while (keepReading) {
                // читаем обьект
                Student student = (Student) in.readObject();
                // Проверяем не равно ли имя пустой строке. Поменяли местами потому что имя может быть null
                if (!"".equals(student.getStudentName())) {
                    // записываем студента в лист
                    students.add(student);
                    // если есть пустое имя, то выходим из цикла и возвращаем лист
                } else {
                    keepReading = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to open files " + fileName + ", Program terminates");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid object type");
            e.printStackTrace();
        }
        return students;
    }

    public void readFileInFull(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    // FILE_NIO
    public void nioReadFileWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public void nioReadWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (InputStream in = Files.newInputStream(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public void nioReadWithChannel(String fileName) throws IOException {
        //ИЛИ ТАК
        // FileInputStream fileInputStream = new FileInputStream(fileName);
        // fileInputStream.getChannel();
        // FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        // fileOutputStream.getChannel();

        // ИЛИ ТАК
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();
        // указываем размер буфера (не большой -> 100 байт)
        ByteBuffer buffer = ByteBuffer.allocate(100);
        // набор байт который мы прочитали
        int bytesNumber = channel.read(buffer);
        // пока мы прочитали определенное количество байт - выполняем действия вывода
        while (bytesNumber > 0) {
            // перенос каретки на начало буфера
            buffer.flip();
            // пока у буфера есть символы
            while (buffer.hasRemaining()) {
                // посимвольно выполняем get. Если текстовая информация - кастим в char
                System.out.print((char) buffer.get());
            }
            // очищаем буфер (получаем новую информацию в буфер)
            buffer.clear();
            // читаем новую информацию
            bytesNumber = channel.read(buffer);
        }
        //закрываем канал
        channel.close();
    }

}
