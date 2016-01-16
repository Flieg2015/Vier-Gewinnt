package GUI_Versuch;

import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by tim on 08.01.16.
 */
public class Anmeldescreen extends JPanel {

    JPanel Seite1 = new JPanel(new GridBagLayout());
    JLabel titel = new JLabel("Vier gewinnt");
    JLabel ausgabe = new JLabel("");
    JLabel spielername = new JLabel("Spielername");
    JLabel passwort = new JLabel("Passwort");
    JTextField spielernamefeld = new JTextField();
    JTextField passwortfeld = new JPasswordField();
    JButton anmeldeButton = new JButton("Anmelden");
    JButton registrierenButton = new JButton("Registrieren");
    JLabel bild = new JLabel();


    public  Anmeldescreen()
    {

        GridBagConstraints ca = new GridBagConstraints();
        ca.gridx = GridBagConstraints.REMAINDER;
        ca.fill = GridBagConstraints.HORIZONTAL;

        //Titel Label
        titel.setFont(new Font("Arial", Font.BOLD, 25));
        ca.weightx = 0.0;
        ca.gridwidth = 0;
        ca.gridx = 0;
        ca.gridy = 0;
        ca.insets = new Insets(0, 35, 25, 25);
        Seite1.add(titel, ca);

        //Titel Ausgabe
        ausgabe.setFont(new Font("Arial", Font.BOLD, 21));
        ausgabe.setForeground(Color.red);
        ca.weightx = 0.0;
        ca.gridwidth = 0;
        ca.gridx = 0;
        ca.gridy = 4;
        ca.insets = new Insets(0, 35, 25, 25);
        Seite1.add(ausgabe, ca);

        //Spielername Label
        ca.weightx = 0.0;
        ca.gridwidth = 0;
        ca.gridx = 0;
        ca.gridy = 3;
        ca.insets = new Insets(10, 10, 0, 0);
        Seite1.add(spielername, ca);

        //Passwort Label
        ca.weightx = 0.0;
        ca.gridwidth = 0;
        ca.gridx = 0;
        ca.gridy = 4;
        ca.insets = new Insets(10, 10, 0, 0);
        Seite1.add(passwort, ca);

        //Spielername Textfeld
        ca.weightx = 0.0;
        ca.gridwidth = 1;
        ca.gridx = 2;
        ca.gridy = 3;
        ca.insets = new Insets(10, 10, 0, 50);
        Seite1.add(spielernamefeld, ca);

        //Passwort Textfeld

        ca.weightx = 0.0;
        ca.gridwidth = 1;
        ca.gridx = 2;
        ca.gridy = 4;
        ca.insets = new Insets(10, 10, 0, 50);
        Seite1.add(passwortfeld, ca);

        // Anmelden-Button
        //c.fill = GridBagConstraints.HORIZONTAL;
        ca.weightx = 0;
        ca.gridwidth = 1;
        ca.gridx = 0;
        ca.gridy = 5;
        ca.insets = new Insets(10, 10, 0, 0);
        Seite1.add(anmeldeButton, ca);


        // Registrieren-Button
        //c.fill = GridBagConstraints.HORIZONTAL;
        ca.weightx = 0;
        ca.gridwidth = 1;
        ca.gridx = 2;
        ca.gridy = 5;
        ca.insets = new Insets(10, 10, 0, 50);
        Seite1.add(registrierenButton, ca);

        //Bild auf der rechten Seite
        bild = new JLabel(new ImageIcon("src/pics/spiel.png"));
        ca.weightx = 0.5;
        ca.gridwidth = 0;
        ca.gridx = 3;
        ca.gridy = 1;
        ca.insets = new Insets(0, 0, 0, 0);
        Seite1.add(bild);


    }

    public JPanel getSeite1() {
        return Seite1;
    }

    public void setSeite1(JPanel seite1) {
        Seite1 = seite1;
    }

    public JLabel getTitel() {
        return titel;
    }

    public void setTitel(JLabel titel) {
        this.titel = titel;
    }

    public JLabel getAusgabe() {
        return ausgabe;
    }

    public void setAusgabe(JLabel ausgabe) {
        this.ausgabe = ausgabe;
    }

    public JLabel getSpielername() {
        return spielername;
    }

    public void setSpielername(JLabel spielername) {
        this.spielername = spielername;
    }

    public JLabel getPasswort() {
        return passwort;
    }

    public void setPasswort(JLabel passwort) {
        this.passwort = passwort;
    }

    public JTextField getSpielernamefeld() {
        return spielernamefeld;
    }

    public void setSpielernamefeld(JTextField spielernamefeld) {
        this.spielernamefeld = spielernamefeld;
    }

    public JTextField getPasswortfeld() {
        return passwortfeld;
    }

    public void setPasswortfeld(JTextField passwortfeld) {
        this.passwortfeld = passwortfeld;
    }

    public JButton getAnmeldeButton() {
        return anmeldeButton;
    }

    public void setAnmeldeButton(JButton anmeldeButton) {
        this.anmeldeButton = anmeldeButton;
    }

    public JButton getRegistrierenButton() {
        return registrierenButton;
    }

    public void setRegistrierenButton(JButton registrierenButton) {
        this.registrierenButton = registrierenButton;
    }
}
