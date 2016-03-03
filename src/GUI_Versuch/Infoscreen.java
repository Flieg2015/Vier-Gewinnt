package GUI_Versuch;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thomas on 22.02.2016.
 */
public class Infoscreen extends JPanel {

    JPanel infoSeite = new JPanel(new GridBagLayout());
    JLabel titel = new JLabel("Anleitung zu 4gewinnt");
    JFrame infoframe = new JFrame();


    public Infoscreen() {
        infoframe.setSize(720, 480);
        infoframe.setTitle("Spieleanleitung");


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
        infoSeite.add(titel, ca);
    }

    public JPanel getInfoSeite() {
        return infoSeite;
    }


    public void setInfoSeite(JPanel infoSeite) {
        this.infoSeite = infoSeite;
    }

        public void aktiviereInfoScreen(){
        infoframe.setVisible(true);
    }
}
