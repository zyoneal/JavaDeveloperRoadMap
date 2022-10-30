package JavaCore.Multithreading.Threading.waitnotify;

// wait(), notify() - стандартные методы класса Object которые наследуются всеми обьектами.
// wait() - заставляет ждать поток неограниченое количество времени до тех пор пока другой поток который синхронизуется по тому же локу не вызовет метод notify()
// notify() - отправляем сообщение одному потоку который ожидает тот же лок с которым работает поток вызвавший метод notify().
// notifyAll() - отправвляет сообщение  всем потокам которые ждут получение того же лока.

public class WaitNotifyExample {

    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();
    }

    private static class Producer implements Runnable {

        private final Message message;

        Producer(Message message) {
            this.message = message;
        }

        String[] text = {
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
            for (String s : text) {
                synchronized (message) {
                    System.out.println("Producing message: " + s);
                    message.setMessage(s);
                    message.notify();
                    if (!"DONE".equals(s)) {
                        message.wait();
                    }
                }
                Thread.sleep(400);
            }
        }

    }

    private static class Consumer implements Runnable {

        private final Message message;

        Consumer(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            while (true) {
                Thread.sleep(400);
                synchronized (message) {
                    System.out.println("Consuming message: " + message.getMessage());
                    if (!"DONE".equals(message.getMessage())) {
                        message.notify();
                        message.wait();
                    } else return;
                }
            }
        }
    }

}