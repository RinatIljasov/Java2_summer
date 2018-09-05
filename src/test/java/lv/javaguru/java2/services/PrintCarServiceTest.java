package lv.javaguru.java2.services;

import lv.javaguru.java2.database.orm.CarRepositoryImpl;
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
    private CarRepositoryImpl carRepository;

    @Test
    public void checkIfCanGetAllCars() {
        Mockito.when(carRepository.getAllCars()).thenReturn(new ArrayList<Car>());
        List<Car> cars = carRepository.getAllCars();
        assertNotNull(cars);
    }
    @Test
    public void checkIfCannotGetAllCars() {
        Mockito.when(carRepository.getAllCars()).thenReturn(null);
        List<Car> cars = carRepository.getAllCars();
        assertNull(cars);
    }

    @Test
    public void checkIfCanGetCarById() {
        Mockito.when(carRepository.getCarById(DEFAULT_CAR_ID)).thenReturn(new Car());
        Car car = carRepository.getCarById(DEFAULT_CAR_ID);
        assertNotNull(car);
    }
    @Test
    public void checkIfCannotGetCarById() {
        Mockito.when(carRepository.getCarById(DEFAULT_CAR_ID)).thenReturn(null);
        Car car = carRepository.getCarById(DEFAULT_CAR_ID);
        assertNull(car);
    }
}

