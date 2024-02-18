/*
 * Concept:- prefix and suffix 
 * 
 * anyone can access webApp files so to secure the files we can keep the files in webIner which is private and can only be accessed 
 * by controller
 * 
 * we have to inform dispatcher servlet that whenever you are looking for the view go to views folder 
 * in application.properties folder.
 * 
 * If we want to assign path and the extension we have to use prefix and suffix 
 * 
 * go to https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html
 * search for spring mvc look for spring.mvc.view.prefix and suffix
 * 
 * prefix is what before result and suffix is what after the result.
 * 
 * so we have removed the .jsp extension from the code and put that another folder
*/

package com.yashasvi.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String Home() {
		return "index.jsp";
		//System.out.println("Home page requested!");
	}
	
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("Number 1") int firstValue,@RequestParam("Number 2") int secondValue)
	{
	
		ModelAndView mv = new ModelAndView();
		
		int thirdValue = firstValue + secondValue;
		
		// session.setAttribute("thirdValue", thirdValue);
		mv.addObject("thirdValue", thirdValue);
		mv.setViewName("result");
		
		return mv;
	}
}
