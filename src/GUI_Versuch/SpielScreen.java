package GUI_Versuch;

import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;
import db.spieler.SpielerDAOJDBCImpl;
import logik.Spiel;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by tim on 08.01.16.
 */
public class SpielScreen extends JPanel{

    private Bilder meinespielsteine = new Bilder();
    private JPanel Seite1 = new JPanel(new GridBagLayout());
    //private JPanel Feld = new JPanel(new GridBagLayout());


    private JLabel[][] stein = new JLabel[7][6];
    //private JLabel s1 = new JLabel();
    //private JLabel s2 = new JLabel();


    private JTextArea s1;
    private JTextArea s2;



    private JLabel tlabel = new JLabel();
    private ImageIcon Weiss= new ImageIcon("src/pics/weiss1.png");
    private ImageIcon Rot= new ImageIcon("src/pics/rot1.png");
    private ImageIcon Gelb= new ImageIcon("src/pics/gelb1.png");
    private ImageIcon Rot_Sieg= new ImageIcon("src/pics/rot1_gewinnt1.png");        // ImageIcon fuer roten Sieg
    private ImageIcon Gelb_Sieg= new ImageIcon("src/pics/gelb1_gewinnt1.png");      // ImageIcon fuer gelben Sieg
    private JLabel dummy1 = new JLabel();
    private JLabel dummy2 = new JLabel();

    private JButton[] wurfButton = new JButton[7];
    private JButton nochmalButton = new JButton("Nochmal Spielen");
    private JButton wechselnButton = new JButton("Spielmodus wechseln");

    private JTextArea bl = new JTextArea(5, 20);


    public SpielScreen() {
        s1 = new JTextArea(5,20);
        s1.setLineWrap(true); //Zeilenumbruch wird eingeschaltet
        s1.setWrapStyleWord(true); //Zeilenumbrüche erfolgen nur nach ganzen Wörtern

        s2 = new JTextArea(5,20);
        s2.setLineWrap(true);  //Zeilenumbruch wird eingeschaltet
        s2.setWrapStyleWord(true); //Zeilenumbrüche erfolgen nur nach ganzen Wörtern

        GridBagConstraints cs = new GridBagConstraints();
        cs.gridx = GridBagConstraints.REMAINDER;
        cs.fill = GridBagConstraints.HORIZONTAL;

        tlabel = new JLabel("Vier Gewinnt");
        tlabel.setFont(new Font("Arial", Font.BOLD, 25));
        cs.weightx = 0.5;
        cs.gridwidth = 0;
        cs.gridx = 4;
        cs.gridy = 0;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(tlabel, cs);

        // s1 = new JLabel("Infos Spieler 1");
        cs.weightx = 0.0;
        cs.gridwidth = 1;
        cs.gridx = 0;
        cs.gridy = 2;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(s1, cs);
        s1.setBackground(Color.red);


        //s2 = new JLabel("Infos Spieler 2");
        cs.weightx = 0.0;
        cs.gridwidth = 1;
        cs.gridx = 9;
        cs.gridy = 2;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(s2, cs);

    // Bestenliste Anordnung

        cs.weightx = 0.0;
        cs.gridwidth = 1;
        cs.gridx = 14;
        cs.gridy = 2;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(bl, cs);
        //Zeilenumbruch wird eingeschaltet
        bl.setLineWrap(true);

        //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
        bl.setWrapStyleWord(true);
        bl.setVisible(false);


        //Feld.setBackground(Color.blue);

        //Spielstein
        int i = 0;
        int j = 0;
        for (i = 0; i <= 6; i++) {
            for (j = 0; j <= 5; j++) {
                //Methode zum Zeichnen der Steine



                stein[i][j] = new JLabel(Weiss);
                cs.weightx = 0.0;
                cs.gridwidth = 1;
                cs.gridx = i+1;
                cs.gridy = j+1;
                cs.insets = new Insets(10, 10, 10, 10);
                Seite1.add(stein[i][j], cs);
            }
        }

        // Einwurf-Button
        i = 0;
        for (i = 0; i <= 6; i++) {
            wurfButton[i] = new JButton("Einwerfen");
            //c.fill = GridBagConstraints.HORIZONTAL;
            cs.weightx = 0.0;
            cs.gridwidth = 1;
            cs.gridx = i+1;
            cs.gridy = 8;
            cs.insets = new Insets(25, 10, 0, 0);
            Seite1.add(wurfButton[i], cs);
        }

        dummy1 = new JLabel("");
        cs.weightx = 0.0;
        cs.weighty = 0.0;
        cs.gridx = 0;
        cs.gridy = 10;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(dummy1, cs);

        dummy2 = new JLabel("");
        cs.weightx = 0.0;
        cs.weighty = 0.0;
        cs.gridx = 0;
        cs.gridy = 11;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(dummy2, cs);

        // Replay-Button
        nochmalButton = new JButton("Neues Spiel");
        cs.fill = GridBagConstraints.BOTH;
        cs.weightx = 0.0;
        cs.weighty = 0.0;
        cs.gridwidth = 2;
        cs.gridx = 3;
        cs.gridy = 9;
        cs.insets = new Insets(10, 10, 10, 10);

        Seite1.add(nochmalButton, cs);
        nochmalButton.setVisible(false);

        // Modus Wechseln Button
        wechselnButton = new JButton("Neuer Modus");
        //c.fill = GridBagConstraints.HORIZONTAL;
        cs.weightx = 0.0;
        cs.weighty = 0.0;
        cs.gridwidth = 2;
        cs.gridx = 5;
        cs.gridy = 9;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(wechselnButton, cs);
        wechselnButton.setVisible(false);



        //Seite1.add(Feld, java.awt.BorderLayout.CENTER);





    }

    public void sperreButtons() {       // sperren der Einwurf-Buttons (bei Sieg angewendet)
        int i;

        for (i = 0; i <= 6; i++) {
            wurfButton[i].setEnabled(false);
        }
    }

    public void entsperreButtons() {       // sperren der Einwurf-Buttons (bei Sieg angewendet)
        int i;

        for (i = 0; i <= 6; i++) {
            wurfButton[i].setEnabled(true);
            wurfButton[i].setText("Einwerfen");
        }
    }


    public void sperreButton(int i) {       // sperren eines Einwurf-Button, wenn Spalte voll
        wurfButton[i].setEnabled(false);
        wurfButton[i].setText("Spalte voll");
    }

    public void aktiviereButton(int i) {       // sperren eines Einwurf-Button, wenn Spalte voll
        wurfButton[i].setEnabled(true);
        wurfButton[i].setText("Einwerfen");
    }

    public void markiereAktuellerSpieler(int i) {       // faerbt den Hintergrund des aktuellen Spielers ein
        if (i == 1) {
            s1.setBackground(Color.red);
            s2.setBackground(Color.white);
        }
        if (i == 2) {
            s1.setBackground(Color.white);
            s2.setBackground(Color.yellow);
        }
    }

    public void aktiviereSpielwiederholungsButton() {   // macht den Spielwiederholungsbutton sichtbar
        nochmalButton.setVisible(true);
        wechselnButton.setVisible(true);
    }

    public void deaktiviereSpielwiederholungsButton() {   // macht den Spielwiederholungsbutton sichtbar
        nochmalButton.setVisible(false);
        wechselnButton.setVisible(false);
    }


    public JButton getNochmalButton(){return nochmalButton;}
    public JButton getWechselnButton(){return wechselnButton;}


    public JPanel getSeite1() {
        return Seite1;
    }

    public void setSeite1(JPanel seite1) {
        Seite1 = seite1;
    }

    public JLabel getStein(int i, int j) {
        return stein[i][j];
    }

    public void setStein(int i, int j, int farbe) {

        if(farbe==1)  stein[i][j].setIcon(Rot);
        if(farbe==0)  stein[i][j].setIcon(Weiss);
        if(farbe==2)  stein[i][j].setIcon(Gelb);

    }

    public void setSteinSieg(int i, int j, int farbe) {     // Methode zum markieren der siegreichen Steinkombination(en)

        if(farbe==1)  stein[i][j].setIcon(Rot_Sieg);
        if(farbe==2)  stein[i][j].setIcon(Gelb_Sieg);

    }


    public JButton getWurfButton(int  i) {return wurfButton[i];
    }




    public void setWurfButton(JButton[] wurfButton) {
        this.wurfButton = wurfButton;
    }

    public void setTextInfo(Spieler spieler1, Spieler spieler2){

        s1.setText("Spieler 1\n " +
                spieler1.getName()+"\n" +
                "Dein Score \n" +
                spieler1.getHighscore());

        s2.setText("Spieler 2\n " +
                spieler2.getName()+"\n" +
                "Dein Score \n" +
                spieler2.getHighscore());

    }

    public JLabel getTlabel() {
        return tlabel;
    }

    public void setTlabel(JLabel tlabel) {
        this.tlabel = tlabel;
    }


    public void aktualsiereBestenliste(Spieler Gewinner, Spieler Verlierer) {
        SpielerDAO dummy = SpielerDAOFactory.createSpielerDAO();
        String bestenText="Bestenliste\n";


        Spieler spieler;
        ArrayList<String> liste = dummy.getBestenliste();

        boolean gewinnerdabei=false;
        boolean verlieredabei=false;


        while (liste.isEmpty() == false) {

            spieler = dummy.findByName(liste.get(0));
            liste.remove(0);

            if (spieler.getName().equals(Gewinner.getName()) || Gewinner.getName().equals("Computer")  ) {
                gewinnerdabei=true;

            }
            if (spieler.getName().equals(Gewinner.getName()) ||  Gewinner.getName().equals("Computer")) {

                verlieredabei=true;

            }
            String einfuegen=spieler.getName()+" " + spieler.getHighscore()+"\n";

            bestenText+=einfuegen;



        }

        if(gewinnerdabei==false){
            String einfuegen=Gewinner.getName()+" " + Gewinner.getHighscore()+"\n";

            bestenText+=einfuegen;
        }
        if(verlieredabei==false){
            String einfuegen=Verlierer.getName()+" " + Verlierer.getHighscore()+"\n";

            bestenText+=einfuegen;
        }


        bl.setText(bestenText);

    }

    public void bestenlistenangeben(Spieler Gewinner, Spieler Verlierer) {
        aktualsiereBestenliste(Gewinner, Verlierer);
        bl.setVisible(true);

    }

    public void bestenausblenden() {

        bl.setVisible(false);

    }

}
