package csw.java.time;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer2 {

  private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

  static {
    scheduler.scheduleWithFixedDelay(new Thread() {
      @Override
      public void run() {

        System.out.println(new Date());
      }
    }, 1000, 1000, TimeUnit.MILLISECONDS);
  }

  public static void main(String[] args) {
    new Timer2();
  }

}
