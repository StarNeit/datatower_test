package com.dev.datatower.payload;

import java.util.Date;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dev.datatower.validation.DateFormate;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;


import lombok.Data;



@Data
public class PatientRequest {

    @NotBlank
	@Size(min = 4, max = 40)
	private String firstName;

    @NotBlank
	@Size(min = 4, max = 40)
	private String lastName;

    @DateFormate
	private String birthday;

    @NotNull
    @Min(0)
    @Max(2)
    private Integer Gender;
}
