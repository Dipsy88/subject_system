CREATE SEQUENCE insurance_customer_seq START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE TABLE INSURANCE_CUSTOMER(
    customer_id NUMBER(16,0) DEFAULT insurance_customer_seq.nextval,
    first_name VARCHAR2(150),
    last_name VARCHAR2(150),
    address VARCHAR2(250),
    id_number NUMBER(11,0),
    created_date TIMESTAMP(6),
    modified_date TIMESTAMP(6),

    CONSTRAINT ic_pk PRIMARY KEY(customer_id),
    CONSTRAINT check_id_number CHECK (id_number>9999999999),
    UNIQUE (id_number)
);


CREATE SEQUENCE insurance_product_seq START WITH 1 INCREMENT BY 1 CACHE 5;
CREATE TABLE INSURANCE_PRODUCT(
    product_id NUMBER(12,0) DEFAULT insurance_product_seq.nextval,
    product_group VARCHAR2(100),
    product_name VARCHAR2(100),
    created_date TIMESTAMP(6),
    modified_date TIMESTAMP(6),

    CONSTRAINT ip_pk PRIMARY KEY(product_id),
    UNIQUE (product_group, product_name)
);


CREATE SEQUENCE insurance_agreement_seq START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE TABLE INSURANCE_AGREEMENT(
    agreement_id NUMBER(12,0) DEFAULT insurance_agreement_seq.nextval,
    customer_id NUMBER(16,0),
    product_id NUMBER(12,0),
    status VARCHAR(1),
    created_date TIMESTAMP(6),
    modified_date TIMESTAMP(6),

    CONSTRAINT ig_pk PRIMARY KEY(agreement_id),
    CONSTRAINT ig_ic_fk FOREIGN KEY (customer_id)
                            REFERENCES INSURANCE_CUSTOMER(customer_id),
    UNIQUE (customer_id, product_id)
);

