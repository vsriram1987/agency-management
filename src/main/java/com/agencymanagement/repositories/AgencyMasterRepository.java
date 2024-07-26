package com.agencymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencymanagement.entities.AgencyMaster;

@Repository
public interface AgencyMasterRepository extends JpaRepository<AgencyMaster, Long> {
    List<AgencyMaster> findById(String agentId);
}
