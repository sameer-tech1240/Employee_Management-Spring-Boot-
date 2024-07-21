package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.employee.constant.EMConstant;
import com.employee.dto.EmployeeManagementDTO;
import com.employee.entity.Employee;
import com.employee.exception.EMException;
import com.employee.mapper.EmployeeManagementMapper;
import com.employee.repository.EmployeeManagementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	private final EmployeeManagementRepository employeeRepo;

	@Value("${ems.employee.not.found.code}")
	private String empNotFoundCode;

	@Value("${ems.employee.not.found.message}")
	private String empNotFoundMessage;

	@Override
	public EmployeeManagementDTO saveEmployee(EmployeeManagementDTO employeeDto) {

		employeeDto.setCreatedOn(EMConstant.CURRENT_TIME);

		Employee save = employeeRepo.save(EmployeeManagementMapper.dtoToEntity(employeeDto));
		return EmployeeManagementMapper.entityToDTO(save);
	}

	@Override
	public List<EmployeeManagementDTO> findAllEmployee() {

		List<Employee> employees = employeeRepo.findAll();

		// List<EmployeeManagementDTO> activeEmployees = new ArrayList<>();

		/*
		 * if (!CollectionUtils.isEmpty(employees)) { for (Employee emp : employees) {
		 * if (emp.getIsActive().equalsIgnoreCase(EmployeeManagementConstant.YES_FLAG))
		 * { activeEmployees.add(EmployeeManagementMapper.entityToDTO(emp));
		 * 
		 * } }
		 * 
		 * }
		 */

		/* second way to get all data */

		/*
		 * for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();)
		 * { Employee employee = iterator.next(); if
		 * (employee.getIsActive().equalsIgnoreCase(EmployeeManagementConstant.YES_FLAG)
		 * ) { activeEmployees.add(EmployeeManagementMapper.entityToDTO(employee));
		 * 
		 * }
		 * 
		 * }
		 */

		/* Third way to get all data using java 8 */

		return employees.stream()
				.filter(employeeManagement -> !CollectionUtils.isEmpty(employees)
						&& employeeManagement.getIsActive().equalsIgnoreCase(EMConstant.YES_FLAG))
				.map(EmployeeManagementMapper::entityToDTO).toList();

	}

	@Override
	public EmployeeManagementDTO findEmployeeById(Long id) throws EMException {

		Optional<Employee> employeeManagement = employeeRepo.findById(id);
		if (employeeManagement.isEmpty()) {

			throw new EMException(empNotFoundCode, empNotFoundMessage, HttpStatus.NOT_FOUND);
		}

		return EmployeeManagementMapper.entityToDTO(employeeManagement.get());
	}

	@Override
	public EmployeeManagementDTO updateEmployee(EmployeeManagementDTO employeeManagementDTO) throws EMException {
		Optional<Employee> employeeManagementOptional = employeeRepo.findById(employeeManagementDTO.getId());
		if (employeeManagementOptional.isEmpty()) {

			throw new EMException(empNotFoundCode, empNotFoundMessage, HttpStatus.NOT_FOUND);
		}

		Employee employee = employeeManagementOptional.get();
		employee = EmployeeManagementMapper.dtoToEntity(employeeManagementDTO);
		employee.setCreatedOn(employeeManagementOptional.get().getCreatedOn());
		employee.setUpdatedOn(EMConstant.CURRENT_TIME);
		return new EmployeeManagementDTO(employeeRepo.save(employee));
	}

	 @Override
	    public boolean deleteEmployeeById(Long id) {
	        if (employeeRepo.existsById(id)) {
	            employeeRepo.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
