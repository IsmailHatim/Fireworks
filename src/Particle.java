import javax.swing.*;
import java.awt.*;

public class Particle {
    public double x;
    public double y;
    public double vx;
    public double vy;
    public double ax;
    public double ay;
    Color color;

    public Particle(double x, double y, double vy0){
        this.x = x;
        this.y =y;
        this.vy = -vy0;
        this.vx = 0;
    }

    public void update() {

        vy += Gyvenimas.GRAVITY;
        vx += 0;
        x += vx;
        y += vy;
    }

    public void fade(int fader){
        if(color.getAlpha()-fader>0){
            this.setColor(new Color(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha()-fader));
        }
        else{
            this.setColor(new Color(color.getRed(),color.getGreen(),color.getBlue(),0));
        }
    }



    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int) x,(int) y,Gyvenimas.PARTICLE_SIZE,Gyvenimas.PARTICLE_SIZE);
    }

    public void setColor(Color color){this.color = color;}

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setVx(double vx){this.vx = vx;}
    public void setVy(double vy){this.vy = vy;}
    public void setAx(double ax){this.ax = ax;}
    public void setAy(double ay){this.ay = ay;}



}
