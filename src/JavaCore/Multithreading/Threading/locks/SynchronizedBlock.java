package JavaCore.Multithreading.Threading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBlock {

    // не всегда удобно использовать synchronized block, так как у него есть целый ряд ограничений: synchronized block ограничен одним методом.
    // Нельзя расширить synchronized блок за пределы в котором он находится (или метод как синхронайзд или в методе блок синхронайзд)
    // synchronized неизвестно какой поток станет следующим в получении лока. Нет гарантии что каждый по очереди получит свой лок. Может быть такое что один и тот же поток будет получать лок снова и снова и снова и это приводит к голоданию потоков (когда один поток долгое время не может получить доступ к ресурсу).
    private static final Lock monitor = new ReentrantLock(true);

    private static final Condition canRead = monitor.newCondition();
    private static final Condition canWrite = monitor.newCondition();

    private static int buffer = 0;
    private static boolean isEmpty = true;

    public static void main(String[] args) {
        new Thread(SynchronizedBlock::blockingWrite).start();
        new Thread(SynchronizedBlock::blockingRead).start();

    }

    private static void blockingWrite() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
                while (!isEmpty) {
                    System.out.println("Writer is trying to access a resource");
                    System.out.println("Buffer is full");
                    canWrite.await(5, TimeUnit.SECONDS);
                }
                buffer++;
                isEmpty = false;
                System.out.println("Writer produced " + buffer);
                canRead.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }
            monitor.unlock();
        }
    }

    private static void blockingRead() {
        for (int i = 0; i < 10; i++) {

            monitor.lock();
            try {
                while (isEmpty) {
                    System.out.println("Reader is trying to access a resource");
                    System.out.println("Buffer is empty");
                    canRead.await(5, TimeUnit.SECONDS);
                }
                int readValue = buffer;
                isEmpty = true;
                System.out.println("Reader reads from buffer: " + readValue);
                canWrite.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }

            monitor.unlock();
        }
    }

}
