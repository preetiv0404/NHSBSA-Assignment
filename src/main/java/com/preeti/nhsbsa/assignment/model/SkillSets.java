package com.preeti.nhsbsa.assignment.model;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter
public class SkillSets {

	private Integer skillId;
	private String skills;
}
