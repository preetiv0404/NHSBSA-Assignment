package com.preeti.nhsbsa.assignment.controller;

import com.preeti.nhsbsa.assignment.model.Employee;
import com.preeti.nhsbsa.assignment.model.SkillSets;
import com.preeti.nhsbsa.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    //get all the employees
    @GetMapping("employees")
    public List<Employee> retrieveAllEmployees() {

        return employeeService.retrieveAllEmployees();
    }

    //get all the skillsets
    @GetMapping("skillsets")
    List<SkillSets> retreiveAllSkillSets() {
        return employeeService.retrieveAllSkillSets();
    }

    //get skillsets by id
    @GetMapping("skillsets/{id}")
    ResponseEntity<SkillSets> retreiveSkillsById(@PathVariable int id) {
        SkillSets skillset = employeeService.retrieveSkillsById(id);
        return ResponseEntity.ok().body(skillset);
    }

    //get employees by id
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {

        Employee emp = employeeService.retrieveEmployee(id);
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emp);

    }

    //get skillsets of employee by employee id
    @GetMapping("employees/skillsets/{id}")
    public List<SkillSets> getSkillSetsOfemployee(@PathVariable int id) {
        return employeeService.retrieveSkillsOfEmployee(id);

    }


    //add more skills to skillsets
    @PostMapping("skillsets/add")
    public List<SkillSets> addMoreSkillSets(@RequestBody SkillSets newSkills) {

        employeeService.addMoreSkillSets(newSkills);

        return employeeService.retrieveAllSkillSets();
    }

    //add more employee to employees
    @PostMapping("employees/add")
    public List<Employee> addEmployees(@RequestBody Employee newEmployee) {
        employeeService.addEmployees(newEmployee);
        return employeeService.retrieveAllEmployees();
    }

    //delete employee by employee id
    @DeleteMapping("employees/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String deleteConfirmation = employeeService.deleteEmployee(id);
        if (deleteConfirmation == null) {

            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.accepted().body("Employee deleted");
    }

    //delete skills by skillsets id
    @DeleteMapping("skillsets/delete/{id}")
    public ResponseEntity<String> deleteSkillSets(@PathVariable int id) {
        String deleteConfirmation = employeeService.deleteSkillSets(id);
        if (deleteConfirmation == null) {

            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.accepted().body("SkillSets deleted");
    }

    //update the employee data
    @PutMapping("employees/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {

        Employee updatedEmployee = employeeService.updateEmployee(id, emp);
        return ResponseEntity.ok(updatedEmployee);

    }
    //update skills to skillsets
    @PutMapping("skillsets/update/{id}")
    public ResponseEntity<SkillSets> updateSkillSets(@PathVariable int id, @RequestBody SkillSets skill) {

        SkillSets updatedSkills = employeeService.updateSkillSets(id, skill);
        return ResponseEntity.ok(updatedSkills);

    }

}
