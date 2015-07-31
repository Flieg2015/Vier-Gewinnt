package GUI;

/**
 * Created by Thomas on 30.07.2015.
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Masterscreen extends Screen {



  public Anmeldescreen anmeldescreen;
    public Auswahlscreen auswahlscreen;

     JFrame frame = new JFrame("Masterscreen");

    public Masterscreen(){

        JFrame frame = new JFrame("Masterscreen");


    }

  public void setAnmeldescreen(){

this.anmeldescreen=new Anmeldescreen();

  }

    public void setInhalt(Screen sc){

        frame.setContentPane(sc.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



    public static void main(String[] args) {
        //JFrame frame = new JFrame("Master");
        Masterscreen master =new Masterscreen();
        master.setAnmeldescreen();
        Anmeldescreen j=new Anmeldescreen();
        master.setInhalt(j);

         }


}
