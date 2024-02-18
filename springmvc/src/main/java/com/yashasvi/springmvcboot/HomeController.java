/*
 * Concept:- model and modelMap and Need of ModelAttribute.
 * when id and name is passed ad input it is assigned to Person object by itself and it can be done with the help of model attribute.
 * 
 * model attribute is responsible to add data to person object so we don't have to do it manually 
 * 
 * spring will call model attribute before calling any attribute.
 * 
 * 
*/

package com.yashasvi.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yashasvi.springmvcboot.model.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name","person");
	}

	@RequestMapping("/home")
	public String Home() {
		return "index.jsp";
		//System.out.println("Home page requested!");
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("Number 1") int firstValue,@RequestParam("Number 2") int secondValue,Model m)
	{
		
		int thirdValue = firstValue + secondValue;
		
	    m.addAttribute("thirdValue", thirdValue);
	    
		return "result";
	}
	
	//public String addPerson(@RequestParam("id") int firstValue,@RequestParam("name") String secondValue,String name,Model m) {
	
	@RequestMapping("addPerson")
	public String addPerson(@ModelAttribute Person a,String name,Model m) {	
//		Person a = new Person();
//		
//		a.setId(firstValue);
//		a.setName(secondValue);
		
		m.addAttribute("person", a);
		
		return "result";
	}
	
}
