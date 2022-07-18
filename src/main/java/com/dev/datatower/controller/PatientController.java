package com.dev.datatower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.datatower.model.Patient;
import com.dev.datatower.payload.ApiResponse;
import com.dev.datatower.payload.PagedResponse;
import com.dev.datatower.payload.PatientRequest;
import com.dev.datatower.payload.PatientResponse;
import com.dev.datatower.service.PatientService;
import com.dev.datatower.utils.AppConstants;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;

	@GetMapping("/list-female")
	public ResponseEntity<PagedResponse<Patient>> getListFemalePatients(@RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
    @RequestParam(value = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size){
		PagedResponse<Patient> response = patientService.getListFemalePatients(page, size);
		return new ResponseEntity< >(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPost(@PathVariable(name = "id") Long id) {
		Patient patient = patientService.getPatient(id);
		return new ResponseEntity< >(patient, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PatientResponse> addPatient(@Valid @RequestBody PatientRequest patientRequest) {
		PatientResponse patientResponse = patientService.addPatient(patientRequest);

		return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletePatient(@PathVariable(name = "id") Long id) {
		ApiResponse apiResponse = patientService.deletePatient(id);

		return new ResponseEntity< >(apiResponse, HttpStatus.OK);
	}
}
