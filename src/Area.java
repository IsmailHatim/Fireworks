import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Area extends JPanel implements MouseListener {
    public ArrayList<Firework> fireworks = new ArrayList<>();
    public int size;


    public Area(int size, Color bgColor){
        super();
        this.size = size;
        this.setBackground(bgColor);
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < fireworks.size(); i++){
            for (int j = 0; j < fireworks.get(i).particles.size(); j++){
                fireworks.get(i).particles.get(j).draw(g);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        fireworks.add(Firework.randomFirework(e.getX(), e.getY(), Gyvenimas.randint(15,25),Gyvenimas.randint(-1,5)));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
