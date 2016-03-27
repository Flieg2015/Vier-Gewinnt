package GUI_Versuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Thomas on 22.02.2016.
 */
public class InfoScreen extends JPanel implements ActionListener {


    JFrame infoframe = new JFrame();
    JPanel infoSeite = new JPanel(new GridBagLayout());
    JLabel titel = new JLabel("Informationen");
    JLabel regeln = new JLabel();


    JButton beendenButton = new JButton("Information schliessen");
    //private ImageIcon  regeln = new ImageIcon("src/pics/regeln.png");


    public InfoScreen() {
        infoframe.setSize(750, 550);
        infoframe.setTitle("Information");
        infoframe.add(infoSeite);


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
        infoSeite.add(titel, c);



        /**regeln = new JLabel(new ImageIcon("src/pics/info.png"));
        c.weightx = 0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        infoSeite.add(regeln);
         */

        // Hilfe Schliessen Button
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 0);
        infoSeite.add(beendenButton, c);
        beendenButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evt)
    {	infoframe.dispose();  //Schließen des AdminFrames
    }



    public JPanel getInfoSeite() {
        return infoSeite;
    }

    public void setInfoSeite(JPanel infoSeite) {
        this.infoSeite = infoSeite;
    }

    public void aktiviereHilfeScreen(){
        infoframe.setVisible(true);
    }

    public JButton getBeendenButton() {
        return beendenButton;
    }

    public void setBeendenButton(JButton beendenButton) {
        this.beendenButton = beendenButton;
    }
}
