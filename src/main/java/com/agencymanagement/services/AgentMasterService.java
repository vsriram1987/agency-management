import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencymanagement.dtos.AgentBranchMapDTO;
import com.agencymanagement.dtos.AgentMasterDTO;
import com.agencymanagement.dtos.AgentRoleMapDTO;
import com.agencymanagement.entities.AgencyBranchMap;
import com.agencymanagement.entities.AgentBranchMap;
import com.agencymanagement.entities.AgentMaster;
import com.agencymanagement.entities.AgentRoleMap;
import com.agencymanagement.repositories.AgentBranchMapRepository;
import com.agencymanagement.repositories.AgentMasterRepository;
import com.agencymanagement.repositories.AgentRoleMapRepository;

@Service
public class AgentMasterService {

    @Autowired
    private AgentMasterRepository agentMasterRepository;

    @Autowired
    private AgentBranchMapRepository agentBranchMapRepository;

    @Autowired
    private AgentRoleMapRepository agentRoleMapRepository;

    public AgentMasterDTO getAgentById(Long id) {
        AgentMaster agentMaster = agentMasterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agent not found"));
        List<AgentBranchMap> branches = agentBranchMapRepository.findByAgentId(agentMaster.getAgentId());
        List<AgentRoleMap> roles = agentRoleMapRepository.findByAgentId(agentMaster.getAgentId());
        AgentMasterDTO agentMasterDTO = convertToDTO(agentMaster, branches, roles);
        return agentMasterDTO;
    }

    public AgentMasterDTO createAgent(AgentMasterDTO agentMasterDTO) {
        AgentMaster agentMaster = convertToEntity(agentMasterDTO);
        AgentMaster savedAgentMaster = agentMasterRepository.save(agentMaster);
        saveBranches(agentMasterDTO.getBranches(), savedAgentMaster.getId());
        saveRoles(agentMasterDTO.getRoles(), savedAgentMaster.getId());
        return convertToDTO(savedAgentMaster);
    }

    public AgentMasterDTO updateAgent(Long id, AgentMasterDTO agentMasterDTO) {
        AgentMaster existingAgent = agentMasterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agent not found"));
        AgentMaster updatedAgent = updateEntity(existingAgent, agentMasterDTO);
        AgentMaster savedAgentMaster = agentMasterRepository.save(updatedAgent);
        updateBranches(agentMasterDTO.getBranches(), savedAgentMaster.getId());
        updateRoles(agentMasterDTO.getRoles(), savedAgentMaster.getId());
        return convertToDTO(savedAgentMaster);
    }

    public void deleteOrReinstateAgent(Long id, boolean isDeleted) {
        AgentMaster agentMaster = agentMasterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agent not found"));
        agentMaster.setIsDeleted(isDeleted);
        agentMasterRepository.save(agentMaster);
    }

    private void saveBranches(List<AgentBranchMapDTO> branches, String agentId) {
        for (AgentBranchMapDTO branch : branches) {
            AgentBranchMap agentBranchMap = new AgentBranchMap();
            agentBranchMap.setAgentId(agentId);
            agentBranchMap.setBranchCode(branch.getBranchCode());
            agentBranchMapRepository.save(agentBranchMap);
        }
    }

    private void saveRoles(List<AgentRoleMapDTO> roles, String agentId) {
        for (AgentRoleMapDTO role : roles) {
            AgentRoleMap agentRoleMap = new AgentRoleMap();
            agentRoleMap.setAgentId(agentId);
            agentRoleMap.setRole(role.getRole());
            agentRoleMapRepository.save(agentRoleMap);
        }
    }

    private void updateBranches(List<AgentBranchMapDTO> branches, String agentId) {
        List<AgentBranchMap> existingBranches = agentBranchMapRepository.findByAgentId(agentId);
        for (AgentBranchMap existingBranch : existingBranches) {
            boolean isBranchPresent = branches.stream().anyMatch(branch -> branch.getBranchCode().equals(existingBranch.getBranchCode()));
            if (!isBranchPresent) {
                existingBranch.setIsDeleted(true);
                agentBranchMapRepository.save(existingBranch);
            }
        }
        saveBranches(branches, agentId);
    }
    
    private AgentMasterDTO convertToDTO(AgentMaster AgentMaster, List<AgencyBranchMap> branches) {
        AgentMasterDTO dto = new AgentMasterDTO();
        // populate dto fields
        dto.setBranches(branches.stream().map(branch -> {
            AgentBranchMapDTO branchDTO = new AgentBranchMapDTO();
            branchDTO.setBranchCode(branch.getBranchCode());
            return branchDTO;
        }).collect(Collectors.toList()));
        return dto;
    }

    private AgentMaster convertToEntity(AgentMasterDTO AgentMasterDTO) {
        AgentMaster entity = new AgentMaster();
        // populate entity fields
        return entity;
    }
    private AgentMaster updateEntity(AgentMaster existingAgent, AgentMasterDTO agentMasterDTO) {
        // update entity fields
        return existingAgent;
    }
}

   
