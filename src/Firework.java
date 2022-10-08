import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Firework {
    public ArrayList<Particle> particles = new ArrayList<>();
    public String type;
    public double explodingRatio;
    public double mismatch;
    public double x;
    public double y;
    public double vx;
    public double vy;
    public double ax;
    public double ay;
    public double vylim;
    protected boolean exploded;


    public Firework(double x,double y, double vy0,double vylim, int size, double mismatch, double explodingRatio, String type, Color color){
        this.x = x;
        this.y = y;
        this.vy = -vy0;
        this.vx = 0;
        this.type = type;
        this.mismatch = mismatch;
        this.explodingRatio = explodingRatio;
        this.vylim = vylim;
        int i = 0;

        while(i < size) {
            particles.add(new Particle(x, y, vy0));
            switch (type) {
                case "unicolour1":
                    particles.get(i).setColor(color);
                    break;
                case "unicolour2":
                    double rnd = 10*(Math.random() + Math.random()*(-1));
                    particles.get(i).setColor(new Color((int) (color.getRed()+rnd),(int) (color.getGreen()+rnd),(int) (color.getBlue()+rnd)));
                    break;
                case "rainbow":
                    //Partie à faire
                    break;
                case "random":
                    particles.get(i).setColor(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
                    break;
            }
            i++;
        }
    }

    public void update(){
        vx += 0;
        vy += Gyvenimas.GRAVITY ;
        x += vx;
        y += vy;
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).update();
        }
        if(vy > vylim && exploded == false){
            this.explode();
            exploded = true;
        }
    }

    public void explode(){
        for (int i = 0; i < particles.size(); i++){
            particles.get(i).setVx(2*explodingRatio*(Math.random() + Math.random()*(-1)));
            particles.get(i).setVy(2*explodingRatio*(Math.random() + Math.random()*(-1)));
        }
    }

    /*public Particle highestParticle(){

    }*/

    public static Firework randomFirework(int x, int y,int vyo, int vylim){
        int rnd = Gyvenimas.randint(0,3);
        String randomType = "unicoulour1";
        switch (rnd){
            case 0:
                randomType = "unicolour1";
                break;
            case 1:
                randomType = "unicoulour2";
                break;
            case 2:
                randomType = "random"; // Need to put rainbow, when I'll finish coding it..
                break;
            case 3:
                randomType = "random";
                break;
        }

        int R = (int) (Math.random()*255);
        int G = (int) (Math.random()*255);
        int B = (int) (Math.random()*255);

        Color randomColor = new Color(R,G,B);

        randomColor = randomColor.brighter();//Can also add a brightness parameter


        Firework f = new Firework(x, y, vyo, vylim,Gyvenimas.randint(400,1000), Math.random(), Math.random()*30,randomType,randomColor);
        return f;
    }

}
