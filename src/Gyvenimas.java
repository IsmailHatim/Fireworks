import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class Gyvenimas {
    public final static double GRAVITY = 0.4;
    public final static int PARTICLE_SIZE = 5;
    public final static int WINDOW_WIDTH = 1000;
    public final static int WINDOW_HEIGHT = 1000;
    static double time = 0;




    public static void main(String args[]){
        Window win = new Window("Fireworks !",WINDOW_WIDTH,WINDOW_HEIGHT);
        Area area = new Area(0,Color.black);
        win.getContentPane().add(area);
        win.getContentPane().addMouseListener(area);
        java.util.Timer t = new java.util.Timer();

        Firework f1 = new Firework(WINDOW_WIDTH/2,WINDOW_HEIGHT,30,5,800,0.17,20.4,"unicolour1",Color.white);
        //area.fireworks.add(f1);


        t.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < area.fireworks.size(); i++){
                    area.repaint();
                    Firework f = area.fireworks.get(i);
                    f.update();
                }
            }
        },0,10);


        //System.out.println("("+Color.pink.getRed()+","+Color.pink.getGreen()+","+Color.pink.getBlue()+")");
    }

    public static int randint(int a, int b){
        return (int) (Math.random()*(b-a)) + a;
    }
}
