package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a city is present in the list
     * @param city The city to check for
     * @return Boolean true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list if it exists
     * @param city The city to delete
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * This returns the number of cities in the list
     * @return The size of the list
     */
    public int countCities() {
        return cities.size();
    }
}



