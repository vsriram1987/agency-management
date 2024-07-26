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
public class AgencyMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "agency_name")
    private String agencyName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone1")
    private Long phone1;

    @Column(name = "phone2")
    private Long phone2;

    @Column(name = "sap_code")
    private String sapCode;
    
    @Column(name = "agency_rating")
    private String agencyRating;

    @Column(name = "agency_type")
    private String agencyType;

    @Column(name = "all_branches")
    private Boolean allBranches;

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

    // Getters and setters
}
