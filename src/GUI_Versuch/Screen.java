/**
 * Created by Thomas on 17.10.2015.
 */

package GUI_Versuch;

//Verwendete Programmbibliotheken
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen {
    JFrame guiFrame;
    CardLayout cards;
    JPanel cardPanel;


    public static void main(String[] args) {

        //Use the event dispatch thread for Swing components
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Screen();
            }
        });
    }

    public Screen()
    {
        guiFrame = new JFrame();

        //Einstellungen des Frames
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Schließen bei Klicken
        guiFrame.setTitle("Vier Gewinnt"); //Titel
        guiFrame.setSize(800, 600); //Größe setzen
        guiFrame.setLocationRelativeTo(null); //Zentrieren des Bildschirms
        guiFrame.setLayout(new BorderLayout()); //Boderlayout für den Frame

        //Borderlayout
        Border outline = BorderFactory.createLineBorder(Color.GRAY);
        JPanel titelPanel = new JPanel();
        titelPanel.setBorder(outline);

            //Titelschrift
            JLabel titel = new JLabel("Vier gewinnnt");
            titel.setSize(new Dimension(320, 64));
            titel.setVisible(true);

            //Hinzufügen der Elemente zum Titelscreen
            titelPanel.add(titel);


        //Card-Layout
        cards = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cards);
        cards.show(cardPanel, "Anmeldung");


        //Initialisieren Anmeldebildschirm (1. Card)
        JLabel anmeldescreen = new JLabel();
        anmeldescreen.setBackground(Color.LIGHT_GRAY);
        anmeldescreen.setLayout(new GridLayout(3, 1));

            //Label Spielername
            JLabel spielername = new JLabel("Spielername");
            spielername.setSize(new Dimension(320, 64));
            spielername.setVisible(true);

            //Textfeld Spielername
            JTextField spielernamefeld = new JTextField();
            spielernamefeld.setSize(new Dimension(320, 64));
            spielernamefeld.setVisible(true);

             //Label Passwort
             JLabel passwort = new JLabel("Passwort");
             spielername.setSize(new Dimension(320, 64));
             spielername.setVisible(true);

            //Textfeld Spielername
            JTextField passwortfeld = new JTextField();
            passwortfeld.setSize(new Dimension(320, 64));
            passwortfeld.setVisible(true);

            //Anmeldebutton --> zum Wechseln des Bildschirms
            JButton anmeldeButton = new JButton("Anmelden");
            anmeldeButton.setActionCommand("Anmelden");
            anmeldeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    cards.next(cardPanel);
                }
            });


            //Hinzufügen der Elemente zum Anmeldescreen
            anmeldescreen.add(spielername);
            anmeldescreen.add(spielernamefeld);
            anmeldescreen.add(passwort);
            anmeldescreen.add(passwortfeld);
            anmeldescreen.add(anmeldeButton);
            addButton(anmeldescreen, "Abbrechen");


        //Initialiserung Startbildschirm (2. Card)
        JPanel startscreen = new JPanel();
        startscreen.setBackground(Color.LIGHT_GRAY);
        addButton(startscreen, "Erfolgreich!");
       ;

        //Hinzufuegen der Cards zum Panel
        cardPanel.add(anmeldescreen, "Anmeldung");
        cardPanel.add(startscreen, "Start");

        //Hinzufügen der der Layoutelement zum Panel
        guiFrame.add(titelPanel,BorderLayout.NORTH);
        guiFrame.add(cardPanel,BorderLayout.CENTER);
        guiFrame.setVisible(true);
    }

    //Methode zum Hinzufügen der Buttons
    private void addButton(Container parent, String name)
    {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        parent.add(but);
    }
}


