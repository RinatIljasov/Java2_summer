package lv.javaguru.java2.web;

import lv.javaguru.java2.businesslogic.bookcar.BookCarService;
import lv.javaguru.java2.businesslogic.printcar.PrintCarsService;
import lv.javaguru.java2.businesslogic.returncar.ReturnCarService;
import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.web.dtos.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarControler {

    @Autowired
    private BookCarService bookCarService;

    @Autowired
    private ReturnCarService returnCarService;

    @Autowired
    private PrintCarsService printCarsService;

    @RequestMapping(value = "/book/car/{carId}/customer/{customerId}", method = RequestMethod.PUT)
    public void bookCar(@PathVariable("carId") Long carId,
                        @PathVariable("customerId") Long customerId) {
        bookCarService.bookCar(carId, customerId);
    }

    @RequestMapping(value = "/return/car/{id}", method = RequestMethod.PUT)
    public void returnCar(@PathVariable("id") Long id) {
        returnCarService.returnCar(id);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<CarDTO> getCars() {
        List<Car> cars = printCarsService.getCars();
        return cars.stream()
                .map(car -> new CarDTO(car.getId(), car.getManufacturer(), car.getPrice()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public CarDTO getCarById(@PathVariable("id") Long id) {
        Car car = printCarsService.getCarById(id);
        return new CarDTO(car.getId(), car.getManufacturer(), car.getPrice());
    }
}
