package com.dev.datatower.service.impl;

import static com.dev.datatower.utils.AppConstants.CREATED_AT;
import static com.dev.datatower.utils.AppConstants.ID;
import static com.dev.datatower.utils.AppConstants.PATIENT;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dev.datatower.exception.BadRequestException;
import com.dev.datatower.exception.ResourceNotFoundException;
import com.dev.datatower.model.Patient;
import com.dev.datatower.payload.ApiResponse;
import com.dev.datatower.payload.PagedResponse;
import com.dev.datatower.payload.PatientRequest;
import com.dev.datatower.payload.PatientResponse;
import com.dev.datatower.repository.PatientRepository;
import com.dev.datatower.service.PatientService;
import com.dev.datatower.utils.AppConstants;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;



	@Override
	public PagedResponse<Patient> getListFemalePatients(int page, int size) {
		validatePageNumberAndSize(page, size);

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);

		Page<Patient> patients = patientRepository.findByGenderOrderByLastNameAsc(0 ,pageable);

		List<Patient> content = patients.getNumberOfElements() == 0 ? Collections.emptyList() : patients.getContent();

		return new PagedResponse<>(content, patients.getNumber(), patients.getSize(), patients.getTotalElements(),
            patients.getTotalPages(), patients.isLast());
	}

    private void validatePageNumberAndSize(int page, int size) {
		if (page < 0) {
			throw new BadRequestException("Page number cannot be less than zero.");
		}

		if (size < 0) {
			throw new BadRequestException("Size number cannot be less than zero.");
		}

		if (size > AppConstants.MAX_PAGE_SIZE) {
			throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}

	@Override
	public Patient getPatient(Long id) {
		return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PATIENT, ID, id));
	}

	@Override
	public ApiResponse deletePatient(Long id) {
		patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PATIENT, ID, id));
		patientRepository.deleteById(id);
		return new ApiResponse(Boolean.TRUE, "You successfully deleted patient");
	}

	@Override
	public PatientResponse addPatient(PatientRequest patientRequest) {

		Patient patient = new Patient();
		patient.setFirstName(patientRequest.getFirstName());
		patient.setLastName(patientRequest.getLastName());
		patient.setBirthday(patientRequest.getBirthday());
		patient.setGender(patientRequest.getGender());
	

		Patient newPatient = patientRepository.save(patient);

		PatientResponse patientResponse = new PatientResponse();

		patientResponse.setFirstName(newPatient.getFirstName());
		patientResponse.setLastName(newPatient.getLastName());
		patientResponse.setBirthday(newPatient.getBirthday());
		patientResponse.setGender(newPatient.getGender());

		return patientResponse;
	}

}
