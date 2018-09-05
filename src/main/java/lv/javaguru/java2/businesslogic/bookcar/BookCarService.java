package lv.javaguru.java2.businesslogic.bookcar;

import lv.javaguru.java2.businesslogic.CarValidatorImpl;
import lv.javaguru.java2.database.orm.CarRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class BookCarService {

    @Autowired
    private CarRepositoryImpl carRepository;
    @Autowired
    private CarValidatorImpl carValidator;

    public void bookCar(Long carId, Long customerId) {
        carRepository.bookCar(carId, customerId);
    }

    public boolean checkIfCustomerHasEnoughMoney(long carId, long customerId) {
        return carValidator.checkIfCustomerHasEnoughMoney(carId, customerId);
    }

    public boolean checkIfCarIsAlreadyBooked(long carId) {
        return carValidator.checkIfCarIsAlreadyBooked(carId);
    }
}
