package Threading.Synchronized;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlock {

    private int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] b = {0, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    private List<Integer> integerList1 = new ArrayList<>();
    private List<Integer> integerList2 = new ArrayList<>();

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        SynchronizedBlock synchronizedBlock = new SynchronizedBlock();
        synchronizedBlock.copy();
    }

    private void copy() {
        // Последоватьельное выполнение потоков
        // Они не работают паралельно
        // Все это можно исправить если написать локи и обернуть действия. Тогда они не будут ждать друг друга.
        // Локи должны быть final. Неизменяемыми.
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new RunnerA());
        Thread thread2 = new Thread(new RunnerB());
        thread1.start();
        thread2.start();
        // join - означает что метод main() должен ждать выполнения потока 1 и потока 2 и после этого выводить время.
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("time taken : " + (end - start) + "ms");
    }

    private void copyArrayA() {
        synchronized (lock1) {
            for (int i = 0; i < a.length; i++) {
                integerList1.add(a[i]);
                System.out.println(integerList1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyArrayB() {
        synchronized (lock2) {
            for (int i = 0; i < b.length; i++) {
                integerList2.add(b[i]);
                System.out.println(integerList2);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class RunnerA implements Runnable {

        @Override
        public void run() {
            copyArrayA();
        }
    }

    private class RunnerB implements Runnable {

        @Override
        public void run() {
            copyArrayB();
        }
    }

}
