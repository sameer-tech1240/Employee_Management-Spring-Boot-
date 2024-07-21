package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeManagementDTO;
import com.employee.exception.EMException;

public interface EmployeeManagementService {
	EmployeeManagementDTO saveEmployee(EmployeeManagementDTO employeeDto);

	List<EmployeeManagementDTO> findAllEmployee();

	EmployeeManagementDTO findEmployeeById(Long id) throws EMException;

	EmployeeManagementDTO updateEmployee(EmployeeManagementDTO employeeManagementDTO) throws EMException;
	
	boolean deleteEmployeeById(Long id);

}
