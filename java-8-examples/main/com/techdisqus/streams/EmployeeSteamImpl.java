package com.techdisqus.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
	
	
	public List<String> getAllEmployeeNames(List<Employee> employees){
		
		return employees.stream().map(Employee::getName).collect(Collectors.toList());
	}
	
	public double calculateAverage(List<Employee> employees) {
		
		return employees.parallelStream().collect(Collectors.averagingLong(Employee::getSalary));
	}
	
	
	public boolean checkIfAllTheEmployeesAgeGteX(List<Employee> employees, int age) {
		return employees.stream().allMatch(e -> e.getAge() > age);
	}
	
	
	public boolean checkIfAnyTheEmployeesAgeGteX(List<Employee> employees, int age) {
		return employees.stream().anyMatch(e -> e.getAge() > age);
	}
	
	public int countByAge(List<Employee> employees, int age) {
		return employees.stream().collect(Collectors.counting()).intValue();
	}
	
	public long countSubordinatesWithDifferentName(List<Employee> employees) {
		
		return employees.parallelStream().map(Employee::getSubordinates).flatMap(Collection::stream).distinct().count();
	}
	
	public Employee getHighestSalEmp(List<Employee> employees) {
		
		return employees.parallelStream().reduce((t,u) -> t.getSalary() > u.getSalary() ? t : u).get();
	}
	
	public Employee getSubordinateHighestSalEmp(List<Employee> employees) {
		
		return employees.parallelStream().map(Employee::getSubordinates).flatMap(Collection::stream).reduce((t,u) -> t.getSalary() > u.getSalary() ? t : u).get();
	}
	
	public double getAvg(List<Employee> employees) {
		 return employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
	}
	
	public Map<Integer, List<Employee>> getSubordinateHighestSalEmpMap(List<Employee> employees) {
		Map<Integer, List<Employee>> finalMap = new HashMap<>();
		for(Employee e : employees) {
			
			int maxSal = Integer.MIN_VALUE;
			
			if(e.getSubordinates() != null) {
				List<Employee> subOrdinatesListWithHighestSalary = new ArrayList<>();
				for(Employee s: e.getSubordinates()) {
					if(s.getSalary() >= maxSal) {
						maxSal = s.getSalary();
					}
				}
				
				for(Employee s: e.getSubordinates()) {
					if(s.getSalary() == maxSal) {
						subOrdinatesListWithHighestSalary.add(s);
					}
				}
				finalMap.put(e.getId(), subOrdinatesListWithHighestSalary);
			}
			
			
		}
		return finalMap;
	}
	
	public Map<Integer, List<Employee>> getSubordinateHighestSalEmpMapV1(List<Employee> employees) {
		
		return employees.stream().filter(e -> e.getSubordinates() != null)
				.collect(Collectors.toMap(new Function<Employee, Integer>() {

			@Override
			public Integer apply(Employee t) {
				return t.getId();
			}
		}, new Function<Employee, List<Employee>>() {

			@Override
			public List<Employee> apply(Employee t) {
				List<Employee> subordinates = t.getSubordinates();
				List<Employee> subOrdinatesListWithHighestSalary = new ArrayList<>();
				int maxSal = Integer.MIN_VALUE;
				for(Employee s: subordinates) {
					if(s.getSalary() >= maxSal) {
						maxSal = s.getSalary();
					}
				}
				for(Employee s: subordinates) {
					if(s.getSalary() == maxSal) {
						subOrdinatesListWithHighestSalary.add(s);
					}
				}
				return subOrdinatesListWithHighestSalary;
			}
		}));
	}
	
	public Map<Integer, List<Employee>> getSubordinateHighestSalEmpMapV2(List<Employee> employees) {
		
		return employees.stream()
                .filter(e -> e.getSubordinates() != null)
                .collect(Collectors.toMap( //keyMapper
                        Employee::getId,
                        t -> {
                            List<Employee> subordinates = t.getSubordinates();
                            List<Employee> subOrdinatesListWithHighestSalary = new ArrayList<>();
                            int maxSal = Integer.MIN_VALUE;
                            for(Employee s: subordinates) {
                                if(s.getSalary() >= maxSal) {
                                    maxSal = s.getSalary();
                                }
                            }
                            for(Employee s: subordinates) {
                                if(s.getSalary() == maxSal) {
                                    subOrdinatesListWithHighestSalary.add(s);
                                }
                            }
                            return subOrdinatesListWithHighestSalary;
                        }));
	}
	
	public Map<Integer, List<Employee>> getSubordinateHighestSalEmpMapV4(List<Employee> employees) {
		 return employees.stream()
                 .filter(e -> e.getSubordinates() != null)
                 .collect(Collectors.toMap(Employee::getId,
                                           e -> e.getSubordinates ().stream ()
                                                                    .collect (Collectors.groupingBy (Employee::getSalary,
                                                                                                     ()-> new TreeMap<>(((Comparator<Integer>)Integer::compare).reversed ()),
                                                                                                     Collectors.toList()))
                                                                    .values ()
                                                                    .iterator ()
                                                                    .next ()));

	}
	
	public Map<Integer, List<Employee>> getSubordinateHighestSalEmpMapV3(List<Employee> employees) {
		
		return employees.stream()
		         .filter(e -> e.getSubordinates() != null)
		         .collect(Collectors.toMap(Employee::getId,
		                        EmployeeSteamImpl::apply));
	}

	private static List<Employee> apply(Employee t) {
	    int maxSal = t.getSubordinates().stream().mapToInt(Employee::getSalary).max().orElse(Integer.MIN_VALUE);
	    return t.getSubordinates().stream().filter(x -> x.getSalary() == maxSal).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Map<Integer, Double> avgSalaryOfSubordnates(List<Employee> employees){
	
		return employees.stream().filter(e -> e.getSubordinates() != null).collect(Collectors.toMap(Employee::getId, new Function<Employee, Double>() {

			@Override
			public Double apply(Employee t) {
				return t.getSubordinates().stream().mapToInt(Employee::getSalary).asDoubleStream().average().getAsDouble();
			}
			
		})) ;
	}
	
	public Map<Integer, Double> avgSalaryOfSubordnatesV2(List<Employee> employees){
		return employees.stream().filter(e -> e.getSubordinates() != null).collect(Collectors.toMap(Employee::getId, 
				e -> e.getSubordinates().stream().mapToInt(Employee::getSalary).asDoubleStream().average().getAsDouble())) ;
	}
	
	public Map<Integer, Double> findMinSalary(List<Employee> employees){
		
		return employees.stream().filter(e -> e.getSubordinates() != null).collect(Collectors.toMap(Employee::getId, 
				e -> e.getSubordinates().stream().mapToInt(Employee::getSalary).asDoubleStream().min().getAsDouble())) ;
	}
	
}
