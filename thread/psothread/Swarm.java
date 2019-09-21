package thread.psothread;

import java.util.ArrayList;
import java.util.List;

public class Swarm {
    private List<Particle> swarm;

    public Swarm() {
        swarm = new ArrayList<Particle>();
    }

    public Particle addParticle() {
        Particle p = new Particle();
        return p;
    }
}
