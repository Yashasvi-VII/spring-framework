package com.yashasvi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstprojApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstprojApplication.class, args);

		/*
		 * Person obj = new Person(); we are creating object so we need to delete this
		 * object
		 */

		// we can ask spring to give object by getBean()
		// get bean method belongs to interface called application context so we need
		// object of application
		
		// by adding component annotation it becomes responsibility of spring to create object of class
		
		
		Person obj = context.getBean(Person.class);

		obj.Code();
	}

}
