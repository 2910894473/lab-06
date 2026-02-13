package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a city with a name and a province.
 * It implements Comparable to allow for sorting by city name.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a City object with a specific name and province.
     * @param city
     * The name of the city
     * @param province
     * The name of the province the city belongs to
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city.
     * @return
     * The city name as a String
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Returns the name of the province.
     * @return
     * The province name as a String
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city to another city based on their names.
     * @param o
     * The city object to be compared
     * @return
     * A negative integer, zero, or a positive integer as this city name
     * is less than, equal to, or greater than the specified city name.
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Checks if this city is equal to another object based on city and province names.
     * @param o
     * The object to compare with
     * @return
     * True if the objects are the same or have the same data, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) &&
                Objects.equals(province, city1.province);
    }

    /**
     * Generates a hash code for the city based on its name and province.
     * @return
     * The hash code for this city
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}