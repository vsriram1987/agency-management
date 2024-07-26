package com.agencymanagement.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AgentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "agent_id")
    private String agentId;

    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "agency_sap_code")
    private String agencySapCode;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private Long mobile;

    @Column(name = "agency_employee_id")
    private String agencyEmployeeId;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "agency_type")
    private String agencyType;

    @Column(name = "all_branches")
    private Boolean allBranches;

    // Getters and setters
}
