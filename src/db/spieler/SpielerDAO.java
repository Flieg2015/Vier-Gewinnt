package db.spieler;

import java.util.ArrayList;

/**
 * Created by Cornelia on 29.07.2015.
 */
public interface SpielerDAO {
    Spieler findByName(String name);
    boolean proofByName(String name);
    ArrayList<Spieler> getAllSpieler();
    void add(Spieler s);
    void update(Spieler s);
    void delete(Spieler s);

    ArrayList<String> getBestenliste();
   // public void updateHighscore(int highscore);
   // public void updatePasswd(String passwd);
}
