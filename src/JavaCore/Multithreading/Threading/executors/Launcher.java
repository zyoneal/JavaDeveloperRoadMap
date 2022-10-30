package JavaCore.Multithreading.Threading.executors;

// Есть 2 вида потоков:
// 1) User потоки - они продолжают свою работу до тех пор, пока не выполнят свои задачи.
// 2) Daemon потоки - они продолжают свою работу до тех пор, пока живет main поток. В противном случае завершаем все потоки вместе.

// Если нескольколько сотен заданий  и много потоков, то используем executorService. Он позволяет создать потоки заранее при старте приложения.
// Можно отделить код, который занимается созданием потоков от кода который выполняет бизнесс логику
// С помощью ThreadPools можно использовать потоки несколько раз.
// До тех пор, пока есть задания для этих потоков, потоки будут их выполнять, поток выполнил свое задание -> возвращается в пул.
// Потом может использовать повторно для выполнения следующего задания.


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Launcher {

    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting main thread");
        GCBRunnable r = new GCBRunnable();
        //     runInOneThread(r);
        //     Thread.sleep(1000);

        runWithExecutors(r, true);
        System.out.println("leaving the main thread");

    }

    private static void runInOneThread(GCBRunnable runnable) throws InterruptedException {
        Thread thread1 = new Thread(runnable);
        thread1.setDaemon(true);
        thread1.start();
        // поработает некоторое время и упадет
        //    Thread.sleep(100);
        //  thread1.interrupt();
    }

    private static void runWithExecutors(GCBRunnable runnable, boolean isDaemon) throws InterruptedException {
        // обозначаем демон поток
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                if (isDaemon) {
                    thread.setDaemon(true);
                }
                return thread;
            }
        };
        // Передаем количество потоков, и демон поток
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE, factory);
        for (int i = 0; i < 5; i++) {
            executorService.execute(runnable);
        }
        //shutdown - после того как потоки выполнили свои задания, они могут завершить свою работу
        executorService.shutdown();
        //awaitTermination - все потоки, которые зависли на 30 секунд, завершают свою работу
        executorService.awaitTermination(30, TimeUnit.SECONDS);
    }

}
