package com.employee.mapper;

import java.util.Objects;

import com.employee.dto.EmployeeManagementDTO;
import com.employee.entity.Employee;

public class EmployeeManagementMapper {
	public static EmployeeManagementDTO entityToDTO(Employee employee) {
		if (Objects.isNull(employee)) {
			return null;
		}
		EmployeeManagementDTO employeeManagementDTO = new EmployeeManagementDTO();
		employeeManagementDTO.setId(employee.getId());
		employeeManagementDTO.setFirstName(employee.getFirstName());
		employeeManagementDTO.setLastName(employee.getLastName());
		employeeManagementDTO.setEmail(employee.getEmail());
		employeeManagementDTO.setCity(employee.getCity());
		employeeManagementDTO.setAddress(employee.getAddress());
		employeeManagementDTO.setContact(employee.getContact());
		employeeManagementDTO.setIsActive(employee.getIsActive());
		employeeManagementDTO.setCreatedOn(employee.getCreatedOn());
		employeeManagementDTO.setUpdatedOn(employee.getUpdatedOn());
		return employeeManagementDTO;
	}

	public static Employee dtoToEntity(EmployeeManagementDTO dto) {
		Employee employee = new Employee();
		employee.setId(dto.getId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setCity(dto.getCity());
		employee.setAddress(dto.getAddress());
		employee.setContact(dto.getContact());
		employee.setIsActive(dto.getIsActive());
		employee.setCreatedOn(dto.getCreatedOn());
		employee.setUpdatedOn(dto.getUpdatedOn());
		return employee;

	}

}
