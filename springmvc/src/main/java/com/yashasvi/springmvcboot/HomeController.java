/*
 * In servlet when we need to take input from the user we use a special interface 
 * HttpServletRequest using that we can fetch values and HttpServletResponse to send the data.
 * 
 * In servlet we use concept of http session using which we can add this thirdValue in that object and in jsp
 * we can fetch it or we can also use send dispatcher servlet where we can pass the value as "result.jsp?num3="+num3 which is 
 * called as url rewriting
 * 
 * Here we are using Http Session 
 * 
 * in result.jsp we can use java code or use session object to fetch the value or we can use JSTL 
 * 
 * as per JSTL syntax we simply have to use ${name} if it is not working then write isELIgnored="false"
*/

package com.yashasvi.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String add(HttpServletRequest req )
	{
		int firstValue = Integer.parseInt(req.getParameter("Number 1"));
		int secondValue = Integer.parseInt(req.getParameter("Number 2"));
		
		int thirdValue = firstValue + secondValue;
		
		HttpSession session =  req.getSession();
		
		session.setAttribute("thirdValue", thirdValue);
		
		
		return "result.jsp";
	}
}
