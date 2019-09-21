package pso;

import java.util.ArrayList;
import java.util.List;

public class Swarm {
    private List<Particle> swarm;
    private Position gBest;

    Swarm() {
        swarm = new ArrayList<Particle>();
    }

    Particle addParticle() {
        Particle p = new Particle();
        swarm.add(p);
        return p;
    }

    List<Particle> getParticles() {
        return swarm;
    }
}
