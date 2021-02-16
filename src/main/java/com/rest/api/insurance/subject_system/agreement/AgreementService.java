package com.rest.api.insurance.subject_system.agreement;

import java.util.List;

public interface AgreementService {


    List<Agreement> getAllAgreements();

    void addAgreement(Agreement agreement);

    boolean agreementExists(Long customerId, Long productId);

    Agreement getAgreementByCustomerIdAndProductId(Long customerId, long productId);

    boolean agreementExists(Long agreementId);

    boolean agreementExists(AgreementInput agreementInput);

    boolean updateAgreementStatus(Long agreementId, AgreementStatus agreementStatus);

}
