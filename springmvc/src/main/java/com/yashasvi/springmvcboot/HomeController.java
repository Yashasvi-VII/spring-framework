/*
 * we need to perform certain operations when we call this controller. 
 * operations mean method 
 * 
 * whenever user request for the home page then we have to call this 
 * method we specify that with the help of annotations RequestMapping.In bracket we specify the path.
 * 
 *To call JSP page , in servlet we use to create servlet dispatcher using which we used to call the JSP
 *but here we simply have to return the name of the JSP.   
 *
 *Home controller is called by dispatcher servlet so its job of the dispatcher servlet to call the actual page.
 *so we just need to inform which page we need to call
*/

package com.yashasvi.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String Home() {
		return "index.jsp";
		//System.out.println("Home page requested!");
	}
}
