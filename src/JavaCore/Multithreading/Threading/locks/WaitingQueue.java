package JavaCore.Multithreading.Threading.locks;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class WaitingQueue {

    // Semaphore - позволяет одновременный доступ к какому-то ресурсу нескольким потокам.
    // К локам может достучаться 1 единственный поток, предыдущий должен был его освободить
    // в случае с Semaphore одновременно доступ могут получить определенное количество потоков, остальные становятся в очередь.
    // как только 1 завершил свою работу следующий поток из очереди может перейти из режима ожидания в режим работы с ресурсом

    public static void main(String[] args) {
        int operators = 5;
        int customers = 21;

        SemaphoredServiceDesk semaphoredServiceDesk = new SemaphoredServiceDesk(operators, customers);

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 21 потому что метод range() не включает последний элемент. 0..20
        IntStream.range(0, customers).forEach(client -> executorService.submit(() -> {
            semaphoredServiceDesk.connect();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Number of connected customers " + semaphoredServiceDesk.getCustomersConnected());
            System.out.println("Number of customers in a queue " + semaphoredServiceDesk.getCustomersWaiting());
        }));
        executorService.shutdown();
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class SemaphoredServiceDesk {

        private AtomicInteger connectedCustomers = new AtomicInteger();

        private AtomicInteger customersQueued;

        private Semaphore semaphore;

        public SemaphoredServiceDesk(int operatorsNum, int customersNumber) {
            semaphore = new Semaphore(operatorsNum);
            customersQueued = new AtomicInteger(customersNumber);
        }

        public void connect() {
            Random random = new Random();

            try {
                // чтобы поток мог получить свой лок
                semaphore.acquire();
                connectedCustomers.incrementAndGet();
                customersQueued.decrementAndGet();

                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }

        private void disconnect() {
            //освободить лок
            semaphore.release();
            connectedCustomers.decrementAndGet();
        }

        private int getCustomersConnected() {
            return connectedCustomers.get();
        }

        private int getCustomersWaiting() {
            return customersQueued.get();
        }
    }

}
