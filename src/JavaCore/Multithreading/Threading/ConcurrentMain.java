package JavaCore.Multithreading.Threading;

import static JavaCore.Multithreading.Threading.ColorScheme.GREEN;
import static JavaCore.Multithreading.Threading.ColorScheme.YELLOW;

public class ConcurrentMain {
    // потоки создаются хаотично.
    // запускать потоки нужно через метод start(), а не через метод run(). Если запускать через run() - будет выполнятся 1 поток main().
    // Создавать потоки такими способами нужно если у вас мало потоков. Если много потоков есть другие способы (Daemon потоки).
    public static void main(String[] args) {
        // Первый способ создания потока
        SimpleThread tread1 = new SimpleThread();
        tread1.start();

        SimpleThread thread2 = new SimpleThread();
        thread2.start();
        //прерывание потока
        thread2.interrupt();

        // Второй способ создания потока
        Thread thread3 = new Thread(new SimpleRunner());
        thread3.start();

        // Третий способ создания потока
        new Thread(() -> System.out.println("Hello from Lambda runnable")).start();

        System.out.println("Hello from main");
    }

}

// второй способ создания потока
class SimpleRunner implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            //задержка перед выводом
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW + "Warning: " + Thread.currentThread().getName() + " was interrupted");
                // выходим из потока когда его прервали
                return;
            }
            // доступ к имени потока
            System.out.println(GREEN + "INFO - Runnable: " + Thread.currentThread().getName() + " - " + i);
        }
        // поток сам проверяет прерван он или нет. если да, то завершает свою работу
        if (Thread.interrupted()) {
            return;
        }
    }
}

// первый способ создания потока
class SimpleThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            //задержка перед выводом
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW + "Warning: " + currentThread().getName() + " was interrupted");
            }
            // доступ к имени потока
            System.out.println(GREEN + "INFO: " + currentThread().getName() + " - " + i);
        }
        // поток сам проверяет прерван он или нет, если да, то сам завершает свою работу
        if (Thread.interrupted()) {
            return;
        }
    }
}
