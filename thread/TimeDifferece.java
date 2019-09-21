package thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeDifferece {
    public static void main(String[] args) {
        Date d = new Date();
        long start = d.getTime();
        TimeUnit.MILLISECONDS.toSeconds(start);
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(start));
    }
}
