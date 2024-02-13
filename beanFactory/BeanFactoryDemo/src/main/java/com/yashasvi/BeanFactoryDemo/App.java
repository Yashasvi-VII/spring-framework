/*
 * 
It seems like you're trying to instantiate a BeanFactory object using new,
 but the BeanFactory class might be abstract or might not have a public constructor.
  Instead, you should use a factory method or a builder to create an instance of BeanFactory.
   If you're using Spring Framework, you typically don't directly instantiate BeanFactory like this.
    Instead, you would use the ApplicationContext interface or its implementations,
     such as ClassPathXmlApplicationContext or FileSystemXmlApplicationContext,
      to load and manage your beans.

Here's how you can do it using FileSystemXmlApplicationContext:

java

 */
package com.yashasvi.BeanFactoryDemo;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("spring.xml");

		// BeanFactory factory = new BeanFactory(new FileSystemResource("spring.xml"));

		Person obj = (Person) context.getBean("person");

		System.out.println("Hello World!");
		obj.Code();
	}
}
