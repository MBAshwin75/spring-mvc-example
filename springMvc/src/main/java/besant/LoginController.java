package besant;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	
	public String showLoginPage( ) {
		logger.info("Ashwin : message: i am inside login metho");
	
	return "login";
	}
	
@RequestMapping(value = "/login", method = RequestMethod.POST)
	
	public String validateLogin(ModelMap model,@RequestParam String name,
			@RequestParam String password ) {
	logger.info("Ashwin : message: i am inside login method that is post i am calling login serive using autowired spring depency injection");
	if(loginService.validateUser(name, password))
	return "welcome";
	else
	{
		model.put("errorMessage", "Invalid Credentials");

	return "login";
	}		
	}
	
	
	
	
@RequestMapping(value = "/ourOwn", method = RequestMethod.GET)
	
	public String OurOwnPage() {
		return "ourOwn";
	}
	
@RequestMapping(value = "/ourOwn2", method = RequestMethod.GET)

public String OurOwnPage2() {
	return "ourOwn2";
}
	
	
	
}

