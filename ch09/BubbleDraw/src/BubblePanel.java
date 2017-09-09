import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;
public class BubblePanel extends JPanel {
    Random rand = new Random();
    ArrayList<Bubble> bubbleList;
    int size = 25;
    public BubblePanel(){
        bubbleList = new ArrayList<Bubble>();
        setBackground(Color.BLACK);
        //testBubbles();
        addMouseListener( new BubbleListener() );
        addMouseMotionListener( new BubbleListener() );
        addMouseWheelListener( new BubbleListener() );
    }
    public void paintComponent(Graphics canvas){
        super.paintComponent(canvas);
        for(Bubble b : bubbleList){
            b.draw(canvas);
        }
    }
    public void testBubbles(){
        for(int n = 0; n < 100; n++){
            int x = rand.nextInt(600);
            int y = rand.nextInt(400);
            int size = rand.nextInt(50);
            bubbleList.add( new Bubble(x, y, size) );
        }
        repaint();
    }
    private class BubbleListener extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            bubbleList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }
        public void mouseDragged(MouseEvent e) {
            bubbleList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }
        public void mouseWheelMoved(MouseWheelEvent e) {
            if(System.getProperty("os.name").startsWith("Mac"))
                size += e.getUnitsToScroll();
            else
                size -= e.getUnitsToScroll();
            if (size < 3)
                size = 3;
        }
    }
    private class Bubble {
        private int x;
        private int y;
        private int size;
        private Color color;
        public Bubble(int newX, int newY, int newSize){
            x = newX;
            y = newY;
            size = newSize;
            color = new Color( rand.nextInt(256),
                    rand.nextInt(256),
                    rand.nextInt(256) );
        }
        public void draw(Graphics canvas){
            canvas.setColor(color);
            canvas.fillOval(x - size/2, y - size/2, size, size);
        }
    }
}
