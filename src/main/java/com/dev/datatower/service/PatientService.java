package com.dev.datatower.service;

import com.dev.datatower.model.Patient;
import com.dev.datatower.payload.ApiResponse;
import com.dev.datatower.payload.PagedResponse;
import com.dev.datatower.payload.PatientRequest;
import com.dev.datatower.payload.PatientResponse;

public interface PatientService {
    PagedResponse<Patient> getListFemalePatients(int page, int size);
    Patient getPatient(Long id);
    ApiResponse deletePatient(Long id);
	PatientResponse addPatient(PatientRequest patientRequest);
}