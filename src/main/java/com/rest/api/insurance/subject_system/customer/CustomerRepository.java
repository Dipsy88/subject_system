package com.rest.api.insurance.subject_system.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByIdNumber(Long idNumber);

    Customer findByIdNumber(Long idNumber);


}
