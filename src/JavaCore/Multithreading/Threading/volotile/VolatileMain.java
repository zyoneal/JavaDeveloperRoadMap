package Threading.volotile;

public class VolatileMain {

    // volatile - показываем что переменная может изменятся из разных потоков. Java не будет выполнять кеширование переменных
    // если не писать volatile перед переменными и изменять их вместе с переменной volatile , то они тоже будут видны всем потокам (тоже будут volatile).
    private static volatile int counter;

    public static void main(String[] args) {
        new SimpleWriter().start();
        new SimpleReader().start();
    }

    private static class SimpleWriter extends Thread {

        @Override
        public void run() {
            int localcounter = counter;
            for (int i = 0; i < 10; i++) {
                System.out.println("Writer increments counter " + (localcounter + 1));
                counter = ++localcounter;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class SimpleReader extends Thread {

        @Override
        public void run() {
            int localCounter = counter;
            while (localCounter < 10) {
                if (localCounter != counter) {
                    System.out.println("Reader reads counter " + counter);
                    localCounter = counter;
                }
            }
        }
    }

}
