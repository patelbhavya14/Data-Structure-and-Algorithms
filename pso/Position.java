package pso;

import javafx.geometry.Pos;

import java.util.Random;

public class Position {
    private double x, y;
    public static int START_RANGE = -2;
    public static int END_RANGE = 2;
    private static Swarm swarm = new Swarm();
    Random r = new Random();

    Position() {
        this.x = START_RANGE + (END_RANGE-START_RANGE) * r.nextDouble();
        this.y = START_RANGE + (END_RANGE-START_RANGE) * r.nextDouble();

        for(Particle p: swarm.getParticles()) {
            while(p.getCurrentPosition().getX() == this.x &&
            p.getCurrentPosition().getY() == this.y) {
                this.x = START_RANGE + (END_RANGE-START_RANGE) * r.nextDouble();
                this.y = START_RANGE + (END_RANGE-START_RANGE) * r.nextDouble();
            }
        }

    }

    Position(String target) {
        this.x = END_RANGE + r.nextDouble();
        this.y = END_RANGE + r.nextDouble();
    }

    Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void add(Position p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    public void sub(Position p) {
        this.x -= p.getX();
        this.y -= p.getY();
    }

    public void mul(double w) {
        this.x *= w;
        this.y *= w;
    }

    public void print() {
        System.out.println("("+getX()+","+getY()+")");
    }
}
