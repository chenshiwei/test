package csw.java.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewTest {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(new Date(System.currentTimeMillis()));
        };
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
        schedule.scheduleWithFixedDelay(runnable, 0, 5, TimeUnit.SECONDS);
        try {
            schedule.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schedule.shutdown();
    }

}
