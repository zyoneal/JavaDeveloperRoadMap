package BuisnessIncubator;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadMain {

    static List<Integer> integers = IntStream.range(1, 100)
            .boxed()
            .collect(Collectors.toList());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //================ 1 способ запуска потока (через наследование от класса Thread + override run() =============
        // поток main() запускает поток start -> 2 равноправных потока
        FirstThread thread = new FirstThread("IntegersSum");
        // что бы запустить поток, надо вызвать метод start().
        thread.start();

        //========= 2 способ запуска потока (через реализацию интерфейса Runnable + override run() =============
        Thread thread1 = new Thread(new FirstRun());
        thread1.start();

        //========= 3 способ новый ==========
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FirstCall thread2 = new FirstCall();
        Future<Integer> integerFuture = executorService.submit(thread2);
        // get() -> останавливает поток main(), до тех пор, пока не извлечется значение. когда значение извлечено, то отпускает поток main() дальше
        Integer result = integerFuture.get();
        System.out.println("main result " + result);
        //========= end of Main sout ========
        System.out.println("end of main " + Thread.currentThread().getName());
    }

}
