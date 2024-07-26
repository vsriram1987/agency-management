package com.agencymanagement.dtos;

import lombok.Data;

@Data
public class AgentRoleMapDTO {

    private Long id;
    private String agentId;
    private String role;
    private String agentType;

    // Getters and setters
}
