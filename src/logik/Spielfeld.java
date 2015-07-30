package logik;
public class Spielfeld {


    int[][] brett;
    int spalte = 7;
    int zeile = 6;

    public Spielfeld() {         /**erstellt ein 7x6-Spielfeld**/
        brett = new int[spalte][zeile];
        for (int s = 0; s < spalte; s++) {
            for (int z = 0; z < zeile; z++) {
                brett[s][z] = 0;
            }


        }
    }

    public void ausgeben()      /**Gibt das Spielfeld aus. (zu Testzwecken) **/

    {

        for (int z = 0; z < zeile; z++) {
            for (int s = 0; s < spalte; s++) {
                System.out.print("|");
                System.out.print(brett[s][z]);
            }
            System.out.print("|");
            System.out.println();

        }
    }


    public boolean pruefe_Steinsetzen(int spalte)      /** Die Methode prüft,
                                                        ob am in der gewünschten Spalte noch einen Stein setzen kann.**/
    {

        if(brett[spalte][0]==0) return true;
        else return false;

    }

    public void setzte_Stein(int spalte, int wert)      /** Diese Methode setzt einen Stein in eine angegebene Spalte,
                                                            dabei wird zuerst überprüft, ob man die diese Spalte noch einen
                                                            Stein setzen kann. Ist das Setzen nicht möglich, so wird dies
                                                            ausgegeben.**/
    {

        if(pruefe_Steinsetzen(spalte))
        {
            int i = zeile - 1;
            while(brett[spalte][i]!=0)
            {
           i--;

        }
            brett[spalte][i]=wert;

            }
        else{
            System.out.println("Stein setzten nicht möglich");
        }


    }



    public boolean pruefe_sieg_waagrecht(int w, int x, int y) {         /** Diese Methode prüft, ob bei der Auswahl eines
                                                                            bestimmten Feldes, als bestimmter Spieler
                                                                            ein Sieg in waagrechter Richtung vorliegt.
                                                                            Es wird hierbei bisher nicht
                                                                            überprüft, ob dieses Feld überhaupt zum
                                                                            Setzen frei/möglich ist. Dabei wird nicht gesetzt.**/

        int anzahl=1;
        int schrittweite=x;

        while (schrittweite+1<spalte && brett[schrittweite+1][y]==w) {
            anzahl++;
            schrittweite++;
        }
        schrittweite=x;

        while (schrittweite-1>=0 && brett[schrittweite-1][y]==w) {
            anzahl++;
            schrittweite--;
        }

        if (anzahl>=4) return true;
        else return false;
    }



    public boolean pruefe_sieg_senkrecht(int w, int x, int y) {         /** Diese Methode prüft, ob bei der Auswahl eines
                                                                            bestimmten Feldes, als bestimmter Spieler
                                                                            ein Sieg in senkrechter Richtung vorliegt.
                                                                            Es wird hierbei bisher nicht
                                                                            überprüft, ob dieses Feld überhaupt zum
                                                                            Setzen frei/möglich ist. Dabei wird nicht gesetzt.**/

        int anzahl=1;
        int schrittweite=y;

        while (schrittweite+1<zeile && brett [x][schrittweite+1]==w ) {
            anzahl++;
            schrittweite++;
        }
        schrittweite=y;

        while (schrittweite-1>=0 && brett[x][schrittweite-1]==w) {
            anzahl++;
            schrittweite--;
        }

        if (anzahl>=4) return true;
        else return false;
    }

    public boolean pruefe_sieg_diagonal_nach_unten(int w, int x, int y) {   /** Diese Methode prüft, ob bei der Auswahl eines
                                                                                bestimmten Feldes, als bestimmter Spieler
                                                                                ein Sieg in diagonaler Richtung, von rechts oben nach
                                                                                links unten, vorliegt.
                                                                                Es wird hierbei bisher nicht
                                                                                überprüft, ob dieses Feld überhaupt zum
                                                                                Setzen frei/möglich ist. Dabei wird nicht gesetzt.**/

        int anzahl=1;
        int schrittweiteX=x;
        int schrittweiteY=y;

        while ((schrittweiteY+1<zeile || schrittweiteX+1<spalte) && brett [schrittweiteX+1][schrittweiteY+1]==w) {
            anzahl++;
            schrittweiteX++;
            schrittweiteY++;
        }
        schrittweiteX=x;
        schrittweiteY=y;

        while ((schrittweiteX-1>=0  || schrittweiteY-1>=0) &&  brett[schrittweiteX-1][schrittweiteY-1]==w) {
            anzahl++;
            schrittweiteX--;
            schrittweiteY--;
        }

        if (anzahl>=4) return true;
        else return false;
    }

    public boolean pruefe_sieg_diagonal_nach_oben(int w, int x, int y) {    /** Diese Methode prüft, ob bei der Auswahl eines
                                                                                bestimmten Feldes, als bestimmter Spieler
                                                                                ein Sieg in diagonaler Richtung, von rechts unten nach
                                                                                links oben, vorliegt.
                                                                                Es wird hierbei bisher nicht
                                                                                überprüft, ob dieses Feld überhaupt zum
                                                                                Setzen frei/möglich ist. Dabei wird nicht gesetzt.**/

        int anzahl=1;
        int schrittweiteX=x;
        int schrittweiteY=y;

        while ((schrittweiteY-1>=0 || schrittweiteX+1<spalte) && brett [schrittweiteX+1][schrittweiteY-1]==w) {
            anzahl++;
            schrittweiteX++;
            schrittweiteY--;
        }
        schrittweiteX=x;
        schrittweiteY=y;

        while ((schrittweiteX-1>=0  || schrittweiteY+1<zeile) && brett[schrittweiteX-1][schrittweiteY+1]==w) {
            anzahl++;
            schrittweiteX--;
            schrittweiteY++;
        }

        if (anzahl>=4) return true;
        else return false;
    }

    public boolean pruefe_sieg(int w, int x, int y) {           /** Diese Methode prüft, ob bei der Auswahl eines
                                                                    bestimmten Feldes, als bestimmter Spieler
                                                                    ein Sieg vorliegt. Dabei werden die Methoden
                                                                    pruefe_sieg_digaonal_nach_oben(), pruefe_sieg_
                                                                    diagonal_nach_unten(), pruefe_sieg_senkrecht() und
                                                                    pruefe_sieg_waagrecht() verwendet.
                                                                    Es wird hierbei bisher nicht
                                                                    überprüft, ob dieses Feld überhaupt zum
                                                                    Setzen frei/möglich ist. Dabei wird nicht gesetzt.**/

        return (pruefe_sieg_diagonal_nach_oben(w, x, y) || pruefe_sieg_diagonal_nach_unten(w, x, y) ||
                pruefe_sieg_senkrecht(w, x, y) || pruefe_sieg_waagrecht(w, x, y));

    }

}