package com.yashasvi.SpringJDBCDemo;

import com.yashasvi.SpringJDBCDemo.Dao.AlienDao;
import com.yashasvi.SpringJDBCDemo.model.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		System.out.println("hello world");
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(1);

		AlienDao alienDao = context.getBean(AlienDao.class);
		alienDao.save(alien1);

		System.out.println(alienDao.findAll());
	}

}
