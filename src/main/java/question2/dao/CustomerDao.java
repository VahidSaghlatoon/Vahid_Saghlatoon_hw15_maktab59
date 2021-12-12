package question2.dao;

import question2.entity.Customer;

public class CustomerDao extends BaseDao<Customer,Long> {
    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
