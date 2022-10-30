package JavaCore.Multithreading.BuisnessIncubator;


import java.util.List;
// наследоваться от Thread
public class FirstThread extends Thread {

    public FirstThread(String name) {
        super(name);
    }

    //переопределять run(), а не start()
    // все что выполняется в run() -> выполняется в потоке
    @Override
    public void run() {
        List<Integer> list = ThreadMain.integers;

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("sum: " + sum);
    }

}
