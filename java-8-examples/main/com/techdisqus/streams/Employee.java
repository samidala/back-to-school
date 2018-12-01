package com.techdisqus.streams;

public class Employee extends Person{

	private int salary;
	
	public Employee setSalary(int salary) {
		this.salary = salary;
		return this;
	}
	public int getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Employee [salary=" + salary + "]";
	}

	
	
	
}
