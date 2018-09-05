package lv.javaguru.java2.businesslogic.printcar;

import lv.javaguru.java2.database.orm.CarRepositoryImpl;
import lv.javaguru.java2.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PrintCarsService {

    @Autowired
    private CarRepositoryImpl carRepository;

    public List<Car> getCars() {
        return carRepository.getAllCars();
    }

    public Car getCarById(long carId) {
        return carRepository.getCarById(carId);
    }
}
