package com.agencymanagement.dtos;

import lombok.Data;

@Data
public class AgencyBranchMapDTO {

    private Long id;
    private String agencyId;
    private Long branchCode;
    private String agencyType;

    // Getters and setters
}
