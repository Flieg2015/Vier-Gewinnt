package GUI_Versuch;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Thomas on 19.12.2015.
 */
public class Bilder extends JPanel {

    public BufferedImage weiss;
    public BufferedImage rot;
    public BufferedImage gelb;

    public Bilder(){
      setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        rot = load("/pics/rot.png");
        gelb = load("/pics/gelb.png");
        weiss = load("/pics/weiss.png");

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //Anpassen des Bildes an lokale Graphikeinstellung --> weniger Rechenlast
        GraphicsDevice gd = ge.getScreenDevices()[0]; //nimmt Einstellung des 1. Bildschirms
        GraphicsConfiguration gc = gd.getDefaultConfiguration(); //holt sich sich die Standardeinstellungen des ersten Bildschirms
        BufferedImage img = gc.createCompatibleImage(
                rot.getWidth(),
                rot.getHeight(),
                Transparency.TRANSLUCENT  //Transparente Umrandung wird angezeigt
                );
        BufferedImage img2 = gc.createCompatibleImage(
                gelb.getWidth(),
                gelb.getHeight(),
                Transparency.TRANSLUCENT  //Transparente Umrandung wird angezeigt
                 );
        BufferedImage img3 = gc.createCompatibleImage(
                weiss.getWidth(),
                weiss.getHeight(),
                Transparency.TRANSLUCENT  //Transparente Umrandung wird angezeigt
                 );

        Graphics2D r = img.createGraphics();
            r.drawImage(rot, 0, 0, null);
            r.dispose();
        Graphics2D g = img2.createGraphics();
            g.drawImage(gelb, 0, 0, null);
            g.dispose();
        Graphics2D w = img3.createGraphics();
            w.drawImage(weiss, 0, 0, null);
            w.dispose();
        }

    public void paint(Graphics gr){
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.BLUE);
        g.fill(g.getClipBounds());

        g.drawImage(rot, 12, 0, 100, 100, null); //Position x,y,Streckung x, Streckung y
        g.drawImage(gelb, 120, 0, 50, 50, null);
        g.drawImage(weiss, 250, 250, 75, 75, null);
    }

    public static BufferedImage load(String name) {
        try {
            BufferedImage img = ImageIO.read(
                Bilder.class.getResourceAsStream(name)
                );
            return img;
         }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //getter für farbe schreiben

        public static void main(String[] args){
            JFrame jf = new JFrame();


            jf.getContentPane().add(new Bilder());

            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.pack();
            jf.setVisible(true);

        }
}
