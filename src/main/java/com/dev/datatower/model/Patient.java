package com.dev.datatower.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dev.datatower.model.audit.DateAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "patients")
public class Patient extends DateAudit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "first_name")
	@Size(max = 40)
	private String firstName;

    @NotBlank
	@Column(name = "last_name")
	@Size(max = 40)
	private String lastName;

    @Column(name = "gender")
	private Integer gender;

    @Column(name = "birthday")
	private String birthday;


    public Patient(String firstName, String lastName, Integer gender, String birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
	}
}
