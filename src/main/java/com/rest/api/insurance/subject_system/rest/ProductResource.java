package com.rest.api.insurance.subject_system.rest;


import com.rest.api.insurance.subject_system.product.Product;
import com.rest.api.insurance.subject_system.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/products")
@Consumes("application/json")
@Produces("application/json")
public class ProductResource {

    private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService productService;


    @GET
    public Response getAllProducts() {
        productService.getAllProducts();
        List<Product> products = productService.getAllProducts();
        return Response.ok(products).build();
    }


}
