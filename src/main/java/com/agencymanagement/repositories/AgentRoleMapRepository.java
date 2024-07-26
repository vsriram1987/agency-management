package com.agencymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencymanagement.entities.AgentRoleMap;

@Repository
public interface AgentRoleMapRepository extends JpaRepository<AgentRoleMap, Long> {
    List<AgentRoleMap> findByAgentId(String role);
}
