package com.rest.api.insurance.subject_system.product;

import java.util.List;

public interface ProductService {


    List<Product> getAllProducts();

    void addProduct(Product product);

    boolean productExists(String productGroup, String productName);

    Product getProductByProductGroupAndProductName(String productGroup, String productName);

    long getRandomProductId(int min, int max);
}
