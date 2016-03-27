package GUI_Versuch;

import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Thomas on 22.02.2016.
 */
public class AdminScreen extends JPanel implements ActionListener {

    JFrame adminframe = new JFrame();
    JPanel adminSeite = new JPanel(new GridBagLayout());
    JLabel titel = new JLabel("Administrator-Modus");

    JLabel spielernameAlt = new JLabel("alter Spielername");
    JLabel passwortAlt = new JLabel("altes Passwort");
    //JLabel highscoreAlt = new JLabel("alte Highscore");
    JTextField spielernameFeldAlt = new JTextField();
    JTextField passwortFeldAlt = new JTextField();
    //JTextField highscoreFeldAlt = new JTextField();
    JLabel spielernameNeu = new JLabel("neuer Spielername");
    JLabel passwortNeu = new JLabel("neues Passwort");
    JLabel highscoreNeu = new JLabel("neue Highscore");
    JTextField spielernameFeldNeu = new JTextField();
    JTextField passwortFeldNeu = new JTextField();
    JTextField highscoreFeldNeu = new JTextField();
    JLabel dummy = new JLabel("Dummy");



    JButton spielerDatenAendernButton = new JButton("Spielerdaten aendern");
    JButton spielerLoeschenButton = new JButton("Spieler loeschen");
    JButton beendenButton = new JButton("Administrator-Modus Beenden");

    public AdminScreen() {
        adminframe.setSize(1080, 500);
        adminframe.setTitle("Administrator-Modus");
        adminframe.add(adminSeite);


        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;


        //Titel Label
        titel.setFont(new Font("Arial", Font.BOLD, 25));
        c.weightx = 0;
        c.weighty = 0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(25, 25, 25, 25);
        adminSeite.add(titel, c);


        //Spielername Label
        c.weightx = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        c.ipadx = 30;
        adminSeite.add(spielernameAlt, c);

        //Passwort Label
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        c.ipadx = 30;
        //c.fill = GridBagConstraints.HORIZONTAL;
        adminSeite.add(passwortAlt, c);

        /**
        //Highscore Label
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 5;
        //c.ipadx = 50;
        c.insets = new Insets(10, 10, 0, 0);
        adminSeite.add(highscoreAlt, c);
        */

        //Spielername Textfeld
        c.weightx = 1;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx = 200;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(spielernameFeldAlt, c);

        //Passwort Textfeld
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 4;
        c.ipadx = 200;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(passwortFeldAlt, c);



        /**
         * //Highscore Textfeld
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 0, 0);
        adminSeite.add(highscoreFeldAlt, c);
        */




        //Spielername Label
        c.weightx = 1;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 3;
        c.ipadx = 30;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(spielernameNeu, c);

        //Passwort Label
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 4;
        c.ipadx = 30;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(passwortNeu, c);


         //Highscore Label
         c.weightx = 0.0;
         c.weighty = 0.0;
         c.gridwidth = 1;
         c.gridx = 3;
         c.gridy = 5;
         c.ipadx = 30;
         c.insets = new Insets(10, 10, 10, 10);
         adminSeite.add(highscoreNeu, c);


        //Spielername Textfeld
        c.weightx = 1;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 3;
        c.ipadx = 200;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(spielernameFeldNeu, c);

        //Passwort Textfeld
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 4;
        c.ipadx = 200;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(passwortFeldNeu, c);


         //Highscore Textfeld
         c.weightx = 0.0;
         c.weighty = 0.0;
         c.gridwidth = 1;
         c.gridx = 4;
         c.gridy = 5;
         c.ipadx = 200;
         c.insets = new Insets(10, 10, 10, 10);
         adminSeite.add(highscoreFeldNeu, c);




        //Benutzername ändern Button
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 7;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(spielerDatenAendernButton, c);
        spielerDatenAendernButton.addActionListener(this);

        //Benutzer löschen
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(10, 10, 10, 10);
        adminSeite.add(spielerLoeschenButton, c);
        spielerLoeschenButton.addActionListener(this);

        // Adminframe Schliessen Button
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 4;
        c.gridy = 8;
        adminSeite.add(beendenButton, c);
        beendenButton.addActionListener(this);

        //Dummy
        c.gridx = 0;
        c.gridy = 8;
        adminSeite.add(dummy, c);
        dummy.setVisible(false);


    }



    public void actionPerformed(ActionEvent evt)
    {

        if(evt.getSource() == this.beendenButton){
            adminframe.dispose();  //Schließen des HilfeFrames
        }
        else if(evt.getSource() == this.spielerDatenAendernButton){
            dummyaendern();
        }
        else if (evt.getSource() == this.spielerLoeschenButton){
           dummyaendern();
        }

    }

    public void aktiviereAdminScreen(){
        adminframe.setVisible(true);
    }

    public JPanel getAdminSeite() {
        return adminSeite;
    }

    public void setAdminSeite(JPanel adminSeite) {
        this.adminSeite = adminSeite;
    }

    public JButton getBeendenButton() {
        return beendenButton;
    }

    public void setBeendenButton(JButton beendenButton) {
        this.beendenButton = beendenButton;
    }

    public JFrame getAdminframe() {
        return adminframe;
    }

    public void setAdminframe(JFrame adminframe) {
        this.adminframe = adminframe;
    }

    public JButton getSpielerloeschenButton() {
        return spielerLoeschenButton;
    }

    public void setSpielerloeschenButton(JButton spielerloeschenButton) {
        this.spielerLoeschenButton = spielerloeschenButton;
    }

    public JButton getNameaendernButton() {
        return spielerDatenAendernButton;
    }

    public void setNameaendernButton(JButton nameaendernButton) {
        this.spielerDatenAendernButton = nameaendernButton;
    }



    public void dummyaendern(){
        dummy.setVisible(true);
    }




}
