package thread;

import java.util.Scanner;

class Processor extends Thread {
    private boolean running = true;
    public void run() {
        while(running) {
            System.out.println("Hello ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class App {
    public static void main(String[] args) {
        Processor runner1 = new Processor();
        runner1.start();

        System.out.println("Press return to stop...");
        Scanner in = new Scanner(System.in);
        in.nextLine();

        runner1.shutdown();
    }
}
