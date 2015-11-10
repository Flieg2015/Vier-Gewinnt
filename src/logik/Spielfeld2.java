package src.logik;

import java.io.IOException;
import java.util.Vector;

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
                System.out.print(" | ");
                System.out.print(brett[s][z]);
            }
            System.out.print(" |");
            System.out.println();

        }
    }

    public void loesche_brett (){           // Loescht den aktuellen Brettinhalt
        brett = new int[spalte][zeile];
        System.out.println("Spielbrett geloescht");
    }

    public void setze_Zufallssteine (int Steinezahl, int Startspieler){      // setzt (Steinezahl) zufaellige Steine, beginnend mit (Startspieler)
        int ii = 0;

        for (ii=0;ii<Steinezahl;ii++){
           setzte_Stein((int)(Math.random()*7), (ii+Startspieler-1)%2+1);      // Modulo "%"
        }
        System.out.println(Steinezahl + " Zufallssteine hinzugefuegt (Startspieler " + Integer.toString(Startspieler) + ")");
    }
