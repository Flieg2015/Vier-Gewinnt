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
    private db.spieler.Spieler KI=new Spieler("Computer");
          // Die Ki kann 4 Stufen haben von 1 bis 4


    private Spielfeld2 aktuellesSpielfeld=new Spielfeld2();

    private static int anzahl_spielzuege=0;

    private boolean sieg=false;
    private int siegfarbe = 0;
    private String siegername;
    private boolean spielende=false;



    public Spiel(db.spieler.Spieler spieler1, db.spieler.Spieler spieler2){                /** Spieler Mensch gegen Spieler Mensch  **/
        this.spieler1=spieler1;
        this.spieler2=spieler2;
//        if (Math.random()<0.5) { aktuellerSpieler=spieler1; } else {aktuellerSpieler=spieler2;}       // Zufall, wer anfaengt
        aktuellerSpieler=spieler1;

            }

    public Spiel (db.spieler.Spieler spieler1){                /** Spieler Mensch gegen Spieler Computer **/
        this.spieler1=spieler1;
//        if (Math.random()<0.5) { aktuellerSpieler=spieler1;} else {aktuellerSpieler=KI;}       // Zufall, wer anfaengt
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





    public boolean getSieg() {                              // hat jemand gesiegt?
        return sieg;
    }

    public void setSieg(boolean sieg) {                     // setzte, dass jemand gesiegt hat
        this.sieg = sieg;
    }
    public void setSiegFarbe(int farbe) {
        this.siegfarbe = farbe;
    }   // setzt die Siegerfarbe

    public int getSiegfarbe() { return this.siegfarbe;}     // gibt die Farbe des Siegers aus

    public String getSiegername() {         // gibt den Siegernamen als String aus
        switch(siegfarbe){
            case 0:
                siegername = "Niemand";
                break;
            case 1:
                siegername = spieler1.getName();
                break;
            case 2:
                siegername = spieler2.getName();
        }
        return siegername;
    }

    public Spieler getSieger() {         // gibt den Siegernamen als String aus
        switch(siegfarbe){

           case 1:
               return spieler1;

            case 2:
                return spieler2;
        }
        return spieler1;
    }


    public Spieler getVerlierer() {         // gibt den Siegernamen als String aus
        switch(siegfarbe){

            case 2:
                return spieler1;

            case 1:
                return spieler2;
        }
        return spieler1;
    }


    public Spielfeld2 getAktuellesSpielfeld() {
        return aktuellesSpielfeld;
    }

    public void setAktuellesSpielfeld(Spielfeld2 aktuellesSpielfeld) {
        this.aktuellesSpielfeld = aktuellesSpielfeld;
    }

    public Spieler getKI() {
        return KI;
    }

    public void replayMatch() {                 // Methode zur Spielwiederholung --> funktioniert noch nicht
        anzahl_spielzuege=0;
        aktuellesSpielfeld.loesche_brett();

    }

    public boolean isSpielende() {
        return spielende;
    }

    public void setSpielende(boolean spielende) {
        this.spielende = spielende;
    }
}

