package com.hospital.admin.service;

import com.hospital.admin.entity.Patient;
import com.hospital.admin.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    // GET
    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    // SAVE
    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    // DELETE
    public String deletePatient(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Patient deleted successfully da!";
        } else {
            return "Patient ID not found da!";
        }
    }
}