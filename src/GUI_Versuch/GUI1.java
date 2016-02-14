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

    private Spiel aktuelles_Spiel = new Spiel();
    private CardLayout cl=new CardLayout();
    private Bilder meinespielsteine = new Bilder();
    private JPanel panels= new JPanel(cl);
    private Anmeldescreen anmeldeScreen= new Anmeldescreen();
    //private Anmeldescreen anmeldeScreen2= new Anmeldescreen();
    private AuswahlScreen auswahlScreen= new AuswahlScreen();
    private SpielScreen spielScreen=new SpielScreen();
    private Endscreen endScreen = new Endscreen();





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
        configSpielScreenButton();
        panels.revalidate();

        panels.add(endScreen.getSeite1(), "Endscreen");
        configEndScreenButton();
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

                        if (spieler.getPasswd().equals(mySpieler.getPasswd()) && aktuelles_Spiel.getSpieler1() == null) {

                            aktuelles_Spiel.setSpieler1(mySpieler);
                            aktuelles_Spiel.getSpieler1().setFarbe(1);
                            aktuelles_Spiel.setAktuellerSpieler(aktuelles_Spiel.getSpieler1());

                            System.out.print("Spieler 1" + aktuelles_Spiel.getSpieler1().toString());
                            auswahlScreen.getInfo_spieler().setText("Angemeldet als " + aktuelles_Spiel.getSpieler1().getName() + " dein Score " + aktuelles_Spiel.getSpieler1().getHighscore());

                            cl.next(panels); // Wechsel auf das nachste Panel                            // spieler1 wird gesetzt als angemeldet

                            anmeldeScreen.getAusgabe().setForeground(Color.green);
                            //ausgabe.setText(("Anmeldung Erfolgreich"));
                            anmeldeScreen.getPasswortfeld().setText("");
                            anmeldeScreen.getSpielernamefeld().setText("");
                            anmeldeScreen.getAusgabe().setText((""));
                            anmeldeScreen.getAusgabe().setForeground(Color.red);


                        } else if (spieler.getPasswd().equals(mySpieler.getPasswd()) && aktuelles_Spiel.getSpieler2() == null && !aktuelles_Spiel.getSpieler1().equals(mySpieler)) {
                            aktuelles_Spiel.setSpieler2(mySpieler);
                            aktuelles_Spiel.getSpieler2().setFarbe(2);
                            aktuelles_Spiel.setAktuellerSpieler(aktuelles_Spiel.getSpieler1());


                            spielScreen.setTextInfo(aktuelles_Spiel.getSpieler1(), aktuelles_Spiel.getSpieler2());

                            cl.show(panels, "Spielscreen"); // Wechsel auf das nachste Panel                            // spieler2 wird gesetzt als angemeldet
                            System.out.print("Spieler 1" + aktuelles_Spiel.getSpieler1().toString());
                            System.out.print("Spieler 2" + aktuelles_Spiel.getSpieler2().toString());

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


        anmeldeScreen.registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                SpielerDAO spielerDAO = SpielerDAOFactory.createSpielerDAO();
                if (ae.getSource() == anmeldeScreen.registrierenButton) {

                    Spieler spieler = new Spieler(anmeldeScreen.spielernamefeld.getText(), anmeldeScreen.passwortfeld.getText());

                    System.out.println(spieler.toString());


                    if (spielerDAO.proofByName(spieler.getName()) == false) {
                        spielerDAO.add(spieler);
                        System.out.println("Neuer Spieler: " + spieler.toString());
                        anmeldeScreen.ausgabe.setForeground(Color.green);
                        anmeldeScreen.ausgabe.setText(("Sie wurden als neuer Spieler regestriert"));
                    } else {


                        anmeldeScreen.ausgabe.setForeground(Color.red);
                        anmeldeScreen.ausgabe.setText(("Dieser Name ist schon vergeben"));

                    }
                }
            }
        });


}
    private void configAuswahlScreenButton() {


        auswahlScreen.getPvcButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {



                aktuelles_Spiel.setSpieler2(aktuelles_Spiel.getKI());
                aktuelles_Spiel.getSpieler2().setFarbe(2);
                aktuelles_Spiel.setAktuellerSpieler(aktuelles_Spiel.getSpieler1());
                panels.updateUI();

                spielScreen.setTextInfo(aktuelles_Spiel.getSpieler1(),aktuelles_Spiel.getSpieler2());

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
    private void configSpielScreenButton() {

        // Action lister reagieren
        // TOdo Einfügen der action listener für die Einfurbuttons
        spielScreen.getReplayButton().addActionListener(new ActionListener() {          // Methode, um Spielwiederholung zu starten --> funktioniert noch nicht
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panels, "Spielscreen");
                aktuelles_Spiel.replayMatch();
                changeSpieler();
                spielfeldAktualisieren();

            }
        });


        for(int i=0;i<7;i++) {

            final int finalI = i;
            spielScreen.getWurfButton(finalI).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    //System.out.println(aktuelles_Spiel.getSpieler1().toString());
                    //System.out.println(aktuelles_Spiel.getSpieler2().toString());
                    // System.out.println(aktuelles_Spiel.getSpieler1() == aktuelles_Spiel.getAktuellerSpieler());

                        if (aktuelles_Spiel.getAktuellesSpielfeld().pruefe_Steinsetzen(finalI)) {
                            if (aktuelles_Spiel.getAktuellesSpielfeld().pruefe_sieg(aktuelles_Spiel.getAktuellerSpieler().getFarbe())[finalI]) {
                                aktuelles_Spiel.setSieg(true);
                                aktuelles_Spiel.setSiegFarbe(aktuelles_Spiel.getAktuellerSpieler().getFarbe());
                            }

                            aktuelles_Spiel.getAktuellesSpielfeld().setzte_Stein(finalI, aktuelles_Spiel.getAktuellerSpieler().getFarbe());

                            spielfeldAktualisieren();

                            if (!aktuelles_Spiel.getSieg()) {
                                changeSpieler();
                                if (aktuelles_Spiel.getAktuellerSpieler() == aktuelles_Spiel.getKI()) {

                                    int finalI = aktuelles_Spiel.getAktuellesSpielfeld().entscheide_zug(aktuelles_Spiel.getAktuellerSpieler().getFarbe(), aktuelles_Spiel.getIntelligenz_der_KI());

                                    if (aktuelles_Spiel.getAktuellesSpielfeld().pruefe_sieg(aktuelles_Spiel.getAktuellerSpieler().getFarbe())[finalI]) {
                                        aktuelles_Spiel.setSieg(true);
                                        aktuelles_Spiel.setSiegFarbe(aktuelles_Spiel.getAktuellerSpieler().getFarbe());
                                    }

                                    aktuelles_Spiel.getAktuellesSpielfeld().setzte_Stein(finalI, aktuelles_Spiel.getAktuellerSpieler().getFarbe());

                                    changeSpieler();
                                }

                                spielfeldAktualisieren();
                            }
                        } else {
                            spielScreen.getTlabel().setText("Stein setzen nicht möglich \n " +
                                    "Bitte nochmal                                 ");
                        }



                }
            });

        }




        }

    private void configEndScreenButton() {
        endScreen.getNochmalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                cl.show(panels, "Spielscreen");
            }
        });

        endScreen.getModusButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aktuelles_Spiel.setSpieler1(null);
                cl.show(panels, "Spielauswahl");
            }
        });

        endScreen.getEndeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }


private void spielfeldAktualisieren(){

    for (int i = 0; i <= 6; i++){
        for(int j = 5;  j >= 0; j--){
          if(aktuelles_Spiel.getAktuellesSpielfeld().getbrett(i,j)!=0)
           {
               spielScreen.setStein(i,j,aktuelles_Spiel.getAktuellesSpielfeld().getbrett(i,j));
               if(j==0)  {spielScreen.sperreButton(i);} else {spielScreen.aktiviereButton(i);}    // falls letzter Stein eingesetzt wird Button gesperrt
           }
        }
    }

    if(aktuelles_Spiel.getSieg()){
        spielScreen.markiereAktuellerSpieler(aktuelles_Spiel.getSiegfarbe());
        spielScreen.getTlabel().setText(aktuelles_Spiel.getSiegername() + " is Winner");
        spielScreen.sperreButtons();
        //spielScreen.aktiviereSpielwiederholungsButton();
        //try {
        //    Thread.sleep(2000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //cl.show(panels, "Endscreen");
        //    aktuelles_Spiel.replayMatch();
        //    changeSpieler();

        for (int i = 0; i <= 6; i++){           // Schleife, um siegreiche Steinkombination(en) zu markieren
            for(int j = 5;  j >= 0; j--){
                // Falls aktuelle Position gleich der Siegerfarbe und pruefe_Sieg fuer die Siegfarbe auch wahr ist, dann gehoert Stein zu einer Siegkombination
                if((aktuelles_Spiel.getAktuellesSpielfeld().getbrett(i,j)==aktuelles_Spiel.getSiegfarbe()) && (aktuelles_Spiel.getAktuellesSpielfeld().pruefe_sieg(aktuelles_Spiel.getSiegfarbe(),i,j))) {
                    spielScreen.setSteinSieg(i, j, aktuelles_Spiel.getSiegfarbe());
                }
            }
        }
    }


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


    public Spiel getAktuelles_Spiel() {
        return aktuelles_Spiel;
    }

    public void setAktuelles_Spiel(Spiel aktuelles_Spiel) {
        this.aktuelles_Spiel = aktuelles_Spiel;
    }

    public  void changeSpieler() {
        // if (spieler1.equals(aktuellerSpieler)){aktuellerSpieler=spieler2;}
        // if (spieler2.equals(aktuellerSpieler)){aktuellerSpieler=spieler1;}

        if (aktuelles_Spiel.getSpieler1()== aktuelles_Spiel.getAktuellerSpieler()){aktuelles_Spiel.setAktuellerSpieler(aktuelles_Spiel.getSpieler2());}
       else {aktuelles_Spiel.setAktuellerSpieler(aktuelles_Spiel.getSpieler1());}
        spielScreen.markiereAktuellerSpieler(aktuelles_Spiel.getAktuellerSpieler().getFarbe());


    }
}


