/*
 * we can use special annotation autowired which means 
 * this laptop object will be created  by spring.
 */
package com.yashasvi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Autowired
	Laptop laptop;
	
	
	public void Code()
	{
		laptop.compile();
		
		//System.out.print("i am coding!");
	}
}
