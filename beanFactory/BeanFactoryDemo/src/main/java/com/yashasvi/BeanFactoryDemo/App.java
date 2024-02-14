/*
 * spring creates object even if we don't ask 
 * application context will simply create spring container for you, all the process happens in 
 * jvm and jvm will have a special container called spring container which will have spring beans
 * 
 * any class that has certain variables and every variable will have getters and setters is normally 
 * refereed as bean.
 * 
 * spring not create new object it will give a new reference , see obj1 and obj2 both are referring to 
 * same object.
 * 
 * so we normally call all the beans as singleton beans. (object will be created only once)
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
		obj1.age = 15;
		System.out.println(obj1.age);

		Person obj2 = (Person) context.getBean("person");

		obj2.Code();
		System.out.println(obj2.age);
	}
}
