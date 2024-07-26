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

import com.agencymanagement.dtos.AgencyMasterDTO;

@RestController
@RequestMapping("/api/agencyMaster")
public class AgencyMasterController {

    @Autowired
    private AgencyMasterService agencyMasterService;

    @GetMapping("/{id}")
    public ResponseEntity<AgencyMasterDTO> getAgencyById(@PathVariable Long id) {
        AgencyMasterDTO agency = agencyMasterService.getAgencyById(id);
        return new ResponseEntity<>(agency, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AgencyMasterDTO> createAgency(@RequestBody AgencyMasterDTO agencyMasterDTO) {
        AgencyMasterDTO createdAgency = agencyMasterService.createAgency(agencyMasterDTO);
        return new ResponseEntity<>(createdAgency, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgencyMasterDTO> updateAgency(@PathVariable Long id, @RequestBody AgencyMasterDTO agencyMasterDTO) {
        AgencyMasterDTO updatedAgency = agencyMasterService.updateAgency(id, agencyMasterDTO);
        return new ResponseEntity<>(updatedAgency, HttpStatus.OK);
    }

    @PatchMapping("/{id}/delete")
    public ResponseEntity<Void> deleteOrReinstateAgency(@PathVariable Long id, @RequestParam boolean isDeleted) {
        agencyMasterService.deleteOrReinstateAgency(id, isDeleted);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
