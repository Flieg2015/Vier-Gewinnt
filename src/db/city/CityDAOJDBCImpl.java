package db.city;

import db.city.City;
import db.city.CityDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by weishauptj on 26.05.2015.
 */
public class CityDAOJDBCImpl implements CityDAO {
    protected Connection c = null;
    private Statement stmt = null;

    public CityDAOJDBCImpl() {

    }

    public void close() {
        try {
            c.close();
            System.out.println("Closed database successfully");
        } catch (SQLException ex) {
            System.out.println("Errore closing connections");
        }
    }

    @Override
    public City findById(int id_) {
        City city = null;
        try {
            String sql = "SELECT * FROM City WHERE id = " + id_ + ";";
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String countryCode = rs.getString("CountryCode");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                city = new City(id, name, countryCode, district, population);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return city;
    }

    @Override
    public ArrayList<City> getAllCities() {

        ArrayList<City> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM City;";
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String countryCode = rs.getString("CountryCode");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                City city = new City(id, name, countryCode, district, population);
                list.add(city);
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
    public void add(City city) {
        try {
            String sql = "INSERT INTO City VALUES (" + city.getId() + ", '" + city.getName() + "', '" + city.getCountryCode() + "', '" + city.getDistrict() + "', " + city.getPopulation() + ");";
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(City city) {
        try {
            String sql = "UPDATE City SET Name = '" + city.getName() + "', CountryCode = '" + city.getCountryCode() +
                    "', District = '" + city.getDistrict() + "', Population = " + city.getPopulation() + " WHERE id = " + city.getId() + ";";
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void delete(City city) {
        try {
            String sql = "DELETE FROM City WHERE id = " + city.getId() + ";";
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


}
