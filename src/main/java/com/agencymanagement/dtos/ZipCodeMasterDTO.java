package com.agencymanagement.dtos;

import lombok.Data;

@Data
public class ZipCodeMasterDTO {

    private Long id;
    private Long zipCode;
    private String cityName;
    private String zipDesc;
    private String state;
    private String stateCode;
    private Long newVh;
    private Long usedVh;

    // Getters and setters
}
