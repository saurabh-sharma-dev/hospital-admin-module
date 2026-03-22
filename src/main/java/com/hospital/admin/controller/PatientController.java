package com.hospital.admin.controller;

import com.hospital.admin.entity.Patient;
import com.hospital.admin.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return service.getAllPatients();
    }

    @PostMapping("/patient/{id}")
    public Patient addPatient(@PathVariable Long id, @RequestBody Patient patient) {
        patient.setId(id);
        return service.savePatient(patient);
    }

    @DeleteMapping("/patient/{id}")
    public String deletePatient(@PathVariable Long id) {
        return service.deletePatient(id);
    }
}