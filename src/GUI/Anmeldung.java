package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Thomas on 05.08.2015.
 */
public class Anmeldung {
    private JPanel panel1;
    private JPanel oben;
    private JPanel links;
    private JPanel rechts;
    private JPanel unten;
    private JLabel titel;
    private JPanel center;
    private JTextField spielername_textField;
    private JPasswordField passwortPasswordField;
    private JButton anmeldenButton;
    private JButton registrierenButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Anmeldung");
        frame.setContentPane(new Anmeldung().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Anmeldung() {
        anmeldenButton.addActionListener(args -> {
            JFrame frame = new JFrame("Start");
            frame.setContentPane(new Start().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

                 });
    }
 //TODO Attribut jpanel in Klasse Start ist noch public (bad)




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
