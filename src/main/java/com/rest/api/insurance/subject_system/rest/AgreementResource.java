package com.rest.api.insurance.subject_system.rest;


import com.rest.api.insurance.subject_system.SubjectSystemException;
import com.rest.api.insurance.subject_system.agreement.Agreement;
import com.rest.api.insurance.subject_system.agreement.AgreementInput;
import com.rest.api.insurance.subject_system.agreement.AgreementService;
import com.rest.api.insurance.subject_system.agreement.AgreementStatus;
import com.rest.api.insurance.subject_system.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/agreements")

public class AgreementResource {

    private static final Logger logger = LoggerFactory.getLogger(AgreementResource.class);

    @Autowired
    private AgreementService agreementService;

    @Autowired
    private ProductService productService;


    @GET
    @Produces("application/json")
    public Response getAllAgreements() {
        List<Agreement> applicantList = agreementService.getAllAgreements();
        return Response.ok(applicantList).build();
    }

    @PUT
    @Consumes("application/json")
    @Path("/{agreementId}")
    public Response updateStatus(@PathParam("agreementId") Long agreementId, AgreementStatus agreementStatus) {
        if (agreementService.agreementExists(agreementId)) {
            agreementService.updateAgreementStatus(agreementId, agreementStatus);
        } else{
            throw new SubjectSystemException("110");

        }
        return Response.noContent().build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAgreement(AgreementInput agreementInput) {
        long agreementId;
        long productId;

        final String productGroup = agreementInput.getProductGroup();
        final String product = agreementInput.getProduct();
        final Long customerId = agreementInput.getCustomerId();
        if (productService.productExists(productGroup, product)) {
            productId = productService.getProductByProductGroupAndProductName(productGroup, product).getId();
        } else {
            logger.info("Produkt eksistere ikke, derfor lager et ny produkt for demo");
            productId = productService.getRandomProductId(1000000, 999999999);
        }

        if (agreementService.agreementExists(customerId, productId)) {
            logger.error("Agreement allerede eksistere for samme kunde og productId");
            return Response.status(500).build();
        }

        Agreement agreement = new Agreement(customerId, productId, 'N');
        agreementService.addAgreement(agreement);
        agreementId = agreement.getId();

        return Response.ok(agreementId).build();
    }


}
