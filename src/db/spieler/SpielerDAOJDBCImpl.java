package db.spieler;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by weishauptj on 26.05.2015.
 */
public class SpielerDAOJDBCImpl implements SpielerDAO {
    protected Connection s = null;
    private Statement stmt = null;

    public SpielerDAOJDBCImpl() {

    }

    public void close() {
        try {
            s.close();
            System.out.println("Closed database successfully");
        } catch (SQLException ex) {
            System.out.println("Errore closing connections");
        }
    }

    @Override
    public Spieler findByName(String name_) {
        Spieler spieler = null;
        try {
            String sql = "SELECT * FROM Spieler WHERE Name = '" + name_ + "';";
            stmt = s.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("Name");
                String passwd = rs.getString("Passwort");
                int highscore = rs.getInt("Highscore");

                spieler = new Spieler(name, passwd, highscore);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return spieler;
    }

    // methodeprüft ob der Benutzer existiert
    public boolean proofByName(String name_) {
        Spieler spieler = null;
        try {
            String sql = "SELECT * FROM Spieler WHERE Name = '" + name_ + "';";


            stmt = s.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            spieler = new Spieler("dffergferejetee5srhw455657urefe", "ddd", 22);

            while (rs.next()) {
                String name = rs.getString("Name");
                String passwd = rs.getString("Passwort");
                int highscore = rs.getInt("Highscore");

                spieler = new Spieler(name, passwd, highscore);

            }
            rs.close();
            stmt.close();


        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

        }

        if(name_.equals(spieler.getName())){return true;}
        else {return false;}

    }




    @Override
    public ArrayList<Spieler> getAllSpieler() {

        ArrayList<Spieler> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Spieler ORDER BY Highscore DESC;";
            stmt = s.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("Name");
                String passwd = rs.getString("Passwort");
                int highscore = rs.getInt("Highscore");

                Spieler spieler = new Spieler(name, passwd, highscore);
                list.add(spieler);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return list;
    }

    @Override
    public void add(Spieler spieler) {
        try {
            String sql = "INSERT INTO Spieler VALUES ( '" + spieler.getName() + "', '" + spieler.getPasswd() + "', '" + spieler.getHighscore() + "');";
            stmt = s.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Spieler spieler) {
        try {
            String sql = "UPDATE Spieler SET Passwort = '" + spieler.getPasswd() +
                    "', Highscore = " + spieler.getHighscore() + " WHERE name = '" + spieler.getName() + "';";
            stmt = s.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void changePassword(String name, String Passwd) {
        Spieler spieler=findByName(name);
        spieler.setPasswd(Passwd);
        try {
            String sql = "UPDATE Spieler SET Passwort = '" + spieler.getPasswd() +
                    "', Highscore = " + spieler.getHighscore() + " WHERE name = '" + spieler.getName() + "';";
            stmt = s.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void changeName(String name, String NewName) {
        Spieler spieler=findByName(name);
        spieler.setName(NewName);
        try {
            String sql = "UPDATE Spieler SET Passwort = '" + spieler.getPasswd() +
                    "', Highscore = " + spieler.getHighscore() + " WHERE name = '" + spieler.getName() + "';";
            stmt = s.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }




    @Override
    public void delete(Spieler spieler) {
        try {
            String sql = "DELETE FROM Spieler WHERE name = '" + spieler.getName() + "';";
            stmt = s.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public ArrayList<String> getBestenliste() {

        ArrayList<String> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Spieler ORDER BY highscore DESC;";
            stmt = s.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int i=0;
            while (rs.next() && i<10) {
                String name = rs.getString("Name");
                String passwd = rs.getString("Passwort");
                int highscore = rs.getInt("Highscore");

                list.add(name);
                //list.add(Integer.toString(highscore));
                i++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return list;




    }
}