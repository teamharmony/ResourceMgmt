package prj.resources.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import prj.resources.mgmt.domain.Location;
import prj.resources.mgmt.domain.User;
import prj.resources.mgmt.services.RegistrationService;

@Controller
public class ResourceController {

	@Autowired
	RegistrationService registrationService;

	//TODO: Can use the ModelAttribute from Spring to bind the params to the User domain object,
	//TODO: Need a common validator end-point Which can be utilized by both client and mid tier.
	/**
	 * Registers a new user
	 * @param fName
	 * @param mName
	 * @param lName
	 * @param city
	 * @param state
	 * @param country
	 * @param zipCode
	 * @param contact
	 * @param username
	 * @param email
	 * @param password
	 * @param confirmPass
	 * @param profilPic
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String registerNewUser(
			@RequestParam(required = true, value = "fName") String fName,
			@RequestParam(required = true, value = "mName") String mName,
			@RequestParam(required = true, value = "lName") String lName,
			@RequestParam(required = true, value = "city") String city,
			@RequestParam(required = true, value = "state") String state,
			@RequestParam(required = true, value = "country") String country,
			@RequestParam(required = true, value = "zipCode") String zipCode,
			@RequestParam(required = true, value = "contact") String contact,
			@RequestParam(required = true, value = "username") String username,
			@RequestParam(required = true, value = "email") String email,
			@RequestParam(required = true, value = "password") String password,
			@RequestParam(required = true, value = "confirmPass") String confirmPass,
			@RequestParam(required = false, value = "profilePic") MultipartFile profilPic
	) {
		User user = new User();
		Location loc = new Location();
		user.setLocation(loc);
		try {
			registrationService.register(user);
		} catch (Exception e) {
			// TODO: handle exception
			return "registration";
		}
		return "redirect:html/login";
	}
	
	/**
	 * Updates the details for a given user
	 * @param username
	 * @param fName
	 * @param mName
	 * @param lName
	 * @param city
	 * @param state
	 * @param country
	 * @param zipCode
	 * @param contact
	 * @param profilPic
	 */
	@RequestMapping(value="/resources/{username}", method = RequestMethod.PUT)
	public void registerNewUser(
			@PathVariable("username") String username,
			@RequestParam(required = true, value = "fName") String fName,
			@RequestParam(required = true, value = "mName") String mName,
			@RequestParam(required = true, value = "lName") String lName,
			@RequestParam(required = true, value = "city") String city,
			@RequestParam(required = true, value = "state") String state,
			@RequestParam(required = true, value = "country") String country,
			@RequestParam(required = true, value = "zipCode") String zipCode,
			@RequestParam(required = true, value = "contact") String contact,
			@RequestParam(required = false, value = "profilePic") MultipartFile profilPic
	) {
		
		//TODO
	}

}
