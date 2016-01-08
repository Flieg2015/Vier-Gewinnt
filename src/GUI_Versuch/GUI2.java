/**
 * Created by Thomas on 27.10.2015.
 */

package GUI_Versuch;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logik.*;
import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;




public final class GUI2 extends JPanel {

    //final static boolean shouldFill = true;
    //final static boolean shouldWeightX = true;
    //final static boolean RIGHT_TO_LEFT = false;

    private JPanel panels;
    private JLabel ausgabe;
    private CardLayout cl;
    private Bilder meinespielsteine = new Bilder();


    Spiel aktuelles_Spiel=new Spiel(null);


    public void addComponentToPane(Container pane) {


        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        createPanels();
        pane.add(panels, c);
    }

    private void createPanels() {
        JPanel anmeldeScreen = createAnmeldeScreen();
        JPanel auswahlScreen = createAuswahlScreen();
        JPanel spielScreen = createSpielScreen();
        cl = new CardLayout();
        panels = new JPanel(cl);
        panels.add(anmeldeScreen, "Anmeldescreen");
        panels.add(anmeldeScreen, "Anmeldescreen2");
        panels.add(auswahlScreen, "Spielauswahl");
        panels.add(spielScreen, "Spielscreen");
        panels.add(new JLabel("Registrieren"), "Registrieren");
    }

    //Erstellen des Anmeldescreens
    private JPanel createAnmeldeScreen() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel anmeldeScreen = new JPanel(new GridBagLayout());

        //Titel Label
        JLabel titel = new JLabel("Vier gewinnt");
        titel.setFont(new Font("Arial", Font.BOLD, 25));
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 35, 25, 25);
        anmeldeScreen.add(titel, c);

        //Titel Ausgabe
        JLabel ausgabe = new JLabel("");
        ausgabe.setFont(new Font("Arial", Font.BOLD, 21));
        ausgabe.setForeground(Color.red);
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 35, 25, 25);
        anmeldeScreen.add(ausgabe, c);

        //Spielername Label
        JLabel spielername = new JLabel("Spielername");
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(spielername, c);

        //Passwort Label
        JLabel passwort = new JLabel("Passwort");
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(passwort, c);

        //Spielername Textfeld
        JTextField spielernamefeld = new JTextField();
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(spielernamefeld, c);


        //Passwort Textfeld
        JTextField passwortfeld = new JPasswordField();
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(passwortfeld, c);

        // Anmelden-Button
        JButton anmeldeButton = new JButton("Anmelden");
        anmeldeScreen.add(anmeldeButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(anmeldeButton, c);


        anmeldeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {


                //cl.next(panels); // Test auskommentieren um Funktion wieder herzustellen

                SpielerDAO spielerDAO = SpielerDAOFactory.createSpielerDAO();
                if (ae.getSource() == anmeldeButton) {

                    Spieler spieler = new Spieler(spielernamefeld.getText(), passwortfeld.getText());

                    System.out.println(spieler.toString());


                    if (spielerDAO.proofByName(spieler.getName()) == false) {
                        ausgabe.setText(("Benutzername falsch"));
                    } else {

                        Spieler mySpieler = spielerDAO.findByName(spieler.getName()); // mySpieler ist der Der richtige Spieler aus der DB

                        //System.out.println(mySpieler.toString());

                        if (spieler.getPasswd().equals(mySpieler.getPasswd()) && aktuelles_Spiel.getSpieler1()==null ) {

                            aktuelles_Spiel.setSpieler1(mySpieler);

                            System.out.print("Spieler 1"+aktuelles_Spiel.getSpieler1().toString());
                            cl.next(panels); // Wechsel auf das nachste Panel                            // spieler1 wird gesetzt als angemeldet

                            ausgabe.setForeground(Color.green);
                            //ausgabe.setText(("Anmeldung Erfolgreich"));
                            passwortfeld.setText("");
                            spielernamefeld.setText("");
                            ausgabe.setText((""));
                            ausgabe.setForeground(Color.red);


                        } else if (spieler.getPasswd().equals(mySpieler.getPasswd()) && aktuelles_Spiel.getSpieler2() == null && !aktuelles_Spiel.getSpieler1().equals(mySpieler)) {
                            aktuelles_Spiel.setSpieler2(mySpieler);
                            cl.show(panels, "Spielscreen"); // Wechsel auf das nachste Panel                            // spieler2 wird gesetzt als angemeldet
                            System.out.print("Spieler 1"+aktuelles_Spiel.getSpieler1().toString());
                            System.out.print("Spieler 2"+aktuelles_Spiel.getSpieler2().toString());

                            passwortfeld.setText("");
                            spielernamefeld.setText("");
                            ausgabe.setText((""));
                            ausgabe.setForeground(Color.red);


                        } else {
                            ausgabe.setText(("Passwd falsch"));
                        }
                    }

                }


            }


        });


        // Registrieren-Button
        JButton registrierenButton = new JButton("Registrieren");
        anmeldeScreen.add(registrierenButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(registrierenButton, c);


        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                SpielerDAO spielerDAO = SpielerDAOFactory.createSpielerDAO();
                if (ae.getSource() == registrierenButton) {

                    Spieler spieler = new Spieler(spielernamefeld.getText(), passwortfeld.getText());

                    System.out.println(spieler.toString());


                    if (spielerDAO.proofByName(spieler.getName()) == false) {
                        spielerDAO.add(spieler);
                        System.out.println("Neuer Spieler: " + spieler.toString());
                        ausgabe.setForeground(Color.green);
                        ausgabe.setText(("Sie wurden als neuer Spieler regestriert"));
                    } else {


                        ausgabe.setForeground(Color.red);
                        ausgabe.setText(("Dieser Name ist schon vergeben"));

                    }
                }
            }
        });


        return anmeldeScreen;
    }

    //Auswahlscreen
    private JPanel createAuswahlScreen() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel auswahlScreen = new JPanel(new GridBagLayout());


        //Spielername Label
        JLabel auswahl = new JLabel("Auswahl");
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0);
        auswahlScreen.add(auswahl, c);


        // Infofeld 1 über angemeldeten Spieler ToDo Was soll hier rein?
        JLabel info_spieler = new JLabel("Info-Spieler?!?");
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 0, 0);
        auswahlScreen.add(info_spieler, c);




        // Player vs. Computer -Button
        JButton pvcButton = new JButton("Player vs. Computer");
        auswahlScreen.add(pvcButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 0, 0);
        auswahlScreen.add(pvcButton, c);

        pvcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //aktuelles_Spiel.setSpieler1(null);
                cl.show(panels, "Spielscreen");
            }
        });


        JButton backButton = new JButton("Abmelden");
        auswahlScreen.add(backButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 0, 0);
        auswahlScreen.add(backButton, c);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aktuelles_Spiel.setSpieler1(null);

                cl.first(panels);
            }
        });

        JButton pvpButton = new JButton("Player vs. Player");
        auswahlScreen.add(pvpButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 0, 0);
        auswahlScreen.add(pvpButton, c);

        pvpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // setSpieler1(null);
                cl.show(panels, "Anmeldescreen2");
            }
        });


        return auswahlScreen;
    }


    //Spielscreen
    private JPanel createSpielScreen() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel Spielscreen = new JPanel(new GridBagLayout());


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
                JLabel stein = new JLabel("w");
                c.weightx = 0.0;
                c.gridwidth = 0;
                c.gridx = i;
                c.gridy = j;
                c.insets = new Insets(10, 10, 0, 0);
                Spielscreen.add(stein, c) ;
            }
        }

        // Einwurf-Button
        i = 0;
        for(i = 0; i <=6; i++) {
            JButton wurfButton = new JButton("Einwerfen");
            Spielscreen.add(wurfButton, c);
            //c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.0;
            c.gridwidth = 1;
            c.gridx = i;
            c.gridy = 8;
            c.insets = new Insets(10, 10, 0, 0);
            Spielscreen.add(wurfButton, c);
        }

        return Spielscreen;
    }



    private static void createGUI() {



        JFrame frame = new JFrame("Vier Gewinnt");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //Zentrieren des Bildschirms
        frame.setTitle("Vier Gewinnt");

        GUI2 contentPane = new GUI2();
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


