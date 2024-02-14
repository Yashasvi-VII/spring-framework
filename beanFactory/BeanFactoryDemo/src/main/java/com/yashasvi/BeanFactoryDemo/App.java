/*
 * We are now using application contex
 * we have to move the spring.xml file in class path
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

		Person obj = (Person) context.getBean("person");

		System.out.println("Hello World!");
		obj.Code();
	}
}
