package com.hospital.admin.controller;

import com.hospital.admin.entity.Doctor;
import com.hospital.admin.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * PUT /api/admin/doctors/{id}/approve
     * Approves a pending doctor registration.
     */
    @PutMapping("/{id}/approve")
    public ResponseEntity<Map<String, Object>> approveDoctor(@PathVariable Long id) {
        Doctor doctor = doctorService.approveDoctor(id);
        return ResponseEntity.ok(Map.of(
                "message", "Doctor approved successfully",
                "doctorId", doctor.getId(),
                "status", doctor.getStatus()
        ));
    }

    /**
     * PUT /api/admin/doctors/{id}/reject
     * Rejects a pending doctor registration.
     */
    @PutMapping("/{id}/reject")
    public ResponseEntity<Map<String, Object>> rejectDoctor(@PathVariable Long id) {
        Doctor doctor = doctorService.rejectDoctor(id);
        return ResponseEntity.ok(Map.of(
                "message", "Doctor rejected successfully",
                "doctorId", doctor.getId(),
                "status", doctor.getStatus()
        ));
    }

    /**
     * DELETE /api/admin/doctors/{id}
     * Permanently deletes a doctor record.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok(Map.of(
                "message", "Doctor deleted successfully",
                "doctorId", id
        ));
    }
}
