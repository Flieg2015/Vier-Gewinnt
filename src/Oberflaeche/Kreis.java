package Oberflaeche;

/**
 * Created by Thomas on 29.07.2015.
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Kreis extends JComponent {

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(10, 10, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.fillOval(0, 0, getWidth(), getHeight());
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.add(new Kreis());
        f.setVisible(true);
    }

    public static void main(String args[]) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }
}
