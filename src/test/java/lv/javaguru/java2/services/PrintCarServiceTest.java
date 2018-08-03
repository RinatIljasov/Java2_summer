package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PrintCarServiceTest {

    public static final long DEFAULT_CAR_ID = 1L;
    @Mock
    private Database database;

    @Test
    public void checkIfCangetAllCars() {
        Mockito.when(database.getAllCars()).thenReturn(new ArrayList<Car>());
        List<Car> cars = database.getAllCars();
        assertNotNull(cars);
    }
    @Test
    public void checkIfCannotGetAllCars() {
        Mockito.when(database.getAllCars()).thenReturn(null);
        List<Car> cars = database.getAllCars();
        assertNull(cars);
    }

    @Test
    public void checkIfCanGetCarById() {
        Mockito.when(database.getCarById(DEFAULT_CAR_ID)).thenReturn(new Car());
        Car car = database.getCarById(DEFAULT_CAR_ID);
        assertNotNull(car);
    }
    @Test
    public void checkIfCannotGetCarById() {
        Mockito.when(database.getCarById(DEFAULT_CAR_ID)).thenReturn(null);
        Car car = database.getCarById(DEFAULT_CAR_ID);
        assertNull(car);
    }
}

