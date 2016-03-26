package logik;

public class Spielfeld2 {


    int[][] brett;
    int spalte = 7;
    int zeile = 6;

    public Spielfeld2() {         /**erstellt ein 7x6-Spielfeld**/
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
                System.out.print(" | ");
                System.out.print(brett[s][z]);
            }
            System.out.print(" |");
            System.out.println();

        }
    }

    public void loesche_brett () {           // Loescht den aktuellen Brettinhalt

        for (int s = 0; s < spalte; s++) {
            for (int z = 0; z < zeile; z++) {
                brett[s][z] = 0;
            }

            System.out.println("Spielbrett geloescht");
        }
    }

    public void setze_Zufallssteine (int Steinezahl, int Startspieler){      // setzt (Steinezahl) zufaellige Steine, beginnend mit (Startspieler)
        int ii;

        for (ii=0;ii<Steinezahl;ii++){
            setzte_Stein((int)(Math.random()*7), (ii+Startspieler-1)%2+1);      // Modulo "%"
        }
        System.out.println(Steinezahl + " Zufallssteine hinzugefuegt (Startspieler " + Integer.toString(Startspieler) + ")");
    }



    public boolean pruefe_Steinsetzen(int spalte)      /** Die Methode prueft,
     ob man in der gewuenschten Spalte noch einen Stein setzen kann.**/
    {

        return brett[spalte][0] == 0;

    }

    public void setzte_Stein(int spalte, int wert)      /** Diese Methode setzt einen Stein in eine angegebene Spalte,
     dabei wird zuerst ueberprueft, ob man die diese Spalte noch einen
     Stein setzen kann. Ist das Setzen nicht moeglich, so wird dies
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
            System.out.println("Stein setzen nicht moeglich");
        }


    }



    /*public boolean pruefe_sieg_waagrecht(int w, int x, int y) {         // Diese Methode prueft, ob bei der Auswahl eines bestimmten Feldes, als bestimmter Spieler ein Sieg in waagrechter Richtung vorliegt. Es wird hierbei bisher nicht ueberprueft, ob dieses Feld ueberhaupt zum Setzen frei /moeglich ist. Dabei wird nicht gesetzt.
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
    } */



   /* public boolean pruefe_sieg_senkrecht(int w, int x, int y) {         /** Diese Methode prueft, ob bei der Auswahl eines bestimmten Feldes, als bestimmter Spieler ein Sieg in senkrechter Richtung vorliegt. Es wird hierbei bisher nicht ueberprueft, ob dieses Feld ueberhaupt zum Setzen frei/moeglich ist. Dabei wird nicht gesetzt.
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
    }*/

 /*   public boolean pruefe_sieg_diagonal_nach_unten(int w, int x, int y) {   // Diese Methode prueft, ob bei der Auswahl eines bestimmten Feldes, als bestimmter Spieler ein Sieg in diagonaler Richtung, von rechts oben nach links unten, vorliegt. Es wird hierbei bisher nicht ueberprueft, ob dieses Feld ueberhaupt zum Setzen frei/moeglich ist. Dabei wird nicht gesetzt.
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
    }*/

  /*  public boolean pruefe_sieg_diagonal_nach_oben(int w, int x, int y) {    // Diese Methode prueft, ob bei der Auswahl eines bestimmten Feldes, als bestimmter Spieler ein Sieg in diagonaler Richtung, von rechts unten nach links oben, vorliegt. Es wird hierbei bisher nicht ueberprueft, ob dieses Feld ueberhaupt zum Setzen frei/moeglich ist. Dabei wird nicht gesetzt.
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
    } */

    public boolean pruefe_sieg_waagrecht (int w, int x, int y){
        boolean waag=false;
        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 1);
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        outer_loop:
        for(ii=0;ii<4;ii++){
            switch (ii){
                case 0: // erster Vierer
                    if (Zellwerte[0]*Zellwerte[1]*Zellwerte[2]==1) {waag=true; break outer_loop;}
                    break;
                case 1: // zweiter Vierer
                    if (Zellwerte[1]*Zellwerte[2]*Zellwerte[3]==1) {waag=true; break outer_loop;}
                    break;
                case 2: // dritter Vierer
                    if (Zellwerte[2]*Zellwerte[3]*Zellwerte[4]==1) {waag=true; break outer_loop;}
                    break;
                case 3: // vierter Vierer
                    if (Zellwerte[3]*Zellwerte[4]*Zellwerte[5]==1) {waag=true; break outer_loop;}
                    break;
            }
        }

        return waag;
    }

    public boolean pruefe_sieg_senkrecht (int w, int x, int y){
        boolean senk=false;
        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 2);  //case 2 ist der senkrechte Fall
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        outer_loop:
        for(ii=0;ii<4;ii++){
            switch (ii){
                case 0: // erster Vierer
                    if (Zellwerte[0]*Zellwerte[1]*Zellwerte[2]==1) {senk=true; break outer_loop;}
                    break;
                case 1: // zweiter Vierer
                    if (Zellwerte[1]*Zellwerte[2]*Zellwerte[3]==1) {senk=true; break outer_loop;}
                    break;
                case 2: // dritter Vierer
                    if (Zellwerte[2]*Zellwerte[3]*Zellwerte[4]==1) {senk=true; break outer_loop;}
                    break;
                case 3: // vierter Vierer
                    if (Zellwerte[3]*Zellwerte[4]*Zellwerte[5]==1) {senk=true; break outer_loop;}
                    break;
            }
        }

        return senk;
    }

    public boolean pruefe_sieg_diagonal_nach_oben (int w, int x, int y){           /** Diese Methode bewertet in waagrechter Richtung.**/

        boolean diag_oben=false;
        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 3);  //case 3 ist der diagonal_nach_rechts_oben Fall
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        outer_loop:
        for(ii=0;ii<4;ii++) {
            switch (ii) {
                case 0: // erster Vierer
                    if(Zellwerte[0] * Zellwerte[1] * Zellwerte[2]==1) {diag_oben=true; break outer_loop;}
                    break;
                case 1: // zweiter Vierer
                    if(Zellwerte[1] * Zellwerte[2] * Zellwerte[3]==1) {diag_oben=true; break outer_loop;}
                    break;
                case 2: // dritter Vierer
                    if(Zellwerte[2] * Zellwerte[3] * Zellwerte[4]==1) {diag_oben=true; break outer_loop;}
                    break;
                case 3: // vierter Vierer
                    if(Zellwerte[3] * Zellwerte[4] * Zellwerte[5]==1) {diag_oben=true; break outer_loop;}
                    break;
            }
        }

        return diag_oben;

    }

    public boolean pruefe_sieg_diagonal_nach_unten (int w, int x, int y){           /** Diese Methode bewertet in waagrechter Richtung.**/

        boolean diag_unten=false;


        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 4);  //case 4 ist der diagonal_nach_rechts_unten Fall
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        outer_loop:
        for(ii=0;ii<4;ii++) {
            switch (ii) {
                case 0: // erster Vierer
                    if (Zellwerte[0] * Zellwerte[1] * Zellwerte[2]==1) {diag_unten=true; break outer_loop;}
                    break;
                case 1: // zweiter Vierer
                    if (Zellwerte[1] * Zellwerte[2] * Zellwerte[3]==1) {diag_unten=true; break outer_loop;}
                    break;
                case 2: // dritter Vierer
                    if (Zellwerte[2] * Zellwerte[3] * Zellwerte[4]==1) {diag_unten=true; break outer_loop;}
                    break;
                case 3: // vierter Vierer
                    if (Zellwerte[3] * Zellwerte[4] * Zellwerte[5]==1) {diag_unten=true; break outer_loop;}
                    break;
            }
        }

        return diag_unten;

    }


    public boolean pruefe_sieg(int w, int x, int y) {

        /** Diese Methode prueft, ob bei der Auswahl eines bestimmten Feldes, als bestimmter Spieler
         * ein Sieg vorliegt. Dabei werden die Methoden pruefe_sieg_digaonal_nach_oben(),
         * pruefe_sieg_diagonal_nach_unten(), pruefe_sieg_senkrecht() und pruefe_sieg_waagrecht() verwendet.
         * Es wird hierbei bisher nicht ueberprueft, ob dieses Feld ueberhaupt zum  Setzen frei/moeglich ist.
         * Dabei wird nicht gesetzt.**/

        return (pruefe_sieg_diagonal_nach_oben(w, x, y) || pruefe_sieg_diagonal_nach_unten(w, x, y) ||
                pruefe_sieg_senkrecht(w, x, y) || pruefe_sieg_waagrecht(w, x, y));

    }

    public int[] get_Auswertungsarray (int x, int y, int typ) {         // gibt Inhalt der angrenzenden Brettfelder aus (3 vorne, 3 hinten)
        int[] Auswertungsarray = {-2,-2,-2,-2,-2,-2};       // Grundbelegung
        int[] relpos = {-3,-2,-1,1,2,3};                    // relative Position zur aktuellen (x) Position
        int ii;         // Index fuer Schleife

        switch (typ) {
            case 1:     // waagrecht
                for(ii=0;ii<6;ii++){
                    try {
                        Auswertungsarray[ii]= brett[x+relpos[ii]][y];       // Brettposition vorhanden, Brettwert eingelesen
                    } catch (IndexOutOfBoundsException e) {                 // Brettposition nicht vorhanden, Programm wuerde abbrechen
                        Auswertungsarray[ii]=-1;                            // -1 fuer "ausserhalb"
                    }
                }
                break;
            case 2:     // senkrecht
                for(ii=0;ii<6;ii++){
                    try {
                        Auswertungsarray[ii]= brett[x][y+relpos[ii]];       // Brettposition vorhanden, Brettwert eingelesen
                    } catch (IndexOutOfBoundsException e) {                 // Brettposition nicht vorhanden, Programm wuerde abbrechen
                        Auswertungsarray[ii]=-1;                            // -1 fuer "ausserhalb"
                    }
                }
                break;
            case 3:     // diagonal nach rechts oben
                for(ii=0;ii<6;ii++){
                    try {
                        Auswertungsarray[ii]= brett[x+relpos[ii]][y-relpos[ii]];       // Brettposition vorhanden, Brettwert eingelesen
                    } catch (IndexOutOfBoundsException e) {                 // Brettposition nicht vorhanden, Programm wuerde abbrechen
                        Auswertungsarray[ii]=-1;                            // -1 fuer "ausserhalb"
                    }
                }
                break;
            case 4:    // diagonal nach rechts unten
                for(ii=0;ii<6;ii++){
                    try {
                        Auswertungsarray[ii]= brett[x+relpos[ii]][y+relpos[ii]];       // Brettposition vorhanden, Brettwert eingelesen
                    } catch (IndexOutOfBoundsException e) {                 // Brettposition nicht vorhanden, Programm wuerde abbrechen
                        Auswertungsarray[ii]=-1;                            // -1 fuer "ausserhalb"
                    }
                }
                break;
        }
        return Auswertungsarray;
    }
    public double[] berechne_Zellwerte (int[] Auswertungsarray, int w){
        double Wert_leer = 0.25;
        double Wert_aussen = 0;
        double Wert_fremd = 0;
        double Wert_eigen = 1;   // muss wegen Siegpruefung 1 sein
        double[] Zellwerte = new double[Auswertungsarray.length];
        int ii;

        for(ii=0;ii<Auswertungsarray.length;ii++){
            switch (Auswertungsarray[ii]) {
                case -1:
                    Zellwerte[ii]=Wert_aussen;
                    break;
                case 0:
                    Zellwerte[ii]=Wert_leer;
                    break;
                default:
                    if (Auswertungsarray[ii]==w){Zellwerte[ii]=Wert_eigen;}
                    else {Zellwerte[ii]=Wert_fremd;}
            }
        }
        return Zellwerte;
    }




    /*public float bewerte_waagrecht_alt (int w, int x, int y){           // Diese Methode bewertet in waagrechter Richtung.
        float waag=0;
        if (w==1) {  //Falls der Computer der Spieler mit dem Wert 1 ist
            int anzahl = 1; // anzahl eigene Steine in Vierer
            int schrittweite; // = x-3;
            int[] pos_vierer = {x-3, x-2, x-1, x};
            int i_pos_vierer;
            for(i_pos_vierer=0; i_pos_vierer<4;i_pos_vierer++) {
                schrittweite = pos_vierer[i_pos_vierer];
                if (schrittweite < 0 || schrittweite > 6) {  //Falls wir aus dem Spielfeld laufen, dann wird die Gewinnwahrscheinlichkeit nicht groesser.
                } else {
                    switch (brett[schrittweite][y]) {     // Falls einer der vier betrachteten Werte 2 ist, gib fuer waag 0 aus.
                        case 1:
                            anzahl++;
                            break;
                        case 2:
                            anzahl = 0;         //fremder Stein im Vierer, ist nicht die eigentliche Anzahl der eigenen Steine
                            break;
                    }
                }
            }
            //Hier muss die Methode selbstverstaendlich noch durchgefuehrt werden.
        }
        return waag;
    } **/
    public double bewerte_waagrecht (int w, int x, int y){
        double waag=0;
        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 1);
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        for(ii=0;ii<4;ii++){
            switch (ii){
                case 0: // erster Vierer
                    waag = waag + Zellwerte[0]*Zellwerte[1]*Zellwerte[2];
                    break;
                case 1: // zweiter Vierer
                    waag = waag + Zellwerte[1]*Zellwerte[2]*Zellwerte[3];
                    break;
                case 2: // dritter Vierer
                    waag = waag + Zellwerte[2]*Zellwerte[3]*Zellwerte[4];
                    break;
                case 3: // vierter Vierer
                    waag = waag + Zellwerte[3]*Zellwerte[4]*Zellwerte[5];
                    break;
            }



        }

        return waag;
    }

    public double bewerte_senkrecht (int w, int x, int y){
        double senk=0;
        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 2);  //case 2 ist der senkrechte Fall
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        for(ii=0;ii<4;ii++){
            switch (ii){
                case 0: // erster Vierer
                    senk = senk + Zellwerte[0]*Zellwerte[1]*Zellwerte[2];
                    break;
                case 1: // zweiter Vierer
                    senk = senk + Zellwerte[1]*Zellwerte[2]*Zellwerte[3];
                    break;
                case 2: // dritter Vierer
                    senk = senk + Zellwerte[2]*Zellwerte[3]*Zellwerte[4];
                    break;
                case 3: // vierter Vierer
                    senk = senk + Zellwerte[3]*Zellwerte[4]*Zellwerte[5];
                    break;
            }



        }

        return senk;
    }

    public double bewerte_diagonal_nach_rechts_oben (int w, int x, int y){           /** Diese Methode bewertet in waagrechter Richtung.**/

        double diag_oben=0;
        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 3);  //case 3 ist der diagonal_nach_rechts_oben Fall
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        for(ii=0;ii<4;ii++) {
            switch (ii) {
                case 0: // erster Vierer
                    diag_oben = diag_oben + Zellwerte[0] * Zellwerte[1] * Zellwerte[2];
                    break;
                case 1: // zweiter Vierer
                    diag_oben = diag_oben + Zellwerte[1] * Zellwerte[2] * Zellwerte[3];
                    break;
                case 2: // dritter Vierer
                    diag_oben = diag_oben + Zellwerte[2] * Zellwerte[3] * Zellwerte[4];
                    break;
                case 3: // vierter Vierer
                    diag_oben = diag_oben + Zellwerte[3] * Zellwerte[4] * Zellwerte[5];
                    break;
            }
        }


        return diag_oben;

    }

    public double bewerte_diagonal_nach_rechts_unten (int w, int x, int y){           /** Diese Methode bewertet in waagrechter Richtung.**/

        double diag_unten=0;


        int ii;

        int[] Auswertungsarray = get_Auswertungsarray(x, y, 4);  //case 4 ist der diagonal_nach_rechts_unten Fall
        double[] Zellwerte = berechne_Zellwerte(Auswertungsarray,w);

        for(ii=0;ii<4;ii++) {
            switch (ii) {
                case 0: // erster Vierer
                    diag_unten = diag_unten + Zellwerte[0] * Zellwerte[1] * Zellwerte[2];
                    break;
                case 1: // zweiter Vierer
                    diag_unten = diag_unten + Zellwerte[1] * Zellwerte[2] * Zellwerte[3];
                    break;
                case 2: // dritter Vierer
                    diag_unten = diag_unten + Zellwerte[2] * Zellwerte[3] * Zellwerte[4];
                    break;
                case 3: // vierter Vierer
                    diag_unten = diag_unten + Zellwerte[3] * Zellwerte[4] * Zellwerte[5];
                    break;
            }
        }

        return diag_unten;

    }


    public double bewerte (int w, int x, int y){               /** Diese Methode bewertet die moeglicherweise ausgewaehlte Spielposition
     und gibt einen float-Wert zwischen -1 und 1 zurueck.
     Dabei werden die Methoden bewerte_waagrecht(), bewerte_senkrecht(),
     ... verwendet.
     Es wird hierbei bisher nicht ueberprueft, ob das Feld frei ist
     und auch nicht, ob ein Sieg vorliegt. Es wird nicht gesetzt. **/
        double bew;

        bew = bewerte_waagrecht(w, x, y)+ bewerte_senkrecht(w, x, y)+ bewerte_diagonal_nach_rechts_oben(w, x, y)
                +bewerte_diagonal_nach_rechts_unten(w,x,y);


        return bew;
    }

    public double[] bewerte (int w){

        double[] wert = {-1,-1,-1,-1,-1,-1,-1};

        int ii;   //Laufparameter

        for (ii=0;ii<=6;ii++) {                 //verwendet Methode get_hoehe, die die Zeilennummer an, die in der Spalte als nächstes belegt werden kann.

            wert[ii] = bewerte(w, ii, get_hoehe(ii));
        }

        return wert;
    }

    public boolean[] pruefe_sieg (int w){       //Pruefung muss vor dem Steinsetzen erfolgen. (Ueberlegung: Wuerde ich siegen, wenn ich in irgendeine Spalte einen Stein setze?)

        boolean[] wert = {false,false,false,false,false,false,false};

        int ii;   //Laufparameter

        for (ii=0;ii<=6;ii++) {                 //verwendet Methode get_hoehe, die die Zeilennummer an, die in der Spalte als nächstes belegt werden kann.

            wert[ii] = pruefe_sieg(w, ii, get_hoehe(ii));
        }

        return wert;
    }

    public boolean[] pruefe_sieg_nach_Zug (int w,int spalte){       //Pruefung nach dem Steinsetzen in Spalte
// FUNKTIONERT NICHT!
        boolean[] wert = {false,false,false,false,false,false,false};

        int ii;   //Laufparameter
        int pruefhoehe; // Zelle, die ausgewertet werden soll;

        for (ii=0;ii<=6;ii++) {                 //verwendet Methode get_hoehe, die die Zeilennummer an, die in der Spalte als nächstes belegt werden kann.
            pruefhoehe=get_hoehe(ii);
            if (ii==spalte){
                pruefhoehe=pruefhoehe-1;}
            wert[ii] = pruefe_sieg(w, ii,pruefhoehe);
        }

        return wert;
    }

    public int get_hoehe (int x) {  //Gibt die Zeilennummer an, die in der Spalte als nächstes belegt werden kann.

        int hoehe = 5;
        while (brett[x][hoehe] != 0) {
            hoehe--;
            if (hoehe==0) break;
        }
        return hoehe;
    }

    public int entscheide_zug (int w, int typ){

        int beste_spalte=-1;

        int ii; //Laufparameter

        switch (typ) {

            case 1:     //setze zufällig
                do beste_spalte=(int)(Math.random()*7); while (!pruefe_Steinsetzen(beste_spalte));
                break;

            case 2:     //überprüfe, ob man selber gewinnen kann, oder ob der andere gewinnen würde

                boolean[] siegwerte = pruefe_sieg(w);       // pruefe eigener Sieg
                for (ii = 0; ii <= 6; ii++) {
                    if (siegwerte[ii]) {beste_spalte = ii; break;}
                }

                boolean[] siegwerte_gegner = pruefe_sieg(get_gegner(w));       // pruefe Gegnersieg
                for (ii = 0; ii <= 6; ii++) {
                    if (siegwerte_gegner[ii]) {beste_spalte = ii; break;}
                }

                break;

            case 3:         //mit Bewertung der verschiedenen Setzmöglichkeiten
                beste_spalte = entscheide_zug(w,2);
                if (beste_spalte>-1) break;

                beste_spalte=0;
                double[] bewertungswerte = bewerte(w);
                for (ii = 0; ii <= 6; ii++) {
                    if (bewertungswerte[ii] > bewertungswerte[beste_spalte])
                        beste_spalte = ii;
                }
                break;

            case 4:    //mit Bewertung der verschiedenen Setzmöglichkeiten und der des Gegeners

                beste_spalte = entscheide_zug(w,2);
                if (beste_spalte>-1) break;

                beste_spalte=0;
                double faktor=0.5;      //faktor, da man selber am Zug ist und nicht der Gegner
                double[] bewertungswerte_eigen = bewerte(w);
                double[] bewertungswerte_gegner = bewerte(get_gegner(w));
                for (ii=0; ii<=6; ii++) {
                    if ((bewertungswerte_eigen[ii] + faktor * bewertungswerte_gegner[ii])>
                            (bewertungswerte_eigen[beste_spalte] + faktor * bewertungswerte_gegner[beste_spalte]))
                        beste_spalte = ii;
                }
                break;
        }

        if (beste_spalte==-1) beste_spalte = entscheide_zug(w,1);       //notfalls nochmal zufaellig (Kommt vor, wenn case 2 weder eigenen noch Gegnergewinn ermittelt.)

        return beste_spalte;
    }

    public int get_gegner(int w){
        if (w==1) return 2;
        else return 1;
    }

    public int getbrett(int i, int j){
        return brett[i][j];
    }



}