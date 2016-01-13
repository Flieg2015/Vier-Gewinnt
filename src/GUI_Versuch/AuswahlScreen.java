package GUI_Versuch;

import db.spieler.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tim on 08.01.16.
 */
public class AuswahlScreen extends JPanel {

    JPanel Seite1 = new JPanel(new GridBagLayout());
    JLabel auswahl = new JLabel("Auswahl");
    JLabel info_spieler = new JLabel("Info-Spieler?!?");
    JButton pvcButton = new JButton("Player vs. Computer");
    JButton backButton = new JButton("Abmelden");
    JButton pvpButton = new JButton("Player vs. Player");

    public AuswahlScreen(){

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        //Spielername Label
        auswahl.setFont(new Font("Arial", Font.BOLD, 25));
        auswahl.setHorizontalAlignment(SwingConstants.CENTER);
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 25, 25);
        Seite1.add(auswahl, c);

        // Infofeld 1 über angemeldeten Spieler

        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 10, 10);
        Seite1.add(info_spieler, c);

        // Player vs. Computer -Button

        Seite1.add(pvcButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 10, 10);
        Seite1.add(pvcButton, c);

        Seite1.add(pvpButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 10, 10);
        Seite1.add(pvpButton, c);

        Seite1.add(backButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 10, 10);
        Seite1.add(backButton, c);
    }


    public JPanel getSeite1() {
        return Seite1;
    }

    public void setSeite1(JPanel seite1) {
        Seite1 = seite1;
    }

    public JLabel getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(JLabel auswahl) {
        this.auswahl = auswahl;
    }

    public JLabel getInfo_spieler() {
        return info_spieler;
    }

    public void setInfo_spieler(JLabel info_spieler) {
        this.info_spieler = info_spieler;
    }

    public JButton getPvcButton() {
        return pvcButton;
    }

    public void setPvcButton(JButton pvcButton) {
        this.pvcButton = pvcButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getPvpButton() {
        return pvpButton;
    }

    public void setPvpButton(JButton pvpButton) {
        this.pvpButton = pvpButton;
    }
}












