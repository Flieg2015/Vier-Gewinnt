package GUI;

import javax.swing.*;

/**
 * Created by Thomas on 05.08.2015.
 */
public class Start {
    public JPanel panel1;
    private JLabel titel;

    public static void main(String args) {
        JFrame frame = new JFrame("Start");
        frame.setContentPane(new Start().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}





