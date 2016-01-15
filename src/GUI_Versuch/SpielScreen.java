package GUI_Versuch;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by tim on 08.01.16.
 */
public class SpielScreen extends JPanel{

    private Bilder meinespielsteine = new Bilder();
    private JPanel Seite1 = new JPanel(new BorderLayout());
    private JPanel Feld = new JPanel(new GridBagLayout());
    private JPanel Einwurf = new JPanel (new GridBagLayout());
    private JPanel Spieler1 = new JPanel(new GridBagLayout());
    private JPanel Spieler2 = new JPanel(new GridBagLayout());
    private JPanel tpanel = new JPanel();

    private JLabel[][] stein = new JLabel[7][6];
    private JLabel s1 = new JLabel();
    private JLabel s2 = new JLabel();
    private JLabel tlabel = new JLabel();


    private JButton[] wurfButton = new JButton[7];



    public SpielScreen() {

        tlabel = new JLabel("Vier Gewinnt");
        tlabel.setFont(new Font("Arial", Font.BOLD, 25));
        tpanel.add(tlabel);

        GridBagConstraints cs = new GridBagConstraints();
        cs.gridx = GridBagConstraints.REMAINDER;
        cs.fill = GridBagConstraints.HORIZONTAL;


        s1 = new JLabel("Infos Spieler 1");
        cs.weightx = 0.0;
        cs.gridwidth = 1;
        cs.gridx = 0;
        cs.gridy = 0;
        cs.insets = new Insets(10, 10, 10, 10);
        Spieler1.add(s1, cs);

        s2 = new JLabel("Infos Spieler 2");
        cs.weightx = 0.0;
        cs.gridwidth = 1;
        cs.gridx = 0;
        cs.gridy = 0;
        cs.insets = new Insets(10, 10, 10, 10);
        Spieler2.add(s2, cs);




        Feld.setBackground(Color.blue);

        //Spielstein
        int i = 0;
        int j = 0;
        for (i = 0; i <= 6; i++) {
            for (j = 0; j <= 5; j++) {
                //Methode zum Zeichnen der Steine



                stein[i][j] = new JLabel(new ImageIcon("src/pics/weiss1.png"));
                cs.weightx = 0.0;
                cs.gridwidth = 1;
                cs.gridx = i;
                cs.gridy = j;
                cs.insets = new Insets(10, 10, 10, 10);
                Feld.add(stein[i][j], cs);
            }
        }

        // Einwurf-Button
        i = 0;
        for (i = 0; i <= 6; i++) {
            wurfButton[i] = new JButton("Einwerfen");
            //c.fill = GridBagConstraints.HORIZONTAL;
            cs.weightx = 0.0;
            cs.gridwidth = 1;
            cs.gridx = i;
            cs.gridy = 0;
            cs.insets = new Insets(25, 10, 0, 0);
            Einwurf.add(wurfButton[i], cs);
        }


        Seite1.add(Feld, java.awt.BorderLayout.CENTER);
        Seite1.add(Einwurf, BorderLayout.SOUTH);
        Seite1.add(Spieler1, BorderLayout.WEST);
        Seite1.add(Spieler2, BorderLayout.EAST);
        Seite1.add(tpanel, BorderLayout.NORTH);




    }

    public JPanel getSeite1() {
        return Seite1;
    }

    public void setSeite1(JPanel seite1) {
        Seite1 = seite1;
    }

    public JLabel[][] getStein() {
        return stein;
    }

    public void setStein(JLabel[][] stein) {
        this.stein = stein;
    }

    public JButton[] getWurfButton() {return wurfButton;
    }

    public void setWurfButton(JButton[] wurfButton) {
        this.wurfButton = wurfButton;
    }



}


