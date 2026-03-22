package com.hospital.admin.service;

import com.hospital.admin.entity.Doctor;
import com.hospital.admin.exception.DoctorNotFoundException;
import com.hospital.admin.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Approve a doctor — sets status to APPROVED.
     */
    public Doctor approveDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        doctor.setStatus(Doctor.DoctorStatus.APPROVED);
        return doctorRepository.save(doctor);
    }

    /**
     * Reject a doctor — sets status to REJECTED.
     */
    public Doctor rejectDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        doctor.setStatus(Doctor.DoctorStatus.REJECTED);
        return doctorRepository.save(doctor);
    }

    /**
     * Delete a doctor record permanently.
     */
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new DoctorNotFoundException(id);
        }
        doctorRepository.deleteById(id);
    }
}
