package com.techdisqus.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeSteamImpl {
	
	
	public int getSalarySumOfEmployeeGreaterThanTenV1(List<Employee> employees) {
		return employees.stream().filter(emp -> emp.getSalary() > 10 ).mapToInt(Employee::getSalary).sum();
	}
	
	public int getSalarySumOfEmployeeGreaterThanTenV2(List<Employee> employees) {
		return employees.stream().filter(new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getSalary() > 10;
			}
		}).mapToInt(emp -> emp.getSalary()).sum();
	}
	
	public int getSalarySumOfEmployeeGreaterThanTenV3(List<Employee> employees) {
		return employees.stream().filter(emp -> emp.getSalary() > 10 ).mapToInt(emp -> emp.getSalary()).sum();
	}

	public Map<Integer, List<Employee>> groupByAge(List<Employee> employees){
		return employees.stream().collect(Collectors.groupingBy(Employee::getAge));
	}
	public Map<Integer, List<Employee>> groupByAgeGreaterThanX(List<Employee> employees, int age){
		return employees.stream().filter(e -> e.getAge() >= age).collect(Collectors.groupingBy(Employee::getAge));
	}
	
	public long countByAgeGreaterThanX(List<Employee> employees, int age){
		return employees.stream().filter(e -> e.getAge() >= age).count();
	}
	
	
	
}
