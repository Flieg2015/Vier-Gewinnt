package db.spieler;

import java.sql.DriverManager;

/**
 * Created by Thomas on 05.01.2016.
 */
public class SpielerDAOSqlite extends SpielerDAOJDBCImpl {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:db/spieler/spieler.s3db";

    public SpielerDAOSqlite() {
        try {
            Class.forName(JDBC_DRIVER);
            s = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
