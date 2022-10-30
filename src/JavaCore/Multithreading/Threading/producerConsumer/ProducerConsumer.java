package JavaCore.Multithreading.Threading.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    // есть 2 вида потоков.
    // первый из них является продюссером (поток который получает какую-то информацию).
    // второй является консюмером (обрабатывает эту информацию и например может сохранять информацию из файла в базу данных)
    // промежуточным звеном в этой цепи является коллекция, которая хранит в себе все обьекты обработаные продюссером, и которые потом должен забрать консюмер
    // тут этой коллекцией будет blocking queue , ее имплементация array blocking queue

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    private static class Producer implements Runnable {

        String[] messages = {
                "Whoose woods these are I think I know.",
                "His house is in the village, though",
                "He will not see me stopping here",
                "To watch his woods fill up with snow.",
                "DONE"
        };

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            Random random = new Random();
            for (int i = 0; i < messages.length; i++) {
                queue.put(messages[i]);
                System.out.println("Producing " + messages[i] + ". Queue size is " + queue.size());
                Thread.sleep(random.nextInt(1000));
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            Random random = new Random();
            while (true) {
                String message = queue.take();
                System.out.println("Consuming " + message + ". Queue size is " + queue.size());
                if (!"DONE".equals(message)) {
                    Thread.sleep(random.nextInt(1000));
                } else return;
            }
        }
    }

}
