package com.preeti.nhsbsa.assignment.service;

import com.preeti.nhsbsa.assignment.model.Employee;
import com.preeti.nhsbsa.assignment.model.Levels;
import com.preeti.nhsbsa.assignment.model.SkillSets;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();
    private static List<SkillSets> skillSets = new ArrayList<>();

    static {
        //Initialising data for skillsets

        SkillSets skill1 = SkillSets.builder().skillId(1).skills("Java").build();
        SkillSets skill2 = SkillSets.builder().skillId(2).skills("JavaScripts").build();
        SkillSets skill3 = SkillSets.builder().skillId(3).skills("SpringBoot MicroServices").build();
        SkillSets skill4 = SkillSets.builder().skillId(4).skills("SpringMVC").build();
        SkillSets skill5 = SkillSets.builder().skillId(5).skills("Struts").build();
        SkillSets skill6 = SkillSets.builder().skillId(6).skills("Hibernate").build();
        SkillSets skill7 = SkillSets.builder().skillId(7).skills("DevOps").build();
        SkillSets skill8 = SkillSets.builder().skillId(8).skills("DataBase Administrator").build();
        SkillSets skill9 = SkillSets.builder().skillId(9).skills("Automation Testing").build();
        SkillSets skill10 = SkillSets.builder().skillId(10).skills("Cloud Computing").build();

        skillSets.add(skill1);
        skillSets.add(skill2);
        skillSets.add(skill3);
        skillSets.add(skill4);
        skillSets.add(skill5);
        skillSets.add(skill6);
        skillSets.add(skill7);
        skillSets.add(skill8);
        skillSets.add(skill9);
        skillSets.add(skill10);
        //Initialising data for employee
        Employee employee1 = Employee.builder().employeeId(1).name("Preeti Namdeo").level(Levels.Expert).skills(Arrays.asList(skill1, skill2, skill3, skill4, skill5, skill6)).build();
        Employee employee2 = Employee.builder().employeeId(2).name("Joana Watson").level(Levels.Practitioner).skills(Arrays.asList(skill7, skill8, skill9, skill10)).build();

        employees.add(employee1);
        employees.add(employee2);
    }

    //fetching all the employee data
    public List<Employee> retrieveAllEmployees() {
        return employees;
    }

    //fetch one employee by employee id
    public Employee retrieveEmployee(Integer id) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(id)) {
                return emp;
            }

        }
        return null;
    }

    //fetch skills of an employee
    public List<SkillSets> retrieveSkillsOfEmployee(Integer empid) {
        Employee emp = retrieveEmployee(empid);
        if (emp == null) {
            return null;
        }
        return emp.getSkills();

    }

    //fetching all skills from skillsets data
    public List<SkillSets> retrieveAllSkillSets() {
        return skillSets;
    }

    //fetch skills by skillid
    public SkillSets retrieveSkillsById(Integer sid) {
        for (SkillSets skills : skillSets) {
            if (skills.getSkillId().equals(sid)) {
                return skills;
            }
        }
        return null;
    }

    //fetching skills by name
    public SkillSets retrieveSkillsByName(String skillname) {
        for (SkillSets skillsList : skillSets) {
            if (skillsList.getSkills().equals(skillname)) {
                return skillsList;
            }
        }
        return null;
    }



    //add more skill sets to existing skillsets
    public String addMoreSkillSets(SkillSets newSkills) {

        SkillSets newskill = SkillSets.builder().skillId(skillSets.size() + 1).skills(newSkills.getSkills()).build();
        skillSets.add(newskill);

        return "Skillset added";

    }

    //add new employee in employee data
    public Employee addEmployees(Employee newEmployee) {
        Employee newEmployeeAdded = Employee.builder().employeeId(employees.size() + 1)
                .name(newEmployee.getName())
                .level(newEmployee.getLevel())
                .skills(newEmployee.getSkills()).build();
        employees.add(newEmployeeAdded);
        return newEmployeeAdded;

    }

    //update existing employee
    public Employee updateEmployee(int eid, Employee emp) {
        Employee empToBeUpdated = this.retrieveEmployee(eid);
        if (empToBeUpdated == null) {
            return null;
        }
        empToBeUpdated = Employee.builder()
                .employeeId(eid)
                .name((emp.getName() != null && !emp.getName().isEmpty()) ? emp.getName() : empToBeUpdated.getName())
                .level((emp.getLevel() != null) ? emp.getLevel() : empToBeUpdated.getLevel())
                .skills((!emp.getSkills().isEmpty()) ? emp.getSkills() : empToBeUpdated.getSkills())
                .build();

        employees.add(empToBeUpdated);
        return empToBeUpdated;
    }
    //updating existing skillsets
    public SkillSets updateSkillSets(int id, SkillSets skill) {
        SkillSets skillsToBeUpdated = this.retrieveSkillsById(id);
        if (skillsToBeUpdated == null) {
            return null;
        }
        skillsToBeUpdated = SkillSets.builder()
                .skillId(id)
                .skills(skill.getSkills())
                .build();
        skillSets.add(skillsToBeUpdated);
        return skillsToBeUpdated;
    }

    //delete an employee
    public String deleteEmployee(int eid) {
        Employee empToBeDeleted = this.retrieveEmployee(eid);
        if (empToBeDeleted == null) {
            return null;
        }
        employees.remove(empToBeDeleted);
        return "Employee deleted";
    }

    //delete skillsets
    public String deleteSkillSets(int id) {
        SkillSets skillToBeDeleted = this.retrieveSkillsById(id);
        if (skillToBeDeleted == null) {
            return null;
        }
        skillSets.remove(skillToBeDeleted);
        return "Skill deleted";
    }


}








