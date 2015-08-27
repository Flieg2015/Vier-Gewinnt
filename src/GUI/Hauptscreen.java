package GUI;

/**
 * Created by tim on 26.08.15.
 */

import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hauptscreen extends JFrame  implements ActionListener  {

    JPanel cards; //a panel that uses CardLayout

    private JButton anmeldenButton;
    private JButton registrierenButton;

   public Hauptscreen(){


   }

    public void addComponentToPane(Container pane) {


        JPanel anmeldescreen = new Anmeldung().panel1;
        JPanel startscreen = new Start().panel1;

        //Create the panel that contains the "cards".

        cards = new JPanel(new CardLayout());
        cards.add(anmeldescreen, "Anmeldebildschirm");
        cards.add(startscreen, "Startbildschirm");


        pane.add(cards, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

         anmeldenButton = new JButton("Anmelden");
         registrierenButton = new JButton("Registrieren");


        buttonPanel.add(anmeldenButton);
        buttonPanel.add(registrierenButton);

        pane.add(buttonPanel, BorderLayout.SOUTH);

        anmeldenButton.addActionListener(this);
        registrierenButton.addActionListener(this);



    }

    public  void StateChanged(String evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, evt);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Vier Gewinnt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Hauptscreen demo = new Hauptscreen();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }






        public void actionPerformed(ActionEvent ae) {

            SpielerDAO spielerDAO = SpielerDAOFactory.createSpielerDAO();



            if (ae.getSource() == this.registrierenButton) {



                // TODO: place custom component creation code here


            }






        }











}



