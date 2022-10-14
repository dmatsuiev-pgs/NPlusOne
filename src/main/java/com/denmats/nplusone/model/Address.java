package com.denmats.nplusone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Address {
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    private String city;
}
