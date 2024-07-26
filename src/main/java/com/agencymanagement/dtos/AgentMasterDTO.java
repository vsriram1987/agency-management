package com.agencymanagement.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class AgentMasterDTO {

    private Long id;
    private String agentId;
    private String agencyId;
    private String agencySapCode;
    private String loginId;
    private String firstName;
    private String lastName;
    private String email;
    private Long mobile;
    private String agencyEmployeeId;
    private LocalDate createdDate;
    private String createdBy;
    private LocalDate updatedDate;
    private String updatedBy;
    private Boolean isDeleted;
    private String agencyType;
    private Boolean allBranches;
    private List<AgentBranchMapDTO> branches;
    private List<AgentRoleMapDTO> roles;

    // Getters and setters
}
