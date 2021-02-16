package com.rest.api.insurance.subject_system.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Cacheable(value = "productExistsCache")
    public boolean productExists(String productGroup, String productName) {
        return productRepository.existsByProductGroupAndProductName(productGroup, productName);
    }


    @Override
    @Cacheable(value = "productGetCache")
    public Product getProductByProductGroupAndProductName(String productGroup, String productName) {
        return productRepository.findByProductGroupAndProductName(productGroup, productName);
    }


    @Override
    public long getRandomProductId(int min, int max) {
        return getRandomNumber(min, max);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }


    private long getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }


}
