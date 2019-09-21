package pso;

import java.util.Random;

public class Particle {
    private String name;
    private Position currentPosition;
    private Position pBest;
    private Position velocity;
    private static int no = 0;
    Random r = new Random();

    Particle() {
        no++;
        this.name = "Bird-"+no;
        currentPosition = new Position();
        pBest = currentPosition;
        velocity = new Position();
    }

    public String getName() {
        return name;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setpBest(Position pBest) {
        this.pBest = pBest;
    }

    public Position getpBest() {
        return pBest;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }

    public Position getVelocity() {
        return velocity;
    }
}
