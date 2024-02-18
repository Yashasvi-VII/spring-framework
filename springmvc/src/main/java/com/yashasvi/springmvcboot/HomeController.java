/*
 * Concept:- model and modelmap
 * 
 * 
*/

package com.yashasvi.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String add(@RequestParam("Number 1") int firstValue,@RequestParam("Number 2") int secondValue,Model m)
	{
	
		//ModelAndView mv = new ModelAndView();
		
		int thirdValue = firstValue + secondValue;
		
		// session.setAttribute("thirdValue", thirdValue);
	//	mv.addObject("thirdValue", thirdValue);
//		mv.setViewName("result");
	m.addAttribute("thirdValue", thirdValue)	;
		return "result";
	}
}
