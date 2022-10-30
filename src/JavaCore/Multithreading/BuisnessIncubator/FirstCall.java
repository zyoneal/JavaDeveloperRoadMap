package JavaCore.Multithreading.BuisnessIncubator;

import java.util.List;
import java.util.concurrent.Callable;

// реализовать интерфейс Callable. В параментр нужно передать обьект, тип которого хотим вернуть по завершению работы потока
public class FirstCall implements Callable<Integer> {

    // У потока уже есть возвращаемое значение
    @Override
    public Integer call() throws Exception {
        List<Integer> list = ThreadMain.integers;

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) + 1;
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("sum: " + sum);
        return sum;
    }

}
