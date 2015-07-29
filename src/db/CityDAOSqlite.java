package db;

import java.sql.DriverManager;

/**
 * Created by weishauptj on 26.05.2015.
 */
public class CityDAOSqlite extends CityDAOJDBCImpl {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:db/cities.db";

    public CityDAOSqlite() {
        try {
            Class.forName(JDBC_DRIVER);
            c = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
