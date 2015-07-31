package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Thomas on 30.07.2015.
 */
public class Anmeldescreen extends Screen {

    private JPanel panel1;
    private JPanel oben;
    private JPanel links;
    private JPanel rechts;
    private JPanel unten;
    private JPanel center;
    private JButton Anmelden;


    public Anmeldescreen() {
        Anmelden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Anmeldescreen");
        frame.setContentPane(new Anmeldescreen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
    }




}
