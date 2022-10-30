package JavaCore.Multithreading.Threading.executors;

import java.util.Random;

// Поиск самого большого делителя двух чисел
// исплементировать интерфейс Runnable это более предпочтительный подход чем екстендить Thread
public class GCBRunnable extends Random implements Runnable {

    @Override
    public void run() {
        //имя потока
        String threadDescription = Thread.currentThread().getName();

        System.out.println("Staring " + threadDescription);
        for (int i = 0; i < 10000000; i++) {
            int a = nextInt();
            int b = nextInt();
            // раз в десять тысяч будем выводить результат
            if (i % 10000 == 0) {
                if (!Thread.interrupted()) {
                    int gcd = computeGCD(a, b);
                    if (gcd > 5) {
                        System.out.println("Running in " + threadDescription + ". The GCD of " + a + " and " + b + " is " + gcd);
                    }
                } else {
                    System.out.println("Thread was interrupted");
                    return;
                }
            }
        }
    }

    private int computeGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        } else return computeGCD(number2, number1 % number2);
    }
    // оба делятся на 10
    // 50 % 30 = 20
    // 30%20 = 10
    // 20%10 = 0
    // 10%0 = 10
    // возвращаем number1

}
