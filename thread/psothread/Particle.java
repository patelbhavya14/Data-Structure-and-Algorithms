package thread.psothread;

import java.util.TimerTask;

public class Particle extends TimerTask {
    private static int no = 0;
    private String name;

    public Particle() {
        this.name = "Particle-"+(++no);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {

    }
}
