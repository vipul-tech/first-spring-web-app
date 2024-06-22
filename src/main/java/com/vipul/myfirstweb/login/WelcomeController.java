//package com.vipul.myfirstweb.login;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@Controller
//@SessionAttributes("name")
//public class LoginController {
//	
//	private AuthenticationService authenticationService;
//	
//	public WelcomeController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
//	
////	Logger logger = LoggerFactory.getLogger(getClass());
//	
////	@RequestMapping("/login")
////	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
////		model.put("name", name);
////		System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
////		logger.debug("This is request parameter {}",name);
////		return "login";
////	}
//	
//	
//	@RequestMapping(value="login", method=RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}
//	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, 
//			@RequestParam String password, ModelMap model) {
//		if(authenticationService.authenticate(name, password)) {
//			
//			//Authentication 
//			//name - vipul
//			//password - dummy
//			
//			model.put("name", name);
//			return "welcome";
//		}
//		model.put("errorMessage", "Invalid credentials!, Please try again...");
//		return "login";
//	}
//}

package com.vipul.myfirstweb.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
