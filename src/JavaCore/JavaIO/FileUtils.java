import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileUtils {
    // =================================FILE FUNCTIONS===============================================
    public void printIOFileDetails(String path) throws IOException {
        File file = new File(path);

        //Get path details
        System.out.println("About path " + file.getAbsolutePath());
        System.out.println("Relative path " + file.getPath());
        System.out.println("Free space in Mbyte " + file.getFreeSpace() / 1000000);
        System.out.println("Parent directory " + file.getParent());
        System.out.println("Is absolute path " + file.isAbsolute());

        System.out.println("Current directory is : " + System.getProperty("user.dir"));

        if (file.isDirectory()) {
            System.out.println("It is a directory. Printing content:");
            String[] list = file.list();
            if (list != null) {
                for (String el : list) {
                    System.out.println(el);
                }
            }
        } else {
            System.out.println("It is a file");
            System.out.println("Creating a new file " + file.createNewFile());
            //Permissions
            System.out.println("Can read - " + file.canRead());
            System.out.println("Can write - " + file.canWrite());
            System.out.println("Can execute - " + file.canExecute());
            System.out.println("File is hidden - " + file.isHidden());
            System.out.println("Last modified - " + file.lastModified());
            System.out.println("Deleting a file - " + file.delete());
            // получение обькта Путь из нашего файла. Смысла особого нет. Может пригодится если будем работать с старыми системами
            Path filePath = file.toPath();
            // Как можно работать с файлом. Output тоже можно
            // FileInputStream in = new FileInputStream(file);
            // BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        }
    }

    // =================================JAVA NIO======================================
    public void printNioFileDetails(String fileName) throws IOException {
        // получение относительного пути разными способами
        Path path = Paths.get(fileName);
        Path path1 = FileSystems.getDefault().getPath(fileName);
        Path path2 = Paths.get(System.getProperty("user.dir"), fileName);

        System.out.println("Получение имя файла " + path.getFileName());
        // чтобы получить корневую директорию и родительскую дирикторию нам нужен абсолютный путь
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Получение корневой дериктории " + absolutePath.getRoot());
        System.out.println("Преобразование относительного пути в абсолютный" + absolutePath);
        System.out.println("Получить родительскую директорию в которой мы находимся" + absolutePath.getParent());
        // Количество шагов чтобы дойти до файла. Если файл относительный, то кол-во = 1, если абсолютный, то будут считаться пути
        System.out.println("Количество шагов чтобы дойти до относительного файла " + path.getNameCount());
        System.out.println("Количество шагов чтобы дойти до абсолютного файла: " + absolutePath.getNameCount());
        // подпути
        System.out.println("Sub path : " + absolutePath.subpath(0,3));
        // Узнать реальный путь
        Path path3 = Paths.get("../../");
        System.out.println("Real path " + path3.toRealPath());
        // существует ли файл
        System.out.println("File exists " + Files.exists(path));
        System.out.println("File does not exists " + Files.notExists(path));
        // права доступа
        System.out.println("Is readable " + Files.isReadable(path));
        System.out.println("IsWritable " + Files.isWritable(path));
        System.out.println("isExecutable " + Files.isExecutable(path));

        //еквивалентность путей
        System.out.println("Is the same file " + Files.isSameFile(path,path1));
        //скопировать и переместить файл в новую созданую директорию
        // -получение родительской директории
        Path parentPath = absolutePath.getParent();
        // -resolve() - добавление части пути. Позволяет соединить существующий путь с директорией которую мы передали в параметр
        Path filesPath = parentPath.resolve("files");
        // проверяем существует ли такая директория. Если нет, то создаем ее
        if(Files.notExists(filesPath)) {
            Files.createDirectory(filesPath);
        }
        // скопировать файл в другую директорию
        Files.copy(absolutePath,filesPath.resolve(path), StandardCopyOption.REPLACE_EXISTING);
        //переместить файл в другую директорию
        Files.move(absolutePath,filesPath.resolve(path), StandardCopyOption.REPLACE_EXISTING);
        // Удалить файл в дириктории
        Files.delete(filesPath.resolve(path));
        // удалить директорию без файлов нельзя. Можно удалить дирикторию только без файлов.
        Files.delete(filesPath);
    }

    //=============================РАБОТА С ДИРЕКТОРИЯМИ==========================
    public void processDir() throws IOException {
        Path dir = Paths.get("temp");
        if (Files.notExists(dir)) {
            Files.createDirectory(dir);
        }
        // Создание иерархии директорий
        Files.createDirectories(Paths.get("temp/a/b/c"));
        // Создание временной директории
        Files.createTempDirectory(dir,"tmp");
        //посмотреть какие есть диски
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path rootDir : rootDirectories) {
            System.out.println(rootDir);
        }
        // Вывод содержимое директории
        // Если хотим вывести файлы с определенным расширением используем glob или filter
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(dir,"*.(txt)")) {
            for (Path p : paths) {
                System.out.println(p);
            }
        }
    }

}

