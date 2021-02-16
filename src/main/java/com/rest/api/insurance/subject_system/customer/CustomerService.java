package com.rest.api.insurance.subject_system.customer;

import java.util.List;

public interface CustomerService {


    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    boolean customerExists(Customer customer);

    Customer getCustomerByIdNumber(long idNumber);

}
