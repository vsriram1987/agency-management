package com.agencymanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ZipCodeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "zip_desc")
    private String zipDesc;

    @Column(name = "state")
    private String state;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "new_vh")
    private Long newVh;

    @Column(name = "used_vh")
    private Long usedVh;

    // Getters and setters
}
