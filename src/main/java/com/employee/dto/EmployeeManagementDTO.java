package com.employee.dto;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;

import com.employee.entity.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class EmployeeManagementDTO {
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String city;

	private String address;

	private String contact;

	private String isActive;

	private Timestamp createdOn;

	private Timestamp updatedOn;

	public EmployeeManagementDTO(Employee employee) {
		BeanUtils.copyProperties(employee, this);
	}

}
