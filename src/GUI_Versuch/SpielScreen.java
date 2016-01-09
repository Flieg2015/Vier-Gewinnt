package GUI_Versuch;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tim on 08.01.16.
 */
public class SpielScreen extends JPanel{

  private JPanel Seite1 = new JPanel(new GridBagLayout());
    private JLabel[][] stein = new JLabel[7][6];

    private JButton[] wurfButton = new JButton[7];

    public SpielScreen(){

            GridBagConstraints c = new GridBagConstraints();
            c.gridx = GridBagConstraints.REMAINDER;
            c.fill = GridBagConstraints.HORIZONTAL;




            //Spielername Label
            //JLabel Spielfeld = new JLabel("Spielfeld");
            //c.weightx = 0.0;
            //c.gridwidth = 0;
            //c.gridx = 0;
            //c.gridy = 0;
            //c.insets = new Insets(0, 0, 0, 0);
            //Spielscreen.add(Spielfeld, c);



            //Spielstein
            int i = 0;
            int j = 0;
            for (i = 0; i <= 6; i++){
                for(j = 0;  j <= 5; j++){
                    //Methode zum Zeichnen der Steine


                     stein[i][j] = new JLabel("w");
                    c.weightx = 0.0;
                    c.gridwidth = 0;
                    c.gridx = i;
                    c.gridy = j;
                    c.insets = new Insets(10, 10, 0, 0);
                    Seite1.add(stein[i][j], c) ;
                }
            }

            // Einwurf-Button
            i = 0;
            for(i = 0; i <=6; i++) {
                wurfButton[i] = new JButton("Einwerfen");
                Seite1.add(wurfButton[i], c);
                //c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.0;
                c.gridwidth = 1;
                c.gridx = i;
                c.gridy = 8;
                c.insets = new Insets(10, 10, 0, 0);
                Seite1.add(wurfButton[i], c);
            }

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

    public JButton[] getWurfButton() {
        return wurfButton;
    }

    public void setWurfButton(JButton[] wurfButton) {
        this.wurfButton = wurfButton;
    }
}


