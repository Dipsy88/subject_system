package com.rest.api.insurance.subject_system.agreement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Long> {


    boolean existsByCustomerIdAndProductId(Long customerId, long productId);

    Agreement findByCustomerIdAndProductId(Long customerId, long productId);

    boolean existsById(Long id);

}
