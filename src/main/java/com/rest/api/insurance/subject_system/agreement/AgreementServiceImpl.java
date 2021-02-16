package com.rest.api.insurance.subject_system.agreement;


import com.rest.api.insurance.subject_system.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgreementServiceImpl implements AgreementService {

    private static final Logger logger = LoggerFactory.getLogger(AgreementServiceImpl.class);


    @Autowired
    private AgreementRepository agreementRepository;
    @Autowired
    private ProductService productService;


    @Override
    public List<Agreement> getAllAgreements() {
        return agreementRepository.findAll();
    }

    @Override
    public boolean agreementExists(Long customerId, Long productId) {
        return agreementRepository.existsByCustomerIdAndProductId(customerId, productId);
    }


    @Override
    public boolean agreementExists(Long agreementId) {
        return agreementRepository.existsById(agreementId);
    }

    @Override
    public boolean updateAgreementStatus(Long agreementId, AgreementStatus agreementStatus) {
        Optional<Agreement> agreementOptional = agreementRepository.findById(agreementId);
        if (agreementOptional.isPresent()) {
            Agreement agreement = agreementOptional.get();
            agreement.setStatus(agreementStatus.label);
            agreementRepository.save(agreement);
        }
        return agreementRepository.existsById(agreementId);
    }


    @Override
    public boolean agreementExists(AgreementInput agreementInput) {
        if (productService.productExists(agreementInput.getProductGroup(), agreementInput.getProduct())) {
            long productId = productService.getProductByProductGroupAndProductName(agreementInput.getProductGroup(), agreementInput.getProduct()).getId();
            return agreementExists(agreementInput.getCustomerId(), productId);
        }
        return false;
    }


    @Override
    public Agreement getAgreementByCustomerIdAndProductId(Long customerId, long productId) {
        return agreementRepository.findByCustomerIdAndProductId(customerId, productId);
    }


    @Override
    public void addAgreement(Agreement agreement) {
        agreementRepository.save(agreement);
    }


}
