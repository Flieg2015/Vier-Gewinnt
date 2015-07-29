package db.city;

/**
 * Created by weishauptj on 26.05.2015.
 */
public class CityDAOFactory {
    public static CityDAOJDBCImpl createCityDAO() {

        return new CityDAOMySql();
        //return new CityDAOSqlite();
    }



}
