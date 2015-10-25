/**
 * Created by Cornelia on 28.07.2015.
 */
package logik;

public class Main_1 {

    public static void main (String[] args) {
        Spielfeld spielfeld1 = new Spielfeld ();
       // spielfeld1.ausgeben();
        //System.out.println(spielfeld1.pruefe_Steinsetzen(2));
spielfeld1.setzte_Stein(2,1);
        spielfeld1.setzte_Stein(2,2);
        spielfeld1.setzte_Stein(2,2);//spielfeld1.setzte_Stein(2,2);//spielfeld1.setzte_Stein(2,2);spielfeld1.setzte_Stein(2,2);
        spielfeld1.setzte_Stein(2,2);
        spielfeld1.setzte_Stein(4,1);
        spielfeld1.ausgeben();

     System.out.println(spielfeld1.pruefe_sieg(2, 2, 3));

  //      System.out.println(spielfeld1.pruefe_sieg_waagrecht(2, 2, 3));
   //     System.out.println(spielfeld1.pruefe_sieg_senkrecht(2, 2, 3));


        db.spieler.Spieler spieler1 = new db.spieler.Spieler("Paul");

        Spiel spiel1 = new Spiel(spieler1);
    }





}
