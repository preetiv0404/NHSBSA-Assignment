package com.preeti.nhsbsa.assignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.preeti.nhsbsa.assignment.model.Employee;
import com.preeti.nhsbsa.assignment.model.SkillSets;
import com.preeti.nhsbsa.assignment.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	Map<Integer, Employee> empLoyeeData = new HashMap<Integer, Employee>();
	@Autowired
	private EmployeeService employeeService;
	
	
	//get all the employees
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees(){
		
		return employeeService.retrieveAllEmployees();
	}
	
	//get all the skillsets
	@GetMapping("/skillsets")
	List<SkillSets> retreiveAllSkillSets(){		
		return employeeService.retreiveAllSkillSets();
	}
	
	//get skillsets by id
	@GetMapping("/skillsets/{id}")
	ResponseEntity<SkillSets> retreiveSkillsById(@PathVariable int id){		
	SkillSets skillset = employeeService.retrieveSkillsById(id);
	return ResponseEntity.ok().body(skillset);
	}
	
	//get employees by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee emp= employeeService.retrieveEmployee(id);
		 return ResponseEntity.ok().body(emp);
		
	}
	
	//get skillsets of employee by employee id
	@GetMapping("/employees/skillsets/{id}")
	public List<SkillSets> getSkillSetsOfemployee(@PathVariable int id) {
		return employeeService.retrieveSkillsOfEmployee(id);
		
	}
//	@GetMapping("/getanemployeebyname/{name}")
//	public Employee getEmployeeByName(@PathVariable String name) {
//		return employeeService.retrieveEmployeeByName(name);
//		
//	}
	
	//add more skills to skillsets
	@PostMapping("/skillsets/addskills")
	public List<SkillSets> addMoreSkillSets(@RequestBody String newSkills) {
		
		 employeeService.addMoreSkillSets(newSkills);
		
		return employeeService.retreiveAllSkillSets();
	}
	
	//add more employee to employees
	@PostMapping("/employees/add")	
    public List<Employee> addEmployees(@RequestBody Employee newEmployee){	
	employeeService.addEmployees(newEmployee);
	return employeeService.retrieveAllEmployees();
	}
	
	
	@DeleteMapping("employee/delete")
	//update the employee data
	@PutMapping("/employees/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int eid, @RequestBody Employee emp) {
		
		Employee updatedEmployee = employeeService.updateEmployee(eid,emp);
		 return ResponseEntity.ok(updatedEmployee);
		
		
	}
	
	
	

}
