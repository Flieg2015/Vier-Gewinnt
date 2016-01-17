package GUI_Versuch;

import db.spieler.Spieler;

import javax.swing.*;
import java.awt.*;


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

    private JButton[] wurfButton = new JButton[7];



    public SpielScreen() {



        s1 = new JTextArea(5,20);


        //Zeilenumbruch wird eingeschaltet
        s1.setLineWrap(true);

        //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
        s1.setWrapStyleWord(true);


        s2 = new JTextArea(5,20);

        //Zeilenumbruch wird eingeschaltet
        s2.setLineWrap(true);

        //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
        s2.setWrapStyleWord(true);

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
        Seite1.add(tlabel);



       // s1 = new JLabel("Infos Spieler 1");
        cs.weightx = 0.0;
        cs.gridwidth = 1;
        cs.gridx = 0;
        cs.gridy = 2;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(s1, cs);


        //s2 = new JLabel("Infos Spieler 2");
        cs.weightx = 0.0;
        cs.gridwidth = 1;
        cs.gridx = 9;
        cs.gridy = 2;
        cs.insets = new Insets(10, 10, 10, 10);
        Seite1.add(s2, cs);




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


        //Seite1.add(Feld, java.awt.BorderLayout.CENTER);





    }

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
}


