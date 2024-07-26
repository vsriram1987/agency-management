package com.agencymanagement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencymanagement.dtos.AgencyBranchMapDTO;
import com.agencymanagement.dtos.AgencyMasterDTO;
import com.agencymanagement.entities.AgencyBranchMap;
import com.agencymanagement.entities.AgencyMaster;
import com.agencymanagement.repositories.AgencyBranchMapRepository;
import com.agencymanagement.repositories.AgencyMasterRepository;

@Service
public class AgencyMasterService {

    @Autowired
    private AgencyMasterRepository agencyMasterRepository;

    @Autowired
    private AgencyBranchMapRepository agencyBranchMapRepository;

    public AgencyMasterDTO getAgencyById(String id) {
        AgencyMaster agencyMaster = agencyMasterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agency not found"));
        List<AgencyBranchMap> branches = agencyBranchMapRepository.findByAgencyId(agencyMaster.getAgencyId());
        AgencyMasterDTO agencyMasterDTO = convertToDTO(agencyMaster, branches);
        return agencyMasterDTO;
    }

    public AgencyMasterDTO createAgency(AgencyMasterDTO agencyMasterDTO) {
        AgencyMaster agencyMaster = convertToEntity(agencyMasterDTO);
        AgencyMaster savedAgencyMaster = agencyMasterRepository.save(agencyMaster);
        saveBranches(agencyMasterDTO.getBranches(), savedAgencyMaster.getAgencyId());
        return convertToDTO(savedAgencyMaster);
    }

    public AgencyMasterDTO updateAgency(Long id, AgencyMasterDTO agencyMasterDTO) {
        AgencyMaster existingAgency = agencyMasterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agency not found"));
        AgencyMaster updatedAgency = updateEntity(existingAgency, agencyMasterDTO);
        AgencyMaster savedAgencyMaster = agencyMasterRepository.save(updatedAgency);
        updateBranches(agencyMasterDTO.getBranches(), savedAgencyMaster.getAgencyId());
        return convertToDTO(savedAgencyMaster);
    }

    public void deleteOrReinstateAgency(Long id, boolean isDeleted) {
        AgencyMaster agencyMaster = agencyMasterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agency not found"));
        agencyMaster.setIsDeleted(isDeleted);
        agencyMasterRepository.save(agencyMaster);
    }

    private void saveBranches(List<AgencyBranchMapDTO> branches, String agencyId) {
        for (AgencyBranchMapDTO branch : branches) {
            AgencyBranchMap agencyBranchMap = new AgencyBranchMap();
            agencyBranchMap.setAgencyId(agencyId);
            agencyBranchMap.setBranchCode(branch.getBranchCode());
            agencyBranchMapRepository.save(agencyBranchMap);
        }
    }

    private void updateBranches(List<AgencyBranchMapDTO> branches, String agencyId) {
        List<AgencyBranchMap> existingBranches = agencyBranchMapRepository.findByAgencyId(agencyId);
        for (AgencyBranchMap existingBranch : existingBranches) {
            boolean isBranchPresent = branches.stream().anyMatch(branch -> branch.getBranchCode().equals(existingBranch.getBranchCode()));
            if (!isBranchPresent) {
                existingBranch.setIsDeleted(true);
                agencyBranchMapRepository.save(existingBranch);
            }
        }
        saveBranches(branches, agencyId);
    }

    private AgencyMasterDTO convertToDTO(AgencyMaster agencyMaster, List<AgencyBranchMap> branches) {
        AgencyMasterDTO dto = new AgencyMasterDTO();
        // populate dto fields
        dto.setBranches(branches.stream().map(branch -> {
            AgencyBranchMapDTO branchDTO = new AgencyBranchMapDTO();
            branchDTO.setBranchCode(branch.getBranchCode());
            return branchDTO;
        }).collect(Collectors.toList())); 
        return dto;
    }

    private AgencyMaster convertToEntity(AgencyMasterDTO agencyMasterDTO) {
        AgencyMaster entity = new AgencyMaster();
        // populate entity fields
        return entity;
    }

    private AgencyMaster updateEntity(AgencyMaster existingAgency, AgencyMasterDTO agencyMasterDTO) {
        // update entity fields
        return existingAgency;
    }
}
