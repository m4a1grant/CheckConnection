package ua.grant;

import java.util.Timer;



public class Main {

    private static String testAdress = "http://localhost/";
    private static long workingTime = 60000;
    private static long period = 5000;
    private static long delay = 100;

    public static void main(String[] args) {
        //чувсвую себя индусом
        ConnectionTimerTask myTask1 = new ConnectionTimerTask(testAdress);
        ConnectionTimerTask myTask2 = new ConnectionTimerTask(testAdress);
        ConnectionTimerTask myTask3 = new ConnectionTimerTask(testAdress);
        Timer myTimer1 = new Timer("Thread#1)");
        Timer myTimer2 = new Timer("Thread#2)");
        Timer myTimer3 = new Timer("Thread#3)");
        myTimer1.schedule(myTask1, delay, period);
        myTimer2.schedule(myTask2, delay, period);
        myTimer3.schedule(myTask3, delay, period);
        try {
            Thread.sleep(workingTime + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myTimer1.cancel();
        myTimer2.cancel();
        myTimer3.cancel();
    }
}
