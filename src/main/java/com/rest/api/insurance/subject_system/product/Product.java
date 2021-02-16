package com.rest.api.insurance.subject_system.product;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "INSURANCE_PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "insurance_product_seq", sequenceName = "insurance_product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "insurance_product_seq")
    @Column(name = "product_id")
    private Long id;

    private String productGroup;

    private String productName;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    public Product() {
    }

    public Product(Long id, String productGroup, String productName) {
        this.id = id;
        this.productGroup = productGroup;
        this.productName = productName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
