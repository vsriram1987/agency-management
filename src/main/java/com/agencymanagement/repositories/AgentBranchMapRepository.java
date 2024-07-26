package com.agencymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencymanagement.entities.AgentBranchMap;

@Repository
public interface AgentBranchMapRepository extends JpaRepository<AgentBranchMap, Long> {
    List<AgentBranchMap> findByAgentId(String agentId);
    List<AgentBranchMap> findByBranchCode(Long branchCode);
}