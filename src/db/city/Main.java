package db.city;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CityDAO cityDAO = CityDAOFactory.createCityDAO();

        // getAllCities
        ArrayList<City> myList = cityDAO.getAllCities();
        for (City c : myList)
            System.out.println(c.toString());

        // findById (id = 25);
        City myCity = cityDAO.findById(25);
        System.out.println(myCity.toString());

        // add City
        City newCity = new City(10000000, "myTown", "USA", "myDistrict", 987654321);
        cityDAO.add(newCity);
        System.out.println("New City: " + newCity.toString());

        // update City
        newCity.setName("YourCity");
        newCity.setPopulation(123456789);
        cityDAO.update(newCity);
        System.out.println("altered City: " + newCity.toString());

        // delete City
        cityDAO.delete(newCity);
        System.out.println("deleted City: " + newCity.toString());

        ((CityDAOJDBCImpl) cityDAO).close();
    }
}
