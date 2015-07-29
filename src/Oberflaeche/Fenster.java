package Oberflaeche;

/**
 * Created by Thomas on 29.07.2015.
 */


        import javax.swing.*;
        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import java.awt.*;


public class Fenster extends JFrame{


    public static void main( String[] args )
    {
        //Erzeugen des Fensters mit Titel 4gewinnt
        JFrame fenster = new JFrame( "Vier Gewinnt" );
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setSize(900, 600);
        fenster.setVisible(true);
        fenster.setResizable(false);

        fenster.setLayout( new BorderLayout(10, 10) );
        fenster.add(new JButton("oben"), BorderLayout.PAGE_START);
        fenster.add(new JButton("rechts"), BorderLayout.LINE_END);
        fenster.add(new JButton("unten"), BorderLayout.PAGE_END);
        fenster.add(new JButton("links"), BorderLayout.LINE_START);
        fenster.add( new JButton("mitte"), BorderLayout.CENTER );



        //Erzeugt Titel in der Mitte des oberen Fensters

        JLabel titel = new JLabel( "Vier gewinnt");
        titel.setForeground(Color.BLUE);
        titel.setFont(new Font("Serif", Font.BOLD, 30));



    }
}


