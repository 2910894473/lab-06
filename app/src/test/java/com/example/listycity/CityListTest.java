package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        // Check for the city added by mockCityList()
        assertTrue(cityList.hasCity(mockCity()));

        // Check for a city that was never added
        City cityNotPresent = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(cityNotPresent));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();

        // Ensure it exists first
        assertTrue(cityList.hasCity(city));

        // Perform delete
        cityList.delete(city);

        // Ensure it is gone
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City cityNotPresent = new City("Vancouver", "BC");

        // Expecting an exception because the city isn't in the list
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(cityNotPresent);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList(); // Contains 1 city already
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Saskatoon", "Saskatchewan"));
        assertEquals(2, cityList.countCities());

        cityList.delete(mockCity());
        assertEquals(1, cityList.countCities());
    }

}
