package lv.javaguru.java2.businesslogic.printcustomer;

import lv.javaguru.java2.database.orm.CustomerRepositoryImlp;
import lv.javaguru.java2.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class PrintCustomerService {

    @Autowired
    private CustomerRepositoryImlp customerRepository;

    public Customer getCustomerById(long customerId) {
        return customerRepository.getCustomerById(customerId);
    }

}
