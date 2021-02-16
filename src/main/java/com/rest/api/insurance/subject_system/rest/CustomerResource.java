package com.rest.api.insurance.subject_system.rest;


import com.rest.api.insurance.subject_system.customer.Customer;
import com.rest.api.insurance.subject_system.customer.CustomerInput;
import com.rest.api.insurance.subject_system.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/customers")
@Consumes("application/json")
@Produces("application/json")
public class CustomerResource {

    private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    private CustomerService customerService;


    @GET
    public Response getAllUsers() {
        List<Customer> applicantList = customerService.getAllCustomers();
        return Response.ok(applicantList).build();
    }

    @POST
    public Response createCustomer(CustomerInput customerInput) {
        // Validere kunder og verifisere dem fra ekstern system

        Customer customer = new Customer(customerInput.getFirstName(), customerInput.getLastName(), customerInput.getAddress(), customerInput.getIdNumber());
        long retId;
        if (customerService.customerExists(customer)) {
            retId = customerService.getCustomerByIdNumber(customer.getIdNumber()).getId();
        } else {
            customerService.addCustomer(customer);
            retId = customer.getId();
        }
        return Response.ok(retId).build();
    }


}
