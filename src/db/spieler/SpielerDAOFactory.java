package db.spieler;

/**
 * Created by Cornelia on 29.07.2015.
 */
public class SpielerDAOFactory {

    public static SpielerDAOJDBCImpl createSpielerDAO (){
        //return new SpielerDAOMySql(); //für SQL-Anbindung
        return new SpielerDAOSqlite();  //für SQLite-Anbindung
    }

}
