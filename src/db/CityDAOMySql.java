package db;

import java.sql.DriverManager;

/**
 * Created by weishauptj on 26.05.2015.
 */
public class CityDAOMySql extends CityDAOJDBCImpl {

    // Download JDBC Driver and install -- https://dev.mysql.com/downloads/connector/j/

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://10.36.104.130/InformatikDB";

    // Database credentials
    static final String USER = "FLIEG_SEP";
    static final String PASS = "myflieg";

    public CityDAOMySql() {
        try {
            Class.forName(JDBC_DRIVER);
            c = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
}
