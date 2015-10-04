package db.spieler;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        SpielerDAO spielerDAO = SpielerDAOFactory.createSpielerDAO();

        // getAllSpieler
        ArrayList<Spieler> myList = spielerDAO.getAllSpieler();
        for (Spieler s : myList)
            System.out.println(s.toString());

        // findByName (name = "tim");
        Spieler mySpieler = spielerDAO.findByName("tim");
        System.out.println(mySpieler.toString());

        // findByName (name = "tim");
        boolean mySpieler1 = spielerDAO.proofByName("tim");
        System.out.println(mySpieler1);


        // add Spieler
        Spieler newSpieler = new Spieler("Thomas", "USA",321);
        spielerDAO.add(newSpieler);
        System.out.println("Neuer Spieler: " + newSpieler.toString());

        // update Spieler
        newSpieler.setPasswd("YourCity");
        newSpieler.setHighscore(789);
        spielerDAO.update(newSpieler);
        System.out.println("veräenderter Spieler: " + newSpieler.toString());

        // delete Spieler
        //spielerDAO.delete(newSpieler);
        //System.out.println("geloeschter Spieler: " + newSpieler.toString());



        //gib Highscoreliste aus
        ArrayList<String> bestenliste= new ArrayList<String>();
         bestenliste= spielerDAO.getBestenliste();
       int i=0;
        int platz=1;
        while(bestenliste.size()>i) {
            //System.out.println("geloeschter Spieler: " );
            System.out.println("Nummer " + platz++ +" "+bestenliste.get(i)+" Punkte "+bestenliste.get(i+1));
            i=i+2;
                   }

        ((SpielerDAOJDBCImpl) spielerDAO).close();
    }
}

