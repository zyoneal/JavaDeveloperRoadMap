package JavaCore.Multithreading.Threading.CallableAndFuture;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Runnable - ничего не возвращает
// Callable - возвращает

class Timer {

    public Instant start;

    public Instant end;

    public double timeInSecond() {
        // временной промежуток между старт и конец
        return Duration.between(start, end).toMillis() / 1000.0;
    }

}

public class CallableFutureBase {

    public static void main(String[] args) {
        List<Future<Double>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 30; i++) {
            Future<Double> submit = executorService.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    Timer timer = new Timer();
                    Random random = new Random();
                    timer.start = Instant.now();
                    int rand = random.nextInt(5000);
                    Thread.sleep(rand);
                    timer.end = Instant.now();
                    return timer.timeInSecond();
                }
            });
            futures.add(submit);
        }
        executorService.shutdown();

        futures.parallelStream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return 0.0;
        }).forEach(t -> System.out.println("Thread execution time " + t));
    }

}
