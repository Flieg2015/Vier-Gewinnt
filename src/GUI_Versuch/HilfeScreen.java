package GUI_Versuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Created by Thomas on 22.02.2016.
 */
public class HilfeScreen extends JPanel implements ActionListener {


    JFrame hilfeframe = new JFrame();
    JPanel hilfeSeite = new JPanel(new GridBagLayout());
    JLabel titel = new JLabel("Spielregeln zu Vier-Gewinnt");
    JLabel regeln = new JLabel();


    JButton beendenButton = new JButton("Hilfe Schliessen");
    //private ImageIcon  regeln = new ImageIcon("src/pics/regeln.png");


    public HilfeScreen() {
        hilfeframe.setSize(1000, 700);
        hilfeframe.setTitle("Spieleanleitung");
        hilfeframe.add(hilfeSeite);


        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.NONE;

        //Titel Label
        titel.setFont(new Font("Arial", Font.BOLD, 25));
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(25, 25, 25, 25);
        hilfeSeite.add(titel, c);

        //Einbinden des Bildes Info
        URL url = getClass().getResource("/GUI_Versuch/pics/regeln.png");
        ImageIcon icon = new ImageIcon(url);
        JLabel regeln = new JLabel(icon, JLabel.CENTER);
        c.weightx = 0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        hilfeSeite.add(regeln);

        // Hilfe Schliessen Button
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 0);
        hilfeSeite.add(beendenButton, c);
        beendenButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evt)
    {	hilfeframe.dispose();  //Schließen des AdminFrames
    }


    public JPanel getInfoSeite() {
        return hilfeSeite;
    }

    public void setInfoSeite(JPanel infoSeite) {
        this.hilfeSeite = infoSeite;
    }

    public void aktiviereHilfeScreen(){
        hilfeframe.setVisible(true);
    }

    public JButton getBeendenButton() {
        return beendenButton;
    }

    public void setBeendenButton(JButton beendenButton) {
        this.beendenButton = beendenButton;
    }
}
