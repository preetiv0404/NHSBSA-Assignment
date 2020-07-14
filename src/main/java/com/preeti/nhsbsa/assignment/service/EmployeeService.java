package com.preeti.nhsbsa.assignment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.preeti.nhsbsa.assignment.model.Employee;
import com.preeti.nhsbsa.assignment.model.Levels;
import com.preeti.nhsbsa.assignment.model.SkillSets;

@Component
public class EmployeeService {
	
	private static List<Employee> employees= new ArrayList<>();
	private static List<SkillSets> skillSets= new ArrayList<>();
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
		
		skillSets.add(skill10);
		skillSets.add(skill9);
		skillSets.add(skill8);
		skillSets.add(skill7);
		skillSets.add(skill6);
		skillSets.add(skill5);
		skillSets.add(skill4);
		skillSets.add(skill3);
		skillSets.add(skill2);
		skillSets.add(skill1);
	
		//Initialising data for employee
		Employee employee1 = Employee.builder().employeeId(1).name("Preeti Namdeo").level(Levels.Expert).skills(Arrays.asList(skill1,skill2,skill3,skill4,skill5,skill6)).build();
		Employee employee2 = Employee.builder().employeeId(2).name("Shiva Namdeo").level(Levels.Expert).skills(Arrays.asList(skill7,skill8,skill9,skill10)).build();
		
		employees.add(employee1);
		employees.add(employee2);
	}
	
	//fetching employee data
	//working
public List<Employee> retrieveAllEmployees(){
	return employees;
}

//working
public Employee retrieveEmployee(Integer id) {
	for (Employee emp : employees) {
		if (emp.getEmployeeId().equals(id)) {
			return emp;
		}

	}
	return null;
}


	public List<SkillSets> retrieveSkillsOfEmployee(Integer empid) {
		Employee emp = retrieveEmployee(empid);
		if(emp==null){
			return null;
		}
		 return emp.getSkills();
			
	}
	
	//fetching skills data
	//working
	public List<SkillSets> retreiveAllSkillSets(){		
		return skillSets;
	}
 public	SkillSets retrieveSkillsById(Integer sid) {
		for(SkillSets skills: skillSets)
		{
			if(skills.getSkillId().equals(sid)) {
				return skills;
			}
		}
		return null;
	}
	
	public SkillSets retrieveSkillsByName(String skillname) {
		for(SkillSets skillsList: skillSets)
		{
			if(skillsList.getSkills().equals(skillname)) {
				return skillsList;
			}
		}
		return null;
	}
	//addition of data
	public Employee addSkillSetsToEmployee(Integer eid,String skillsPassedByUser) {
		Employee emp = retrieveEmployee(eid);
		if(emp==null){
			return null;
		}
		
		SkillSets skillsToBeAdded = retrieveSkillsByName(skillsPassedByUser);
		emp.getSkills().add(skillsToBeAdded);
		return emp;
	}
	
	//add more skill sets
	//working
	public String addMoreSkillSets(String newSkills) {
		
		SkillSets newskill = SkillSets.builder().skillId(skillSets.size()+1).skills(newSkills).build();
		skillSets.add(newskill);
		
		return "Skillset added";
		
	}

	public void addEmployees(Employee newEmployee) {
		Employee newEmployeeAdded = Employee.builder().employeeId(employees.size()+1)
				.name(newEmployee.getName())
				.level(newEmployee.getLevel())
				.skills(newEmployee.getSkills()).build();
		employees.add(newEmployeeAdded);
		
	}

	public Employee updateEmployee(int eid, Employee emp) {
		Employee empToBeUpdated = retrieveEmployee(eid);
		if(empToBeUpdated==null){
			return null;
		}
		empToBeUpdated= Employee.builder()
				.name(emp.getName())
				.level(emp.getLevel())
				.skills(emp.getSkills())
				.build();
		
		employees.add(empToBeUpdated);
		return empToBeUpdated;
	}
}








