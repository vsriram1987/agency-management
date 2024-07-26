package com.agencymanagement.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class AgencyMasterDTO {

    private Long id;
    private String agencyId;
    private String agencyName;
    private String email;
    private Long phone1;
    private Long phone2;
    private String sapCode;
    private String agencyType;
    private Boolean allBranches;
    private LocalDate createdDate;
    private String createdBy;
    private LocalDate updatedDate;
    private String updatedBy;
    private Boolean isDeleted;
    private List<AgencyBranchMapDTO> branches;

    // Getters and setters
}