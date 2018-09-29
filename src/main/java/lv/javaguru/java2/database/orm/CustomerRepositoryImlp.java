package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.CustomerRepository;
import lv.javaguru.java2.domain.Customer;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryImlp extends ORMRepository implements CustomerRepository {

    @Override
    public Customer getCustomerById(Long customerId) {
        return (Customer) session()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("id", customerId))
                .uniqueResult();
    }
}
