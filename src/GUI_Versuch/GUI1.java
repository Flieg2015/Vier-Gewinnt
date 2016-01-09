/**
 * Created by Thomas on 27.10.2015.
 */

package GUI_Versuch;


import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;
import logik.Spiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public final class GUI1 extends JPanel {

    JLabel titel = new JLabel("Vier gewinnt");

    //final static boolean shouldFill = true;
    //final static boolean shouldWeightX = true;
    //final static boolean RIGHT_TO_LEFT = false;


    private JLabel ausgabe;
    private CardLayout cl=new CardLayout();
    private Bilder meinespielsteine = new Bilder();
    private JPanel panels= new JPanel(cl);
    private Anmeldescreen anmeldeScreen= new Anmeldescreen();
    //private Anmeldescreen anmeldeScreen2= new Anmeldescreen();
    private AuswahlScreen auswahlScreen= new AuswahlScreen();
    private SpielScreen spielScreen=new SpielScreen();

    Spiel aktuelles_Spiel=new Spiel(null);



    public void addComponentToPane(Container pane) {


        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        createPanels();
        pane.add(panels, c);
    }

    private void createPanels() {

        cl = new CardLayout();
        panels = new JPanel(cl);

        panels.add(anmeldeScreen.getSeite1(), "Anmeldescreen");
        configAnmeldeScreenButton();

        panels.add(anmeldeScreen.getSeite1(), "Anmeldescreen2");


        panels.add(auswahlScreen.getSeite1(), "Spielauswahl");
        configAuswahlScreenButton();

        panels.add(spielScreen.getSeite1(), "Spielscreen");

        panels.revalidate();
    }



    //Erstellen des Anmeldescreens
    public void configAnmeldeScreenButton() {



        anmeldeScreen.getAnmeldeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {


                //cl.next(panels); // Test auskommentieren um Funktion wieder herzustellen

                SpielerDAO spielerDAO = SpielerDAOFactory.createSpielerDAO();
                if (ae.getSource() == anmeldeScreen.getAnmeldeButton()) {

                    Spieler spieler = new Spieler(anmeldeScreen.getSpielernamefeld().getText(), anmeldeScreen.getPasswortfeld().getText());

                    System.out.println(spieler.toString());


                    if (spielerDAO.proofByName(spieler.getName()) == false) {
                        anmeldeScreen.getAusgabe().setText(("Benutzername falsch"));
                    } else {

                        Spieler mySpieler = spielerDAO.findByName(spieler.getName()); // mySpieler ist der Der richtige Spieler aus der DB

                        //System.out.println(mySpieler.toString());

                        if (spieler.getPasswd().equals(mySpieler.getPasswd()) && aktuelles_Spiel.getSpieler1()==null ) {

                            aktuelles_Spiel.setSpieler1(mySpieler);

                            System.out.print("Spieler 1"+aktuelles_Spiel.getSpieler1().toString());
                            auswahlScreen.getInfo_spieler().setText("Angemeldet als "+aktuelles_Spiel.getSpieler1().getName()+" dein Score "+aktuelles_Spiel.getSpieler1().getHighscore());

                            cl.next(panels); // Wechsel auf das nachste Panel                            // spieler1 wird gesetzt als angemeldet

                            anmeldeScreen.getAusgabe().setForeground(Color.green);
                            //ausgabe.setText(("Anmeldung Erfolgreich"));
                            anmeldeScreen.getPasswortfeld().setText("");
                            anmeldeScreen.getSpielernamefeld().setText("");
                            anmeldeScreen.getAusgabe().setText((""));
                            anmeldeScreen.getAusgabe().setForeground(Color.red);


                        } else if (spieler.getPasswd().equals(mySpieler.getPasswd()) && aktuelles_Spiel.getSpieler2() == null && !aktuelles_Spiel.getSpieler1().equals(mySpieler)) {
                            aktuelles_Spiel.setSpieler2(mySpieler);
                            cl.show(panels, "Spielscreen"); // Wechsel auf das nachste Panel                            // spieler2 wird gesetzt als angemeldet
                            System.out.print("Spieler 1"+aktuelles_Spiel.getSpieler1().toString());
                            System.out.print("Spieler 2"+aktuelles_Spiel.getSpieler2().toString());

                            anmeldeScreen.getPasswortfeld().setText("");
                            anmeldeScreen.getSpielernamefeld().setText("");
                            anmeldeScreen.getAusgabe().setText((""));
                            anmeldeScreen.getAusgabe().setForeground(Color.red);


                        } else {
                            anmeldeScreen.getAusgabe().setText(("Passwd falsch"));
                        }
                    }

                }


            }









    });

}
    private void configAuswahlScreenButton() {


        auswahlScreen.getPvcButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Spieler KI=new Spieler("Computer");

                aktuelles_Spiel.setSpieler2(KI);
                aktuelles_Spiel.setAktuellerSpieler(aktuelles_Spiel.getSpieler1());
                panels.updateUI();

                cl.show(panels, "Spielscreen");

            }
        });


               auswahlScreen.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aktuelles_Spiel.setSpieler1(null);

                cl.first(panels);
            }
        });


        auswahlScreen.getPvpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // setSpieler1(null);

                cl.show(panels, "Anmeldescreen2");
            }
        });



    }
    //Spielscreen
    private void configSpielScreenButton() {// TOdo Einfügen der action listener für die Einfurbuttons



        }







    private static void createGUI() {



        JFrame frame = new JFrame("Vier Gewinnt");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //Zentrieren des Bildschirms
        frame.setTitle("Vier Gewinnt");

        GUI1 contentPane = new GUI1();
        contentPane.addComponentToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(720, 480));

    }

    public void paint(Graphics gr){
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.BLUE);
        g.fill(g.getClipBounds());

        g.drawImage(meinespielsteine.rot, 12, 0, 100, 100, null); //Position x,y,Streckung x, Streckung y
        g.drawImage(meinespielsteine.gelb, 120, 0, 50, 50, null);
        g.drawImage(meinespielsteine.weiss, 250, 250, 75, 75, null);
    }
    public static void main(String[] args) {
        createGUI();
    }

}


