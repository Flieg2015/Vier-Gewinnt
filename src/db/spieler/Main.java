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

        // add Spieler
        Spieler newSpieler = new Spieler("susi", "USA",321);
        spielerDAO.add(newSpieler);
        System.out.println("Neuer Spieler: " + newSpieler.toString());

        // update Spieler
        newSpieler.setPasswd("YourCity");
        newSpieler.setHighscore(789);
        spielerDAO.update(newSpieler);
        System.out.println("veränderter Spieler: " + newSpieler.toString());

        // delete Spieler
        spielerDAO.delete(newSpieler);
        System.out.println("gelöschter Spieler: " + newSpieler.toString());

        ((SpielerDAOJDBCImpl) spielerDAO).close();
    }
}

