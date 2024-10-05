import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;

class MouseComponent2 extends JComponent {
    private static final Random random = new Random();

    private int x = 200;
    private int y = 200;


    public MouseComponent2() {
        class MouseComponentListener extends MouseAdapter {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                repaint();
            }
        }

        addMouseListener(new MouseComponentListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        int size = random.nextInt(100);

        Rectangle rectangle = new Rectangle(x - (size / 2), y - (size / 2), size, size);
        g2.draw(rectangle);
    }
}


public class MouseViewer2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(500, 500);
        frame.setTitle("Rectangle Viewer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(2, 1));
        frame.add((new MouseComponent2()));
        frame.add(new TextArea());

        frame.setVisible(true);
    }

}