package com.techdisqus.streams;

import java.util.List;

public class Employee{

	private int id;
	private int salary;
	private List<Employee> subordinates;
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}
	public Employee setId(int id) {
		this.id = id;
		return this;
	}
	public int getSalary() {
		return salary;
	}
	public Employee setSalary(int salary) {
		this.salary = salary;
		return this;
	}
	public List<Employee> getSubordinates() {
		return subordinates;
		
	}
	public Employee setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
		return this;
	}
	public String getName() {
		return name;
	}
	public Employee setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Employee setAge(int age) {
		this.age = age;
		return this;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary  + ", name=" + name
				+ ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
