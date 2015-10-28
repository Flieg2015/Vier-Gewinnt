/**
 * Created by Thomas on 27.10.2015.
 */

package GUI_Versuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public final class GUI2 extends JPanel implements ActionListener {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    JPanel panels;

    public void addComponentToPane(Container pane) {


        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.fill = GridBagConstraints.BOTH;

        createPanels();

        pane.add(panels, c);
    }

    private void createPanels() {
        JPanel anmeldeScreen = createAnmeldeScreen();

        panels = new JPanel(new CardLayout());
        panels.add(anmeldeScreen, "Anmeldescreen");
        panels.add(new JLabel("Spielauswahl"), "Spielauswahl");
        panels.add(new JLabel("Registrieren"), "Registrieren");
    }

    private JPanel createAnmeldeScreen() {
        GridBagConstraints c = new GridBagConstraints();
        //c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;

        JPanel anmeldeScreen = new JPanel(new GridBagLayout());

        //Spielername Label
        JLabel spielername = new JLabel("Spielername");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.weighty = 0.1;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        anmeldeScreen.add(spielername, c);

        //Spielername Textfeld
        JTextField spielernamefeld = new JTextField();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0.6;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 5;
        c.ipadx = 100;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(spielernamefeld, c);

        //Passwort Label
        JLabel passwort = new JLabel("Passwort");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.weighty = 0.1;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(passwort, c);

        //Passwort Textfeld
        JTextField passwortfeld = new JTextField();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.weighty = 0.6;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 5;
        c.ipadx = 100;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(passwortfeld, c);



        // Anmelden-Button
        JButton anmeldeButton = new JButton("Anmelden");
        anmeldeScreen.add(anmeldeButton, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(anmeldeButton, c);
        anmeldeButton.setActionCommand("anmelden");
        anmeldeButton.addActionListener(this);


        // Registrieren-Button
        JButton registrierenButton = new JButton("Registrieren");
        anmeldeScreen.add(registrierenButton, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 0);
        anmeldeScreen.add(registrierenButton, c);
        registrierenButton.setActionCommand("registrieren");
        registrierenButton.addActionListener(this);


        return anmeldeScreen;
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
        }
    }

    private static void createGUI() {

        JFrame frame = new JFrame("Vier Gewinnt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //Zentrieren des Bildschirms
        frame.setTitle("Vier Gewinnt");

        GUI2 contentPane = new GUI2();
        contentPane.addComponentToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(640, 320));

    }

    public static void main(String[] args) {
        createGUI();
    }
}