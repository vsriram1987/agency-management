package com.agencymanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agencymanagement.dtos.AgentMasterDTO;

@RestController
@RequestMapping("/api/agentMaster")
public class AgentMasterController {

    @Autowired
    private AgentMasterService agentMasterService;

    @GetMapping("/{id}")
    public ResponseEntity<AgentMasterDTO> getAgentById(@PathVariable Long id) {
        AgentMasterDTO agent = agentMasterService.getAgentById(id);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AgentMasterDTO> createAgent(@RequestBody AgentMasterDTO agentMasterDTO) {
        AgentMasterDTO createdAgent = agentMasterService.createAgent(agentMasterDTO);
        return new ResponseEntity<>(createdAgent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentMasterDTO> updateAgent(@PathVariable Long id, @RequestBody AgentMasterDTO agentMasterDTO) {
        AgentMasterDTO updatedAgent = agentMasterService.updateAgent(id, agentMasterDTO);
        return new ResponseEntity<>(updatedAgent, HttpStatus.OK);
    }

    @PatchMapping("/{id}/delete")
    public ResponseEntity<Void> deleteOrReinstateAgent(@PathVariable Long id, @RequestParam boolean isDeleted) {
        agentMasterService.deleteOrReinstateAgent(id, isDeleted);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
