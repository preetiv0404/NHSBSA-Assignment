package com.preeti.nhsbsa.assignment.model;

import java.util.List;




import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
	
	private Integer employeeId;
	private String name;
	private Levels level;
	private List<SkillSets> skills;
}
