package com.agencymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencymanagement.entities.AgencyBranchMap;

@Repository
public interface AgencyBranchMapRepository extends JpaRepository<AgencyBranchMap, Long> {
    List<AgencyBranchMap> findByAgencyId(String agencyId);
    List<AgencyBranchMap> findByBranchCode(Long branchCode);
}
