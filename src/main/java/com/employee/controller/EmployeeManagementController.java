package com.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeManagementDTO;
import com.employee.exception.EMException;
import com.employee.service.EmployeeManagementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emloyeeManagement")
@RequiredArgsConstructor
public class EmployeeManagementController {

	private final EmployeeManagementService employeeService;

	@PostMapping("/save")
	public EmployeeManagementDTO saveEmployee(@RequestBody EmployeeManagementDTO dto) {
		return employeeService.saveEmployee(dto);
	}

	@GetMapping
	public List<EmployeeManagementDTO> findAllEmployee() {
		return employeeService.findAllEmployee();

	}

	@GetMapping("/{id}")
	public EmployeeManagementDTO findEmployeeById(@PathVariable Long id) throws EMException {
		return employeeService.findEmployeeById(id);

	}

	@PutMapping("/update")
	public EmployeeManagementDTO updateEmployee(@RequestBody EmployeeManagementDTO dto) throws EMException {
		return employeeService.updateEmployee(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		boolean isRemoved = employeeService.deleteEmployeeById(id);
		if (!isRemoved) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("Employee deleted successfully");
	}
}
