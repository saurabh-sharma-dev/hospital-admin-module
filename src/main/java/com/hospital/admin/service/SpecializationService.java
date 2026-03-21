
package com.hospital.admin.service;

import com.hospital.admin.entity.Specialization;
import com.hospital.admin.repository.SpecializationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationRepository repository;

    public List<Specialization> getAllSpecializations() {
        return repository.findAll();
    }
}