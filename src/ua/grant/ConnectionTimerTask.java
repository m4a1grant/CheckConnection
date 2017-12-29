package ua.grant;

import java.net.*;
import java.io.IOException;
import java.util.TimerTask;

public class ConnectionTimerTask extends TimerTask{
    private String testAdr;
    private long startTime = System.currentTimeMillis();

    public ConnectionTimerTask(String testAdr) {
        this.testAdr = testAdr;
    }

    @Override
    public void run() {
        try{
            URL url = new URL(testAdr);
            URLConnection conn = url.openConnection();
            conn.connect();
            long time = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " ----- " +
                    "Время: " + (time - startTime)/1000.0 + "c. ----- " +
                    "Доступно");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //printStackTrace();
            long time = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " ----- " +
                    "Время: " + (time - startTime)/1000.0 + "c. ----- " +
                    "Недоступно");
        }
    }
}
