package db.spieler;

import java.sql.DriverManager;

/**
 * Created by weishauptj on 26.05.2015.
 */
public class SpielerDAOMySql extends SpielerDAOJDBCImpl {

    // Download JDBC Driver and install -- https://dev.mysql.com/downloads/connector/j/


    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://10.36.104.130/flieg02";

    // Database credentials
    static final String USER = "flieg02";
    static final String PASS = "flieg02";
    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   // static final String DB_URL = "jdbc:mysql://10.36.30.116/VierGewinnt";

    // Database credentials
  // static final String USER = "root";
    //static final String PASS = "123456";

    public SpielerDAOMySql() {
        try {
            Class.forName(JDBC_DRIVER);
               s  = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
}
