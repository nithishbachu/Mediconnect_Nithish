package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Patient;

public class PatientDAOImpl implements PatientDAO {
    List<Patient> patientList = new ArrayList<>();

    @Override
    public int addPatient(Patient patient) {
        patientList.add(patient);
        return patient.getPatientId();
    }

    @Override
    public Patient getPatientById(int patientId) {
        for(Patient p : patientList){
            if(p.getPatientId() == patientId){
                return p;
            }
        }
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {
        Patient p = getPatientById(patient.getPatientId());
        if(p != null){
            p.setFullName(patient.getFullName());
            p.setDateOfBirth(patient.getDateOfBirth());
            p.setContactNumber(patient.getContactNumber());
            p.setEmail(patient.getEmail());
            p.setAddress(patient.getAddress());
        }
    }

    @Override
    public void deletePatient(int patientId) {
        Patient p = getPatientById(patientId);
        if(p != null){
            patientList.remove(p);
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientList;
    }
}
