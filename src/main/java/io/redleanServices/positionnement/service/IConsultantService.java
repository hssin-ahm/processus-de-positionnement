package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.Consultant;

public interface IConsultantService {

	Consultant addEmployee(Consultant employee);

	List<Consultant> findAllEmployees();

	Consultant updateEmployee(Consultant employee);

	Consultant findEmployeeById(Long id);

	void deleteEmployee(Long id);
	
	List<Consultant> findConsultantParKey(String keyword);

}
