package logik;
//package db.spieler;

/**
 * Created by Cornelia on 29.07.2015.
 */
public class Spiel {

    private db.spieler.Spieler spieler1;
    private db.spieler.Spieler spieler2;
    private db.spieler.Spieler aktuellerSpieler;

    private static int anzahl_spielzuege=0;


    public Spiel(db.spieler.Spieler spieler1, db.spieler.Spieler spieler2){                /** Spieler Mensch gegen Spieler Mensch  **/
        this.spieler1=spieler1;
        this.spieler2=spieler2;
        aktuellerSpieler=spieler1;
    }

    public Spiel (db.spieler.Spieler spieler1){                /** Spieler Mensch gegen Spieler Computer **/
        this.spieler1=spieler1;
        aktuellerSpieler=spieler1;
        //this.spieler2=KI_1.spielerK;                  /** TO DO **/
    }
}
