package com.yashasvi.BeanFactoryDemo;

public class Person {

	private int age;

	private Laptop laptop ;
	
	
	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

//	public Person() {
//		System.out.print("in constructor ");
//	}

	public Person(int age) {
		this.age=age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void Code() {
		System.out.println("i am coding!");
		laptop.compile();
	}
}
