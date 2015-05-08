package prj.resources.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import prj.resources.mgmt.services.RegistrationService;

@RequestMapping("/resendPassword")
@Controller
public class PasswordGenerationController {
	@Autowired
	RegistrationService registrationService;
		
	@RequestMapping(method = RequestMethod.POST)
	public String resendPassword(@RequestParam("username") String username) {
		String email = registrationService.getEmailByName(username);
		
		//TODO: Need an algorithm to generate the pwd.
		String newPassword = "changeIt123";
		
		registrationService.updatePwd(username, newPassword);
		
		//Send an email through Spring EMAIL 
		
		return "redirect:html/login";
	}
}
