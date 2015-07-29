package db.city;

import db.city.City;

import java.util.ArrayList;

/**
 * Created by weishauptj on 26.05.2015.
 */
public interface CityDAO {
    public City findById(int id);

    public ArrayList<City> getAllCities();

    public void add(City c);

    public void update(City c);

    public void delete(City c);
}
