package com.dev.datatower.payload;

import java.util.Date;

import lombok.Data;

@Data
public class PatientResponse {
	private String firstName;
	private String lastName;
	private Integer gender;
    private String birthday;
}
