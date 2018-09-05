package lv.javaguru.java2.web;

import lv.javaguru.java2.businesslogic.printcustomer.PrintCustomerService;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.web.dtos.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private PrintCustomerService printCustomerService;

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public CustomerDTO getCustomerById(@PathVariable("id") Long id) {

        Customer customer = printCustomerService.getCustomerById(id);
        return new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getBalance());
    }
}
