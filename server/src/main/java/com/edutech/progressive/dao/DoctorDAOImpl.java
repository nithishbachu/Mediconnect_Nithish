package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Doctor;

public class DoctorDAOImpl implements DoctorDAO{
    List<Doctor> doctorList = new ArrayList<>();

    @Override
    public int addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        return doctor.getDoctorId();
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        for(Doctor d : doctorList){
            if(d.getDoctorId() == doctorId){
                return d;
            }
        }
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        Doctor d = getDoctorById(doctor.getDoctorId());
        if(d != null){
            d.setFullName(doctor.getFullName());
            d.setSpecialty(doctor.getSpecialty());
            d.setContactNumber(doctor.getContactNumber());
            d.setEmail(doctor.getEmail());
            d.setYearsOfExperience(doctor.getYearsOfExperience());
        }
    }

    @Override
    public void deleteDoctor(int doctorId) {
        Doctor d = getDoctorById(doctorId);
        if(d != null){
            doctorList.remove(d);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

}
