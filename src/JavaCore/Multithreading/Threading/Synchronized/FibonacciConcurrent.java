package Threading.Synchronized;

public class FibonacciConcurrent {

    private static int previous = 0;

    private static int current = 1;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new FibonacciRunner());
        Thread thread2 = new Thread(new FibonacciRunner());
        thread1.start();
        thread2.start();

    }

    // synchronized - ограничевает доступ потоков в метод. Только 1 поток может использовать этот метод
    // синхронизация происходит с помощью внутреннего замка. он пренадлежит обьекту.
    // Если не static метод, то это будет лок обьекта this, если статический метод, то будет лок класса.
    private static synchronized void calcNext() {
        // можно обернуть действие, а можно сделать метод synchronized
        //synchronized (FibonacciConcurrent.class) {
        int next = previous + current;
        previous = current;
        current = next;
        System.out.println(current);
        //  }
    }

    private static class FibonacciRunner implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                calcNext();
            }
        }
    }

}

