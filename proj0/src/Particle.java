import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.Map;

public class Particle {
    public ParticleFlavor flavor;
    public int lifespan;

    public static final int PLANT_LIFESPAN = 150;
    public static final int FLOWER_LIFESPAN = 75;
    public static final int FIRE_LIFESPAN = 10;
    public static final int Fountain_LIFESPAN = 20;
    public static final Map<ParticleFlavor, Integer> LIFESPANS =
            Map.of(ParticleFlavor.FLOWER, FLOWER_LIFESPAN,
                   ParticleFlavor.PLANT, PLANT_LIFESPAN,
                   ParticleFlavor.FIRE, FIRE_LIFESPAN,
                    ParticleFlavor.FOUNTAIN,Fountain_LIFESPAN);

    public Particle(ParticleFlavor flavor) {
        this.flavor = flavor;
        lifespan = LIFESPANS.getOrDefault(this.flavor,-1);
    }
    public void decrementLifespan(){
        if (this.lifespan>0){
            this.lifespan = this.lifespan - 1;
        }
        if (this.lifespan==0){
            this.flavor =ParticleFlavor.EMPTY;
        }

    }

    public Color color() {
        if (flavor == ParticleFlavor.EMPTY) {
            return Color.BLACK;
        }
         if (flavor == ParticleFlavor.SAND) {
            return Color.YELLOW;
        }
         if (flavor == ParticleFlavor.BARRIER) {
            return Color.GRAY;
        }
         if (flavor == ParticleFlavor.  WATER) {
            return Color.BLUE;
        }
         if (flavor == ParticleFlavor.FOUNTAIN) {
             double ratio = (double) Math.max(0, Math.min(lifespan, Fountain_LIFESPAN)) / Fountain_LIFESPAN;
             int g = 120 + (int) Math.round((255 - 120) * ratio);
             int b = 120 + (int) Math.round((255 - 120) * ratio);
             return new Color(0, g, b);

        }
        if (flavor == ParticleFlavor.PLANT) {
            double ratio = (double) Math.max(0, Math.min(lifespan, PLANT_LIFESPAN)) / PLANT_LIFESPAN;
            int g = 120 + (int) Math.round((255 - 120) * ratio);
            return new Color(0, g, 0);
        }
        if (flavor == ParticleFlavor.FIRE) {
            double ratio = (double) Math.max(0, Math.min(lifespan, FIRE_LIFESPAN)) / FIRE_LIFESPAN;
            int r = (int) Math.round(255 * ratio);
            return new Color(r, 0, 0);
        }
        if (flavor == ParticleFlavor.FLOWER) {
            double ratio = (double) Math.max(0, Math.min(lifespan, FLOWER_LIFESPAN)) / FLOWER_LIFESPAN;
            int r = 120 + (int) Math.round((255 - 120) * ratio);
            int g = 70 + (int) Math.round((141 - 70) * ratio);
            int b = 80 + (int) Math.round((161 - 80) * ratio);
            return new Color(r, g, b);
        }
        return Color.GRAY;
    }

    public void moveInto(Particle other) {
        other.flavor= this.flavor;
        other.lifespan=this.lifespan;
        this.flavor=ParticleFlavor.EMPTY;
        this.lifespan=-1;
    }

    public void fall(Map<Direction, Particle> neighbors) {
        Particle p = neighbors.get(Direction.DOWN);
        if (p.flavor == ParticleFlavor.EMPTY){
            this.moveInto(p);
        }


    }
    public void fountain(Map<Direction, Particle> neighbors){
        int randoms= StdRandom.uniformInt(3);
        Particle p = neighbors.get(Direction.LEFT);
        Particle q = neighbors.get(Direction.RIGHT);
        Particle u = neighbors.get(Direction.UP);
        Particle d = neighbors.get(Direction.DOWN);
        switch (randoms){
            case 0 :
                if (u.flavor==ParticleFlavor.EMPTY){
                    u.flavor = ParticleFlavor.FOUNTAIN;
                    u.lifespan = Fountain_LIFESPAN;
                }
                break;
            case 1:
                if (p.flavor==ParticleFlavor.EMPTY){
                    p.flavor = ParticleFlavor.FOUNTAIN;
                    p.lifespan = Fountain_LIFESPAN;
                }
                break;
            case 2:
                if (q.flavor==ParticleFlavor.EMPTY){
                    q.flavor = ParticleFlavor.FOUNTAIN;
                    q.lifespan = Fountain_LIFESPAN;
                }
                break;
        }
        if (randoms>=3){
            if (d.flavor==ParticleFlavor.EMPTY){
                d.flavor = ParticleFlavor.FOUNTAIN;
                d.lifespan = Fountain_LIFESPAN;
            }
        }
    }

    public void flow(Map<Direction, Particle> neighbors) {
        int randoms= StdRandom.uniformInt(3);
        Particle p = neighbors.get(Direction.LEFT);
        Particle q = neighbors.get(Direction.RIGHT);

        switch (randoms){
            case 0 :
                break;
            case 1:
                if (p.flavor==ParticleFlavor.EMPTY){
                    this.moveInto(p);
                }
                break;
            case 2:
                if (q.flavor==ParticleFlavor.EMPTY){
                    this.moveInto(q);}
                    break;

        }

    }


    public void grow(Map<Direction, Particle> neighbors) {

        int randoms= StdRandom.uniformInt(10);
        Particle u = neighbors.get(Direction.UP);
        Particle p = neighbors.get(Direction.LEFT);
        Particle q = neighbors.get(Direction.RIGHT);




            switch (randoms) {
                case 0:
                    if (u.flavor == ParticleFlavor.EMPTY) {
                        u.flavor=flavor;
                        u.lifespan=LIFESPANS.get(this.flavor);
                    }
                    break;
                case 1:
                    if (p.flavor == ParticleFlavor.EMPTY) {
                        p.flavor=flavor;
                        p.lifespan=LIFESPANS.get(this.flavor);
                    }
                    break;
                case 2:
                    if (q.flavor == ParticleFlavor.EMPTY) {
                        q.flavor=flavor;
                        q.lifespan=LIFESPANS.get(this.flavor);
                    }
                    break;


        }
    }



    public void burn(Map<Direction, Particle> neighbors) {

        int randoms= StdRandom.uniformInt(10)   ;
        Particle u = neighbors.get(Direction.UP);
        Particle p = neighbors.get(Direction.LEFT);
        Particle q = neighbors.get(Direction.RIGHT);
        Particle d = neighbors.get(Direction.RIGHT);
        if(u.flavor == ParticleFlavor.FLOWER || u.flavor == ParticleFlavor.PLANT ){
            if (randoms<=4) {
                u.flavor = ParticleFlavor.FIRE;
                u.lifespan = FIRE_LIFESPAN;

            }
        }
        randoms = StdRandom.uniformInt(10);

        if(p.flavor == ParticleFlavor.FLOWER || p.flavor == ParticleFlavor.PLANT ){
            if (randoms<=4) {
                p.flavor = ParticleFlavor.FIRE;
                p.lifespan = FIRE_LIFESPAN;

            }
        }
        randoms = StdRandom.uniformInt(10);

        if(q.flavor == ParticleFlavor.FLOWER || q.flavor == ParticleFlavor.PLANT ){
            if (randoms<=2) {
                q.flavor = ParticleFlavor.FIRE;
                q.lifespan = FIRE_LIFESPAN;

            }
        }
        randoms = StdRandom.uniformInt(10);

        if(d.flavor == ParticleFlavor.FLOWER || d.flavor == ParticleFlavor.PLANT ){
            if (randoms<=2) {
                d.flavor = ParticleFlavor.FIRE;
                d.lifespan = FIRE_LIFESPAN;

            }
        }
    }
    public void action(Map<Direction, Particle> neighbors) {

        if (this.flavor == ParticleFlavor.EMPTY){
            return;
        }
//        && this.flavor != ParticleFlavor.FOUNTAIN
        if (this.flavor != ParticleFlavor.BARRIER && this.flavor != ParticleFlavor.FOUNTAIN ) {
            fall(neighbors);
        }
        if (this.flavor == ParticleFlavor.WATER) {
            flow(neighbors);
        }
        if (this.flavor == ParticleFlavor.PLANT || this.flavor == ParticleFlavor.FLOWER ) {
            grow(neighbors);

        }
        if(this.flavor == ParticleFlavor.FIRE){
            burn(neighbors);

        }
        if(this.flavor == ParticleFlavor.FOUNTAIN){
            fountain(neighbors);
            fall(neighbors);
        }

    }


}