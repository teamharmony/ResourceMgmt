package prj.resources.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prj.resources.mgmt.services.RegistrationService;


@RequestMapping("/resources")
@Controller
public class ResourceController {
	
	@Autowired
	RegistrationService registrationService;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public String getMessage(Model model) {
		model.addAttribute("message", "Hello world!!");
		return "showMessage";
	}

}
