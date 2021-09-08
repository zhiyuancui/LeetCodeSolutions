package solutions.lyft;

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExponentialBackoffStrategy {

    private int maxAttempt;
    private Random random = new Random();

    public ExponentialBackoffStrategy(int maxAttempt) {
        this.maxAttempt = maxAttempt;
    }

    private long getWaitTimeExp(int attempt) {
        double pow = Math.pow(2, attempt);
        long backoffValue = (long)pow * 1000;
        System.out.println("BackoffValue: " + backoffValue);
        return backoffValue;
    }

    public <T> T attempt(Supplier<T> action, Predicate<T> success) {
        int attempts = 0;

        T result = action.get();
        while(!success.test(result) && attempts < maxAttempt) {
            System.out.println("Attempts: " + attempts + " with result: " + result);
            try {
                Thread.sleep(getWaitTimeExp(attempts));
                attempts++;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            result = action.get();
        }

        return result;
    }

    public static void main(String[] args) {
        ExponentialBackoffStrategy backoffStrategy = new ExponentialBackoffStrategy(3);

        try {
            int result = backoffStrategy.attempt(()-> {
                return 0 + (int)(Math.random() * (100-0) + 1);
            }, r -> {
               return r < 10;
            });
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
