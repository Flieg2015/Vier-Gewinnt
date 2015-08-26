package db.spieler;

/**
 * Created by Cornelia on 29.07.2015.
 */





public class Spieler {

    private String name;
    private String passwd;
    private int highscore;
    private int aktuelle_punkte;

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

    public String toString() { return this.getName() + ", " + this.getPasswd() + ": " + this.getHighscore();}  /** Gibt die kompletten
                                                                                                            Daten eines Spielers, die in
                                                                                                            Datenbank hinterlegt sind, an**/
}
