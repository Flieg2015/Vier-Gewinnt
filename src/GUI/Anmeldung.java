package GUI;

import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Thomas on 05.08.2015.
 */
public class Anmeldung extends JFrame implements ActionListener {


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
    private JLabel ausgabe;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Anmeldung");
        frame.setContentPane(new Anmeldung().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Anmeldung() {

        JFrame frame = new JFrame("Start");

        anmeldenButton.addActionListener(this);
        registrierenButton.addActionListener(this);

       // frame.setContentPane(new Start().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
    //TODO Attribut jpanel in Klasse Start ist noch public (bad)


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void actionPerformed(ActionEvent ae) {

        SpielerDAO spielerDAO = SpielerDAOFactory.createSpielerDAO();

        if (ae.getSource() == this.anmeldenButton) {

            Spieler spieler = new Spieler(spielername_textField.getText(), passwortPasswordField.getText());

            // System.out.println(spieler.toString());


            if (spielerDAO.proofByName(spieler.getName()) == false) {

                ausgabe.setText(("Benutzername falsch"));
            }



            else {

                Spieler mySpieler = spielerDAO.findByName(spieler.getName()); // mySpieler ist der Der richtige Spieler aus der DB

                // System.out.println(mySpieler.toString());

                if (spieler.getPasswd().equals(mySpieler.getPasswd())) {


                   ausgabe.setText(("Anmeldung Erfolgreich"));
                } else {
                    ausgabe.setText(("Passwd falsch"));
                }


            }


        }

        if (ae.getSource() == this.registrierenButton) {




        }




    }






}
