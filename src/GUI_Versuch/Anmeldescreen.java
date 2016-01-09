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

    public  Anmeldescreen()
    {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        //Titel Label
        titel.setFont(new Font("Arial", Font.BOLD, 25));
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 35, 25, 25);
        Seite1.add(titel, c);

        //Titel Ausgabe

        ausgabe.setFont(new Font("Arial", Font.BOLD, 21));
        ausgabe.setForeground(Color.red);
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 35, 25, 25);
        Seite1.add(ausgabe, c);

        //Spielername Label

        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 0);
        Seite1.add(spielername, c);

        //Passwort Label

        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 0);
        Seite1.add(passwort, c);

        //Spielername Textfeld

        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 0);
        Seite1.add(spielernamefeld, c);

        //Passwort Textfeld

        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 0);
        Seite1.add(passwortfeld, c);

        // Anmelden-Button

        Seite1.add(anmeldeButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 0);
        Seite1.add(anmeldeButton, c);


        // Registrieren-Button

        Seite1.add(registrierenButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 0);
        Seite1.add(registrierenButton, c);

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
