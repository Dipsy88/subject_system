package com.rest.api.insurance.subject_system.agreement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = AgreementInput.class)
public class AgreementInput {

    private final Long customerId;

    private final String productGroup;

    private final String product;

    public AgreementInput(@JsonProperty("customerId") Long customerId, @JsonProperty("productGroup") String productGroup, @JsonProperty("product") String product) {
        this.customerId = customerId;
        this.productGroup = productGroup;
        this.product = product;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public String getProduct() {
        return product;
    }
}
