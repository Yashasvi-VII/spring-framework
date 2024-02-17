/*
 * adding Request Param to clean the code!
 * we are reducing number of lines as we don't need to assign and pass the objects .
*/

package com.yashasvi.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String add(@RequestParam("Number 1") int firstValue,@RequestParam("Number 2") int secondValue ,HttpSession session)
	{
//		int firstValue = Integer.parseInt(req.getParameter("Number 1"));
//		int secondValue = Integer.parseInt(req.getParameter("Number 2"));
//		
		int thirdValue = firstValue + secondValue;
		
	//	HttpSession session =  req.getSession();
		
		session.setAttribute("thirdValue", thirdValue);
		
		
		return "result.jsp";
	}
}
