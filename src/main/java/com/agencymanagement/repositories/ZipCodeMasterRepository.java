package com.agencymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencymanagement.entities.ZipCodeMaster;

@Repository
public interface ZipCodeMasterRepository extends JpaRepository<ZipCodeMaster, Long> {
    List<ZipCodeMaster> findByPinCode(Long pinCode);
}
