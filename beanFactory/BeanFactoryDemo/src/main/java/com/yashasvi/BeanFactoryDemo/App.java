/*
 * Topic :- Constructor injection  
 * 
 * setter injection simply means when we use property other wise constructor
 * 
 */
package com.yashasvi.BeanFactoryDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class App {
	public static void main(String[] args) {

		// FileSystemXmlApplicationContext context = new
		// FileSystemXmlApplicationContext("spring.xml");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// BeanFactory factory = new BeanFactory(new FileSystemResource("spring.xml"));

		Person obj1 = (Person) context.getBean("person");

		obj1.Code();
		System.out.println(obj1.getAge());
	}
}
