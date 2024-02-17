/*
 * Concept of model and view 
 * 
 * we can remove the HttpSession using model and view
 * 
 * model will have data thirdValue is the data so we just need to put this value in model object and also we need to specify the view 
 * here view is result.jsp .
 * 
 * we have inbuilt class model and view 
 * 
 * instead of returning the string we can return the mv and we need to change the return type to model and view 
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
		mv.setViewName("result.jsp");
		
		return mv;
	}
}
