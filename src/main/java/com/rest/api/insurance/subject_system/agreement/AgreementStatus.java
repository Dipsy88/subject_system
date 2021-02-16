package com.rest.api.insurance.subject_system.agreement;

public enum AgreementStatus {

    NOT_SEND('N'),
    SEND('S'),
    CREATED('C'),
    ACTIVE('A'),
    INACTIVE('I');

    public final char label;

    AgreementStatus(char label) {
        this.label = label;
    }

}
