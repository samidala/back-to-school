package com.techdisqus.streams;

public class Person {
	


	private String name;
	private int age;
	
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public Person setAge(int age) {
		this.age = age;
		return this;
	}
	
	public int getAge() {
		return age;
	}
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	

}
