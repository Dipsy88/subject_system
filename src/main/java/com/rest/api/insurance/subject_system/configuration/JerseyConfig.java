package com.rest.api.insurance.subject_system.configuration;

import com.rest.api.insurance.subject_system.rest.AgreementResource;
import com.rest.api.insurance.subject_system.rest.CustomerResource;
import com.rest.api.insurance.subject_system.rest.ProductResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/fagsystem")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(CustomerResource.class);
        register(AgreementResource.class);
        register(ProductResource.class);
    }
}
