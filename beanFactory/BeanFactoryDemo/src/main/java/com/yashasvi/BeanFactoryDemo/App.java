/*
 * Topic :- setter injection 
 * 
 * In the bean tag we can use another tag called as property , if class is bean then every variable will
 * be called as property.
 * 
 * first it will create the object and then will assign the age.
 * 
 * NOTE property name and set method name should be same.
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
