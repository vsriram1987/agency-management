package com.agencymanagement.dtos;

import lombok.Data;

@Data
public class AgentBranchMapDTO {

    private Long id;
    private String agentId;
    private Long branchCode;
    private String agentType;

    // Getters and setters
}
