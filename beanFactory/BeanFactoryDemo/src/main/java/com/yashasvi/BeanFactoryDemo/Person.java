package com.yashasvi.BeanFactoryDemo;

public class Person {

	private int age;

	private  Computer com ;
	
	

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	public Person() {
		System.out.print("in constructor ");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void Code() {
		System.out.println("i am coding!");
		com.complile();
	}
}
