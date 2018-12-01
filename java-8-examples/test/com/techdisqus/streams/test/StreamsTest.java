package com.techdisqus.streams.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.techdisqus.streams.Employee;
import com.techdisqus.streams.EmployeeSteamImpl;

public class StreamsTest {
	
	private List<Employee>  getEmployeeList() {
		Employee employee1 = (Employee) new Employee().setSalary(13).setAge(101).setName("shiva");
		Employee employee2 = (Employee) new Employee().setSalary(133).setAge(110).setName("shiva");
		Employee employee3 = (Employee) new Employee().setSalary(113).setAge(20).setName("shiva");
		Employee employee4 = (Employee) new Employee().setSalary(113).setAge(32).setName("shiva");
		Employee employee5 = (Employee) new Employee().setSalary(9).setAge(34).setName("shiva");
		Employee employee6 = (Employee) new Employee().setSalary(100).setAge(44).setName("shiva");
		Employee employee7 = (Employee) new Employee().setSalary(3).setAge(56).setName("shiva");
		Employee employee8 = (Employee) new Employee().setSalary(2).setAge(65).setName("shiva");
		Employee employee9 = (Employee) new Employee().setSalary(12).setAge(74).setName("shiva");
		
		List<Employee> employees = Stream.of(employee1,employee2,
				employee3,employee4,employee5,
				employee6,employee7,employee8,
				employee9).collect(Collectors.toList());
		
		return employees;
		

	}
	
	private EmployeeSteamImpl getEmployeeStreamImpl() {
		return new EmployeeSteamImpl();
	}
	@Test
	public void testSumStreamV1() {
		for(int i=0;i<=5000;i++) {
			int sum = new EmployeeSteamImpl().getSalarySumOfEmployeeGreaterThanTenV1(getEmployeeList());
			assertEquals("sum should be 484", 484, sum);
		}
		
	}
	@Test
	public void testSumStreamV2() {
		for(int i=0;i<=5000;i++) {
			int sum = new EmployeeSteamImpl().getSalarySumOfEmployeeGreaterThanTenV2(getEmployeeList());
			assertEquals("sum should be 484", 484, sum);
		}
		
	}
	@Test
	public void testSumStreamV3() {
		for(int i=0;i<=5000;i++) {
			int sum = new EmployeeSteamImpl().getSalarySumOfEmployeeGreaterThanTenV3(getEmployeeList());
			assertEquals("sum should be 484", 484, sum);
		}
		
	}
	
	@Test
	public void testGroupBy() {
		List<Employee> employees = getEmployeeList();
		employees.add((Employee) new Employee().setSalary(19).setAge(110).setName("another shiva"));
		employees.add((Employee) new Employee().setSalary(32).setAge(110).setName("another shiva 1"));
		employees.add((Employee) new Employee().setSalary(47).setAge(110).setName("another shiva 2"));
		Map<Integer, List<Employee>> map = getEmployeeStreamImpl().groupByAge(employees);
		assertEquals("count should be 9", 9,map.size());
		
	}
	@Test
	public void testGroupBygreaterThanX() {
		List<Employee> employees = getEmployeeList();
		employees.add((Employee) new Employee().setSalary(19).setAge(110).setName("another shiva"));
		employees.add((Employee) new Employee().setSalary(32).setAge(112).setName("another shiva 1"));
		employees.add((Employee) new Employee().setSalary(47).setAge(111).setName("another shiva 2"));
		Map<Integer, List<Employee>> map = getEmployeeStreamImpl().groupByAgeGreaterThanX(employees,100);
		System.out.println(map);
		assertEquals("count should be 4", 4,map.size());
		
	}
	
	@Test
	public void testcountBygreaterThanX() {
		List<Employee> employees = getEmployeeList();
		employees.add((Employee) new Employee().setSalary(19).setAge(110).setName("another shiva"));
		employees.add((Employee) new Employee().setSalary(32).setAge(112).setName("another shiva 1"));
		employees.add((Employee) new Employee().setSalary(47).setAge(111).setName("another shiva 2"));
		long count = getEmployeeStreamImpl().countByAgeGreaterThanX(employees,100);
		System.out.println(count);
		assertEquals("count should be 5", 5,count);
		
	}

}
