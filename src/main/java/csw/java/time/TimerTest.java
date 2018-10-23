package csw.java.time;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

  public static void main(String[] args) {  
    Integer cacheTime = 1000 * 3;  
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println(new Date());
        }
    }, 1000, cacheTime);
	}
  
}