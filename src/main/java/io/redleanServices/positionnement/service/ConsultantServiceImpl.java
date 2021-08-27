package io.redleanServices.positionnement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.ConsultantDao;
import io.redleanServices.positionnement.entity.Consultant;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ConsultantServiceImpl implements IConsultantService{
    private final ConsultantDao consultantRepo;

    @Autowired
    public ConsultantServiceImpl(ConsultantDao employeeRepo) {
        this.consultantRepo = employeeRepo;
    }
    
	@Override
    public Consultant addEmployee(Consultant employee) {
        employee.setConsultantCode(UUID.randomUUID().toString());
        return consultantRepo.save(employee);
    }
	@Override
    public List<Consultant> findAllEmployees() {
        return consultantRepo.findAll();
    }
	@Override
    public Consultant updateEmployee(Consultant employee) {
        return consultantRepo.save(employee);
    }
	@Override
    public Consultant findEmployeeById(Long id) {
        return consultantRepo.findConsultantById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User by id " + id + " was not found"));
    }
	@Override
    public void deleteEmployee(Long id){
    	consultantRepo.deleteEmployeeById(id);
    }

	@Override
	public List<Consultant> findConsultantParKey(String keyword) {
		return consultantRepo.cherchebyKeyWord(keyword); 
	}
}
