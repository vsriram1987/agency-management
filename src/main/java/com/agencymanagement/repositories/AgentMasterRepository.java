package com.agencymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencymanagement.entities.AgentMaster;

@Repository
public interface AgentMasterRepository extends JpaRepository<AgentMaster, Long> {

    @Query("SELECT a FROM AgentMaster a " +
           "WHERE (:agencyId IS NULL OR a.agencyId = :agencyId) " +
           "AND (:branchCode IS NULL OR a.branchCode = :branchCode) " +
           "AND (:role IS NULL OR a.roles LIKE %:role%) " +
           "AND (:agencyType IS NULL OR a.agencyType = :agencyType)")
    List<AgentMaster> findAgentsByCriteria(@Param("agencyId") String agencyId,
                                           @Param("branchCode") Long branchCode,
                                           @Param("role") String role,
                                           @Param("agencyType") String agencyType);
    List<AgentMaster> findById(String agentId);
}
