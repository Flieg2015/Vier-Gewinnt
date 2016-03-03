package GUI_Versuch;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thomas on 08.01.16.
 */
public class Endscreen extends JPanel {



    JPanel Seite1 = new JPanel(new GridBagLayout());
    JLabel ende = new JLabel("Spiel beendet!");
    JLabel info = new JLabel("Was möchtest Du als nächstes tun?");
    //JLabel info_spieler = new JLabel("Info-Spieler");
    JButton nochmalButton = new JButton("Nochmal");
    JButton modusButton = new JButton("Spielmodus");
    JButton endeButton = new JButton("Beenden");


    public Endscreen() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        //Spielername Label
        ende.setFont(new Font("Arial", Font.BOLD, 25));
        ende.setHorizontalAlignment(SwingConstants.CENTER);
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 25, 25);
        Seite1.add(ende, c);

        //Spielername Label
        info.setFont(new Font("Arial", Font.BOLD, 16));
        info.setHorizontalAlignment(SwingConstants.CENTER);
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 25, 25);
        Seite1.add(info, c);

        /**
         // Infofeld 1 über angemeldeten Spieler
         c.weightx = 0.0;
         c.gridwidth = 0;
         c.gridx = 1;
         c.gridy = 1;
         c.insets = new Insets(0, 0, 10, 10);
         Seite1.add(info_spieler, c);
         */

        // Player vs. Computer -Button
        Seite1.add(nochmalButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 10, 10);
        Seite1.add(nochmalButton, c);

        Seite1.add(modusButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 10, 10);
        Seite1.add(modusButton, c);

        Seite1.add(endeButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 10, 10);
        Seite1.add(endeButton, c);
    }


    //Getter und Setter
    public JPanel getSeite1() {
        return Seite1;
    }

    public void setSeite1(JPanel seite1) {
        Seite1 = seite1;
    }

    public JLabel getEnde() {
        return ende;
    }

    public void setEnde(JLabel ende) {
        this.ende = ende;
    }

    public JLabel getInfo() {
        return info;
    }

    public void setInfo(JLabel info) {
        this.info = info;
    }

    public JButton getNochmalButton() {
        return nochmalButton;
    }

    public void setNochmalButton(JButton nochmalButton) {
        this.nochmalButton = nochmalButton;
    }

    public JButton getModusButton() {
        return modusButton;
    }

    public void setModusButton(JButton modusButton) {
        this.modusButton = modusButton;
    }

    public JButton getEndeButton() {
        return endeButton;
    }

    public void setEndeButton(JButton endeButton) {
        this.endeButton = endeButton;
    }
}
















