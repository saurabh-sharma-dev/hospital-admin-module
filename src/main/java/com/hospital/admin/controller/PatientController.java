package com.hospital.admin.controller;

import com.hospital.admin.entity.Patient;
import com.hospital.admin.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/rooms/{roomNumber}")
    public Map<String, Object> getRoomByRoomNumber(@PathVariable String roomNumber) {

        Map<String, Object> room = new HashMap<>();
        room.put("roomNumber", roomNumber);
        room.put("type", "General");
        room.put("status", "Available");

        return room;
    }
}