package pso;
import java.util.Random;

public class PSO {
    private static Position gBest;
    private static Position target;
    private static Swarm swarm = new Swarm();
    private static double gVal = Double.POSITIVE_INFINITY;
    private static final double INERTIA = 0.729844;
    private static final double CONGNITIVE = 1.496180;
    private static final double SOCIAL = 1.496180;
    private static String particleName;
    static Random r = new Random();

    public static void main(String[] args) {
        target = new Position(0,0);

        // Inititalizes particles
        for(int i=0; i<30; i++) {
            swarm.addParticle();
        }

        gBest = new Position("gBest");
        findgBest();
        System.out.print("gBest: "+particleName+": ");
        gBest.print();


        for(int i=0; i<200; i++) {
            // Update velocity
            for (Particle p : swarm.getParticles()) {
                updateVelocity(p);
                updatePosition(p);
                updatepBest(p);
            }

            findgBest();

            System.out.print("gBest: "+particleName+" @ iteration "+(i+1)+": ");
            gBest.print();
        }
    }

    public static double getDistance(Position par, Position tar) {
        double x = par.getX() - tar.getX();
        double y = par.getY() - tar.getY();
        double distance = Math.sqrt(x*x + y*y);
        return distance;
    }

    public static double getFitnessValue(Position p) {
        double x = p.getX();
        double y = p.getY();
        double x2 = x*x;
        double x4 = x2*x2;
        double y2 = y*y;

//        double val = (4-2.1*x2+(x4/3))*x2 + x*y + (-4+4*y2)*y2;
        double val = x*x + y*y;
        return val;
    }

    public static void updateVelocity(Particle p) {
        Position velocity = p.getVelocity();
        velocity.mul(INERTIA);

        // Cognitive component
        double r1 = r.nextDouble();
        Position cog = new Position(0, 0);
        cog.add(p.getpBest());
        cog.sub(p.getCurrentPosition());
        cog.mul(CONGNITIVE * r1);
        velocity.add(cog);

        // Social component
        double r2 = r.nextDouble();
        Position soc = new Position(0, 0);
        soc.add(gBest);
        soc.sub(p.getCurrentPosition());
        soc.mul(SOCIAL * r2);
        velocity.add(soc);

        p.getCurrentPosition().add(velocity);
    }

    private static void updatePosition(Particle p) {
        if(p.getCurrentPosition().getX()<Position.START_RANGE) {
            p.getCurrentPosition().setX(Position.START_RANGE);
        }
        if(p.getCurrentPosition().getX()>Position.END_RANGE) {
            p.getCurrentPosition().setX(Position.END_RANGE);
        }

        if(p.getCurrentPosition().getY()<Position.START_RANGE) {
            p.getCurrentPosition().setY(Position.START_RANGE);
        }
        if(p.getCurrentPosition().getY()>Position.END_RANGE) {
            p.getCurrentPosition().setY(Position.END_RANGE);
        }
    }

    public static void updatepBest(Particle p) {
//        if(getDistance(p.getpBest(), target) > getDistance(p.getCurrentPosition(), target)) {
//            p.setpBest(p.getCurrentPosition());
//        }

        if(getFitnessValue(p.getpBest())>getFitnessValue(p.getCurrentPosition())) {
            Position pos = new Position(p.getCurrentPosition().getX(), p.getCurrentPosition().getY());
            p.setpBest(pos);
        }
    }

    public static void findgBest() {
        // evaluating gBest

        for(Particle p: swarm.getParticles()) {
            Position pos = p.getCurrentPosition();
            double dist = getFitnessValue(pos);
            if(gVal>dist) {
                gVal = dist;
                gBest.setPosition(pos.getX(), pos.getY());
                particleName = p.getName();
            }
        }
    }
}
