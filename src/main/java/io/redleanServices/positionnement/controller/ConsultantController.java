package io.redleanServices.positionnement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;

import java.util.List;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/a/consultant")
public class ConsultantController {
    private final ConsultantServiceImpl consultantService;

    public ConsultantController(ConsultantServiceImpl employeeService) {
        this.consultantService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Consultant>> getAllEmployees () {
        List<Consultant> consultant = consultantService.findAllEmployees();
        return new ResponseEntity<>(consultant, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Consultant> getEmployeeById (@PathVariable("id") Long id) {
        Consultant employee = consultantService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Consultant> addEmployee(@RequestBody Consultant employee) {
        Consultant newEmployee = consultantService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Consultant> updateEmployee(@RequestBody Consultant employee) {
        Consultant updateEmployee = consultantService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
    	consultantService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
