package com.rest.api.insurance.subject_system.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public boolean customerExists(Customer customer) {
        return customerRepository.existsByIdNumber(customer.getIdNumber());
    }

    @Override
    public Customer getCustomerByIdNumber(long idNumber) {
        return customerRepository.findByIdNumber(idNumber);
    }


    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }


}
