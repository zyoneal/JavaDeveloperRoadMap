package BuisnessIncubator;

// реализовать интерфейс Runnable
public class FirstRun implements Runnable{

    // переопределить единственный метод run()
    @Override
    public void run() {
        int pr = 1;
        for (int i = 1; i < 20; i++) {
            pr *= i;
        }
        System.out.println("p = " + pr);
    }

}
