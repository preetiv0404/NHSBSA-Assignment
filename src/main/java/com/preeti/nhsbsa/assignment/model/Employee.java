package com.preeti.nhsbsa.assignment.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Employee {

    private Integer employeeId;
    private String name;
    private Levels level;
    private List<SkillSets> skills;
}
