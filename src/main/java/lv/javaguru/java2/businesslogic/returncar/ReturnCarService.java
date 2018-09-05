package lv.javaguru.java2.businesslogic.returncar;

import lv.javaguru.java2.businesslogic.CarValidatorImpl;
import lv.javaguru.java2.database.orm.CarRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class ReturnCarService {

    @Autowired
    private CarRepositoryImpl carRepository;
    @Autowired
    private CarValidatorImpl carValidator;

    public void returnCar(long carId) {
        carRepository.returnCar(carId);
    }

    public boolean checkIfCarCanBeReturned(long carId) {
        return carValidator.checkIfCarCanBeReturned(carId);
    }
}
