/**
 * Created by Cornelia on 28.07.2015.
 */
package src;


//import java.lang.*;


import src.logik.Spielfeld2;

public class Main2 {

    public static void main (String[] args) {

        Spielfeld2 spielfeld1 = new Spielfeld2();
        // spielfeld1.ausgeben();
        //System.out.println(spielfeld1.pruefe_Steinsetzen(2));

        spielfeld1.setzte_Stein(2,1);
        spielfeld1.setzte_Stein(2,2);
        spielfeld1.setzte_Stein(2,2);//spielfeld1.setzte_Stein(2,2);//spielfeld1.setzte_Stein(2,2);spielfeld1.setzte_Stein(2,2);
        spielfeld1.setzte_Stein(2, 2);
        spielfeld1.setzte_Stein(4, 1);
        spielfeld1.ausgeben();


       /* System.out.println(spielfeld1.bewerte_waagrecht(1, 4, 4));
        System.out.println(spielfeld1.bewerte_senkrecht(1, 4, 4));
        System.out.println(spielfeld1.bewerte_diagonal_nach_rechts_oben(1, 4, 4));
        System.out.println(spielfeld1.bewerte_diagonal_nach_rechts_unten(1, 4, 4));
        System.out.println(spielfeld1.bewerte(1, 4, 4)); */
        double[] ding=spielfeld1.bewerte(2);
        System.out.println(ding[0] + " | " + ding[1] + " | " + ding[2] + " | " + ding[3] + " | " + ding[4] + " | " + ding[5] + " | " + ding[6]);


        System.out.println(spielfeld1.entscheide_zug(1,3));
        System.out.println(spielfeld1.entscheide_zug(2,3));

       /* spielfeld1.loesche_brett();
        spielfeld1.setze_Zufallssteine(20,1);
        spielfeld1.ausgeben();

        System.out.println(spielfeld1.pruefe_sieg(1, 2, 3) + " | " +  spielfeld1.pruefe_sieg(2,2,3));
*/
  //      System.out.println(spielfeld1.pruefe_sieg_waagrecht(2, 2, 3));
   //     System.out.println(spielfeld1.pruefe_sieg_senkrecht(2, 2, 3));


        // db.spieler.Spieler spieler1 = new db.spieler.Spieler("Paul");
        // Spiel spiel1 = new Spiel(spieler1);

        int num_zug;
        int aktiver_spieler=1;
        boolean sieg=false;

        for (num_zug=6;num_zug<40;num_zug++){
            System.out.println(">>> Spielzug #" + num_zug + " (Spieler " + aktiver_spieler + ") <<<");

            int spalte_1=spielfeld1.entscheide_zug(aktiver_spieler, 1);  //hier geht es nicht um spalte 1 sondern um den case 1
            int spalte_2=spielfeld1.entscheide_zug(aktiver_spieler, 2);
            int spalte_3=spielfeld1.entscheide_zug(aktiver_spieler, 3);
            int spalte=spielfeld1.entscheide_zug(aktiver_spieler, 4);
            if (spielfeld1.pruefe_sieg(aktiver_spieler)[spalte]){sieg=true;}
            spielfeld1.setzte_Stein(spalte, aktiver_spieler);
            spielfeld1.ausgeben();
            System.out.println(" Case 1 (Zufall): " + spalte_1);     //Gibt die Setzalternativen bei den verschiedenen Fällen an.
            System.out.println(" Case 2 (Gewinnen, Verlieren): " + spalte_2);
            System.out.println(" Case 3 (eigene Bewertung der Spalten): " + spalte_3);
            System.out.println(" Case 4 (Bewertung der Spalten auch fuer den Gegner): " + spalte);


            if (sieg){System.out.println("Spieler " + aktiver_spieler + " gewinnt!"); break;}
            try {Thread.sleep(3000);} catch (InterruptedException e){System.out.println("ups");}
            aktiver_spieler=spielfeld1.get_gegner(aktiver_spieler);
        }




    }





}

