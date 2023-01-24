package JavaCore.DesignPatterns.proxy;

// Прокси подменяет реальный объект и посылает запросы к нему, когда
//это нужно. Прокси также может инициализировать реальный объект, если он
//до этого не существовал.

// Шаблон проектирования Прокси, он же Заместитель, он же Суррогат, предназначен для косвенного обращения к объекту.
// То есть обращение к методам реального объекта происходит через объект-заместитель (прокси).

public class ProxyApp {

    // пример что бы избежать загрузку в конструкторе
    public static void main(String[] args) {

        Image realImage = new RealImage("D:/image/my.jpg");
        realImage.display();

        Image proxyImage = new ProxyImage("D:/image/my.jpg");
        proxyImage.display();
    }

}

interface Image {

    void display();

}

class RealImage implements Image {

    String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    @Override
    public void display() {
        System.out.println("Просмотр " + file);
    }

    void load() {
        System.out.println("Загрузка " + file);
    }

}

class ProxyImage implements Image {

    String file;

    RealImage image;

    public ProxyImage(String file) {
        this.file = file;
    }

    // Загрузка только тогда когда будет просматриваться картинка, а не сразу как в реальной картинке
    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }

}
