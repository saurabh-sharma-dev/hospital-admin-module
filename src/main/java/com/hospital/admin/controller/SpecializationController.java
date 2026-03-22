package com.hospital.admin.controller;

import com.hospital.admin.entity.Specialization;
import com.hospital.admin.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class SpecializationController {

    @Autowired
    private SpecializationService service;

    @GetMapping("/specializations")
    public List<Specialization> getAllSpecializations() {
        return service.getAllSpecializations();
    }
    @PostMapping("/specialization")
    public Specialization addSpecialization(@RequestBody Specialization specialization) {
        return service.saveSpecialization(specialization);
    }

    @DeleteMapping("/specialization/{id}")
    public String deleteSpecialization(@PathVariable Long id) {
        service.deleteSpecialization(id);
        return "Specialization deleted successfully";
    }

}