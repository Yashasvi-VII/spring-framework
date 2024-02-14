/*
 * Topic :-Autowire 
 * 
 * autowire means we are telling spring if you are setting some property and if the bean is z
 * then connect it automatically 
 * 
 * autowire have two types 1 by name (id of the bean) and by type of bean.
 * 
 * by type we need to add primary attribute it will give preference to any one.
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
