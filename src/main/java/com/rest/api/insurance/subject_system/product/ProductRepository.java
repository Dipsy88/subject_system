package com.rest.api.insurance.subject_system.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    boolean existsByProductGroupAndProductName(String productGroup, String productName);

    Product findByProductGroupAndProductName(String productGroup, String productName);

}
