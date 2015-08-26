package db.spieler;

import java.util.ArrayList;

/**
 * Created by Cornelia on 29.07.2015.
 */
public interface SpielerDAO {
    public Spieler findByName(String name);
    public boolean proofByName(String name);
    public ArrayList<Spieler> getAllSpieler();
    public void add(Spieler s);
    public void update(Spieler s);
    public void delete(Spieler s);
   // public void updateHighscore(int highscore);
   // public void updatePasswd(String passwd);
}
