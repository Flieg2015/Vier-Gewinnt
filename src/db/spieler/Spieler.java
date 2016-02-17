package db.spieler;

/**
 * Created by Cornelia on 29.07.2015.
 */



import db.spieler.Spieler;
import db.spieler.SpielerDAO;
import db.spieler.SpielerDAOFactory;


public class Spieler {

    private String name;
    private String passwd;
    private int highscore;
    private int aktuelle_punkte;
    private int farbe=1;

    public Spieler (String name, String passwd, int highscore){     /** Standardkonstruktor zum Erzeugen eines Spielers  **/
        aktuelle_punkte=0;
        this.name=name;
        this.passwd=passwd;
        this.highscore=highscore;
    }
    public Spieler (String name, String passwd){     /** Standardkonstruktor zum Erzeugen eines Spielers  ohne Highsorw **/
        aktuelle_punkte=0;
        this.name=name;
        this.passwd=passwd;

            }


    public Spieler (String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getAktuelle_punkte() {
        return aktuelle_punkte;
    }

    public void setAktuelle_punkte(int aktuelle_punkte) {
        this.aktuelle_punkte = aktuelle_punkte;
    }

    public String toString() { return this.getName() + ", " + this.getPasswd() + ": " + this.getHighscore()+ " Farbe "+this.getFarbe();}

    public int getFarbe() {
        return farbe;
    }

    public int getKILevel(){
        if(highscore<51) return 1;
        if(highscore>50 &&  highscore<101) return 2;
        if(highscore>100 && highscore<151) return 3;
        if(highscore>200) return 4;
else return 4;
    }

    public void updateHighscore(int ausgang, Spieler gegner){ // 0 für verloren 1 für Sieg 2 für unentschieden

        if(gegner.getName().equals("Computer") ) {

            if (highscore < 51 && ausgang == 1) highscore = highscore + 5;
            if (highscore > 50 && ausgang == 1 && highscore < 101) highscore = highscore + 10;
            if (highscore > 100 && ausgang == 1 && highscore < 151) highscore = highscore + 15;
            if (highscore > 200 && ausgang == 1) highscore = highscore + 20;

            if (highscore < 51 && ausgang == 2) highscore = highscore + 0;
            if (highscore > 50 && ausgang == 2 && highscore < 101) highscore = highscore + 5;
            if (highscore > 100 && ausgang == 2 && highscore < 151) highscore = highscore + 10;
            if (highscore > 200 && ausgang == 2) highscore = highscore + 15;

            if (highscore < 51 && ausgang == 0) highscore = highscore - 2;
            if (highscore > 50 && ausgang == 0 && highscore < 101) highscore = highscore - 3;
            if (highscore > 100 && ausgang == 0 && highscore < 151) highscore = highscore - 4;
            if (highscore > 200 && ausgang == 0) highscore = highscore - 5;
        }
        else if (!gegner.getName().equals("Computer") && ausgang==1) {

           highscore=highscore+5;


        }

        if(highscore<0) highscore=0;




    }

    public void setFarbe(int farbe) {
        this.farbe = farbe;
    }  /** Gibt die kompletten


                                                                                                            Daten eines Spielers, die in
                                                                                                            Datenbank hinterlegt sind, an**/
}
