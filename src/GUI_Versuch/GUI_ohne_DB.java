/**
 * Created by ${Thomas} on ${27.10.2015}.
 */

package GUI_Versuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public final class GUI_ohne_DB extends JPanel implements ActionListener {

    //final static boolean shouldFill = true;
    //final static boolean shouldWeightX = true;
    //final static boolean RIGHT_TO_LEFT = false;

    private JPanel panels;

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

        panels = new JPanel(new CardLayout());
        panels.add(anmeldeScreen, "Anmeldescreen");
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
        titel.setFont(new Font("Arial",Font.BOLD, 25));
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 35, 25, 25);
        anmeldeScreen.add(titel,c);


        //Spielername Label
        JLabel spielername = new JLabel("Spielername");
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(spielername, c);

        //Spielername Textfeld
        JTextField spielernamefeld = new JTextField();
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(spielernamefeld, c);

        //Passwort Label
        JLabel passwort = new JLabel("Passwort");
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(passwort, c);

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
        anmeldeButton.setActionCommand("anmelden");
        anmeldeButton.addActionListener(this);


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
        registrierenButton.setActionCommand("registrieren");
        registrierenButton.addActionListener(this);


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
        c.insets = new Insets(10, 10, 0, 0);
        auswahlScreen.add(auswahl, c);

        // Player vs. Computer -Button
        JButton pvcButton = new JButton("Player vs. Computer");
        auswahlScreen.add(pvcButton, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 0);
        auswahlScreen.add(pvcButton, c);
        pvcButton.setActionCommand("PvC");
        pvcButton.addActionListener(this);

        return auswahlScreen;
    }


    //Spielscreen
    private JPanel createSpielScreen() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel spielScreen = new JPanel(new GridBagLayout());


        //Spielername Label
        JLabel spielfeld = new JLabel("Spielfeld");
        c.weightx = 0.0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 0);
        spielScreen.add(spielfeld, c);
        return spielScreen;
    }



    public void actionPerformed(ActionEvent e) {
        CardLayout allpanels = (CardLayout) (panels.getLayout());

        switch (e.getActionCommand()) {
            case "anmelden":
                allpanels.show(panels, "Spielauswahl");
                break;

            case "registrieren":
                allpanels.show(panels, "Registrieren");
                break;

            case "PvC":
                allpanels.show(panels, "Spielscreen");
                break;
        }
    }







    private static void createGUI() {

        JFrame frame = new JFrame("Vier Gewinnt");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //Zentrieren des Bildschirms
        frame.setTitle("Vier Gewinnt");

        GUI_ohne_DB contentPane = new GUI_ohne_DB();
        contentPane.addComponentToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(720, 480));

    }

    public static void main(String[] args) {
        createGUI();
    }
}