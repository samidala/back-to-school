package com.techdisqus.streams.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import com.techdisqus.streams.Employee;
import com.techdisqus.streams.EmployeeSteamImpl;

public class EmployeeStreamsTest {
	
	private static List<Employee>  getEmployeeList() {
		Employee employee1 = (Employee) new Employee().setSalary(13).setAge(101).setName("shiva 1");
		Employee employee2 = (Employee) new Employee().setSalary(133).setAge(110).setName("shiva 2");
		Employee employee3 = (Employee) new Employee().setSalary(113).setAge(20).setName("shiva 3");
		Employee employee4 = (Employee) new Employee().setSalary(113).setAge(32).setName("shiva 4");
		Employee employee5 = (Employee) new Employee().setSalary(9).setAge(34).setName("shiva 5");
		Employee employee6 = (Employee) new Employee().setSalary(100).setAge(44).setName("shiva 6");
		Employee employee7 = (Employee) new Employee().setSalary(3).setAge(56).setName("shiva 7");
		Employee employee8 = (Employee) new Employee().setSalary(2).setAge(65).setName("shiva 8");
		Employee employee9 = (Employee) new Employee().setSalary(12).setAge(74).setName("shiva 9");
		
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
	
	@Test
	public void testGetAllEmployeeNames() {
		List<Employee> employees = getEmployeeList();
		List<String> list = getEmployeeStreamImpl().getAllEmployeeNames(employees);
		assertEquals("comparing output", 9, list.size());
	}
	
	
	@Test
	public void testCalculateAvg() {
		List<Employee> employees = getEmployeeList();
		double avg = getEmployeeStreamImpl().calculateAverage(employees);
		assertEquals("comparing output", 55.33, avg,0.4);
	}
	
	@Test
	public void testCheckIfAllTheEmployeesAgeGteX() {
		List<Employee> employees = getEmployeeList();
		boolean isTrue = getEmployeeStreamImpl().checkIfAllTheEmployeesAgeGteX(employees,30);
		assertEquals("comparing output", false, isTrue);
	}
	
	@Test
	public void testCheckIfAnyTheEmployeesAgeGteX() {
		List<Employee> employees = getEmployeeList();
		boolean isTrue = getEmployeeStreamImpl().checkIfAnyTheEmployeesAgeGteX(employees,30);
		assertEquals("comparing output", true, isTrue);
	}

	
	@Test
	public void testCountByAge() {
		List<Employee> employees = getEmployeeList();
		employees.add((Employee) new Employee().setSalary(19).setName("another shiva").setAge(110));
		employees.add((Employee) new Employee().setSalary(32).setName("another shiva 1").setAge(112));
		employees.add((Employee) new Employee().setSalary(47).setName("another shiva 2").setAge(111));
		int count = getEmployeeStreamImpl().countByAge(employees, 30);
		System.out.println("count "+count);
		assertEquals("comparing output", 12, count);
	}
	
	@Test
	public void testCountSubordinatesWithDifferentName() {
		List<Employee> subordinates = Stream.of((Employee) new Employee().setSalary(19).setId(1).setAge(110).setName("another shiva"),
				(Employee) new Employee().setSalary(32).setId(1).setAge(112).setName("another shiva"),
				(Employee) new Employee().setSalary(47).setId(3).setAge(111).setName("another shiva 2")).collect(Collectors.toList());
		
		List<Employee> employees = getEmployeeList();
		employees.stream().forEach(e -> e.setSubordinates(subordinates));
		long count = getEmployeeStreamImpl().countSubordinatesWithDifferentName(employees);
	//	System.out.println("count "+count);
		assertEquals("comparing output", 2, count);
	}
	@Test
	public void testGetHighestSalEmp() {
		List<Employee> subordinates = Stream.of((Employee) new Employee().setSalary(19).setId(1).setAge(110).setName("another shiva"),
				(Employee) new Employee().setSalary(32).setId(1).setAge(112).setName("another shiva"),
				(Employee) new Employee().setSalary(47).setId(3).setAge(111).setName("another shiva 2")).collect(Collectors.toList());
		
		List<Employee> employees = getEmployeeList();
		employees.stream().forEach(e -> e.setSubordinates(subordinates));
		Employee e = getEmployeeStreamImpl().getHighestSalEmp(employees);
	//	System.out.println("count "+count);
		assertEquals("comparing output", 133, e.getSalary());
	}
	
	@Test
	public void testGetSubordinatesHighestSalEmp() {
		Random random = new Random();
	
		List<Employee> employees = getEmployeeList();
		
		employees.stream().forEach(e -> {
			int s1 = random.nextInt(10000);
			int s2 = random.nextInt(10000);
			int s3 = random.nextInt(10000);
			maxSal = Math.max(s3,Math.max(Math.max(s1, s2),maxSal));
			List<Employee> subordinates = Stream.of((Employee) new Employee().setId(1).setSalary(s1).setName("another shiva"+s1).setAge(110),
					(Employee) new Employee().setSalary(s2).setId(1).setName("another shiva"+s2).setAge(s2),
					(Employee) new Employee().setSalary(s3).setId(3).setName("another shiva"+s3).setAge(s3)).collect(Collectors.toList());
			e.setSubordinates(subordinates);});
		
		
		
		Employee e = getEmployeeStreamImpl().getSubordinateHighestSalEmp(employees);
		System.out.println("result "+maxSal + "result  "+e.getSalary()  );
		assertEquals("comparing output", maxSal, e.getSalary());
	}
	static int maxSal = Integer.MIN_VALUE;
	private static List<Employee> employees = getEmployeeList();
	static {
			Random random = new Random();
			employees.stream().forEach(e ->  e.setId(random.nextInt(1000)));
			employees.stream().forEach(e -> {
			int s1 = random.nextInt(10000);
			int s2 = random.nextInt(10000);
			int s3 = random.nextInt(10000);
			maxSal = Math.max(s3,Math.max(Math.max(s1, s2),maxSal));
			List<Employee> subordinates = Stream.of((Employee) new Employee().setId(random.nextInt(90000)).setSalary(s1).setName("another shiva"+s1).setAge(110),
					(Employee) new Employee().setSalary(s2).setId(random.nextInt(90000)).setName("another shiva"+s2).setAge(s2),
					(Employee) new Employee().setSalary(s3).setId(random.nextInt(90000)).setName("another shiva"+s3).setAge(s3)).collect(Collectors.toList());
			e.setSubordinates(subordinates);});
	}

	
	@Test
	public void testGetSubordinatesHighestSalEmpMapV1() {
		
		System.out.println(new JSONArray(getEmployeeListV1()));
		
		Map<Integer, List<Employee>> map = getEmployeeStreamImpl().getSubordinateHighestSalEmpMapV1(getEmployeeListV1());
		
		map.entrySet().stream().forEach(System.out::println);
		Map<Integer, List<Employee>> map1 = getEmployeeStreamImpl().getSubordinateHighestSalEmpMap(getEmployeeListV1());
	
		System.out.println("*********");
		map1.entrySet().stream().forEach(System.out::println);
		
		Map<Integer, List<Employee>> map2 = getEmployeeStreamImpl().getSubordinateHighestSalEmpMapV3(getEmployeeListV1());
		
		System.out.println("*********");
		map1.entrySet().stream().forEach(System.out::println);
		
		assertEquals(map1, map);
		assertEquals(map1, map2);
		
		Map<Integer, List<Employee>> map3 = getEmployeeStreamImpl().getSubordinateHighestSalEmpMapV4(getEmployeeListV1());
		assertEquals(map1, map3);
		
	}
	
	
	
	private static List<Employee>  getEmployeeListV1() {
		int i = 100;
		Employee employee1 = (Employee) new Employee().setId(i++).setSalary(10000).setAge(101).setName("emp 1");
		Employee employee2 = (Employee) new Employee().setId(i++).setSalary(20000).setAge(110).setName("emp 2");
		Employee employee3 = (Employee) new Employee().setId(i++).setSalary(30000).setAge(20).setName("emp 3");
		Employee employee4 = (Employee) new Employee().setId(i++).setSalary(10000).setAge(32).setName("emp 4");
		Employee employee5 = (Employee) new Employee().setId(i++).setSalary(20000).setAge(34).setName("emp 5");
		Employee employee6 = (Employee) new Employee().setId(i++).setSalary(15000).setAge(44).setName("emp 6");
		Employee employee7 = (Employee) new Employee().setId(i++).setSalary(16000).setAge(56).setName("emp 7");
		Employee employee8 = (Employee) new Employee().setId(i++).setSalary(16000).setAge(65).setName("emp 8");
		Employee employee9 = (Employee) new Employee().setId(i++).setSalary(12000).setAge(74).setName("emp 9");
		
		employee1.setSubordinates(Stream.of(employee2,employee3,employee4).collect(Collectors.toList()));
		employee2.setSubordinates(Stream.of(employee5,employee6).collect(Collectors.toList()));
		employee3.setSubordinates(Stream.of(employee7,employee8).collect(Collectors.toList()));
		employee8.setSubordinates(Stream.of(employee9).collect(Collectors.toList()));
		
		List<Employee> employees = Stream.of(employee1,employee2,
				employee3,employee4,employee5,
				employee6,employee7,employee8,
				employee9).collect(Collectors.toList());
		return employees;
		
	}
	
	
	@Test
	public void testSubordinatesGetAvg() {
		
		Map<Integer, Double> map = getEmployeeStreamImpl().avgSalaryOfSubordnates(getEmployeeListV1());
		Map<Integer, Double> expected = new HashMap<>();
		expected.put(100, 20000d);
		expected.put(101, 17500d);
		expected.put(102, 16000d);
		expected.put(107, 12000d);
		assertEquals(expected, map);
		assertEquals(expected, getEmployeeStreamImpl().avgSalaryOfSubordnatesV2(getEmployeeListV1()));
	}
	@Test
	public void testGetAvg() {
		List<Employee> subordinates = Stream.of((Employee) new Employee().setId(1).setSalary(19).setName("another shiva").setAge(110),
				(Employee) new Employee().setSalary(32).setId(1).setName("another shiva").setAge(112),
				(Employee) new Employee().setSalary(47).setId(3).setName("another shiva 2").setAge(111)).collect(Collectors.toList());
		
		List<Employee> employees = getEmployeeList();
		employees.stream().forEach(e -> e.setSubordinates(subordinates));
		double avg = getEmployeeStreamImpl().getAvg(employees);
	//	System.out.println("count "+count);
		double expected = employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
		assertEquals("comparing output", expected, avg,0.80);
	}
	
	@Test
	public void findMinSal() {
		Map<Integer,Double> map = getEmployeeStreamImpl().findMinSalary(getEmployeeListV1());
		System.out.println(map);
		
		assertEquals(Map.of(100, 10000, 101, 15000, 102, 16000, 107, 12000), map);
		//{100=10000.0, 101=15000.0, 102=16000.0, 107=12000.0}
	}
	
	
	

	
	
	
	
}
