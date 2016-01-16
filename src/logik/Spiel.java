package logik;
//package db.spieler;

import db.spieler.Spieler;

/**
 * Created by Cornelia on 29.07.2015.
 */
public class Spiel {

    private db.spieler.Spieler spieler1;
    private db.spieler.Spieler spieler2;
    private db.spieler.Spieler aktuellerSpieler=spieler1;
    private int Intelligenz_der_KI=1;             // Die Ki kann 4 Stufen haben von 1 bis 4
    private boolean Spielmode=true;// true Player VS Comuter false Player vs Player

    private Spielfeld2 aktuellesSpielfeld=new Spielfeld2();

    private static int anzahl_spielzuege=0;

    boolean sieg=false;



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

    public Spiel() {

    }


    public Spieler getSpieler1() {
        return spieler1;
    }

    public void setSpieler1(Spieler spieler1) {
        this.spieler1 = spieler1;

    }

    public Spieler getSpieler2() {
        return spieler2;
    }

    public void setSpieler2(Spieler spieler2) {
        this.spieler2 = spieler2;

    }

    public Spieler getAktuellerSpieler() {
        return aktuellerSpieler;
    }

    public void setAktuellerSpieler(Spieler aktuellerSpieler) {
        this.aktuellerSpieler = aktuellerSpieler;
    }

    public static int getAnzahl_spielzuege() {
        return anzahl_spielzuege;
    }

    public static void setAnzahl_spielzuege(int anzahl_spielzuege) {
        Spiel.anzahl_spielzuege = anzahl_spielzuege;
    }
    public static void erhoehe_spielzuege() {
        Spiel.anzahl_spielzuege++;
    }



    public int getIntelligenz_der_KI() {
        return Intelligenz_der_KI;
    }

    public void setIntelligenz_der_KI(int intelligenz_der_KI) {
        Intelligenz_der_KI = intelligenz_der_KI;
    }

    public boolean isSieg() {
        return sieg;
    }

    public void setSieg(boolean sieg) {
        this.sieg = sieg;
    }

    public boolean isSpielmode() {
        return Spielmode;
    }

    public void setSpielmode(boolean sielmode) {
        Spielmode = sielmode;
    }

    public Spielfeld2 getAktuellesSpielfeld() {
        return aktuellesSpielfeld;
    }

    public void setAktuellesSpielfeld(Spielfeld2 aktuellesSpielfeld) {
        this.aktuellesSpielfeld = aktuellesSpielfeld;
    }
}
