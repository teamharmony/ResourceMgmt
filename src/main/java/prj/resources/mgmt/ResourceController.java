package prj.resources.mgmt;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import prj.resources.mgmt.domain.Location;
import prj.resources.mgmt.domain.User;
import prj.resources.mgmt.services.RegistrationService;


@RequestMapping("/resources")
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
			@RequestParam(required = false, value = "confirmPass") String confirmPass,
			@RequestParam(required = false, value = "profilePic") MultipartFile profilePic) {
	
		try {
			//TODO: USE Builder pattern later
			User user = new User();
			user.setfName(fName);
			user.setmName(mName);
			user.setlName(lName);
			user.setContact(contact);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
			Location loc = new Location();
			loc.setCountry(country);
			loc.setCity(city);
			loc.setState(state);
			loc.setZip(zipCode);
			user.setLocation(loc);
			
			if(profilePic != null && !profilePic.isEmpty()) {
				user.setProfilePic(profilePic.getBytes());
			}
			registrationService.register(user);
		} catch (Exception e) {
			// TODO: handle exception
			//Add individual attributes so that the fields appear pre-populated incase of an exception. 
			
			return "registration";
		}
		
		return "redirect:html/login";
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public String defaultGet() {
		return "/registration";
		
	}
	
	
	@RequestMapping(value="/{username:.+}", method = RequestMethod.GET)
	public String getUser(@PathVariable("username") String username, Model model) {
		User user = registrationService.getUserDetailsByName(username);
		model.addAttribute("user", user);
		return "edit";
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
	//TODO: Should have been PUT but since HTML forms only support POST/GET we have no alternative
	@RequestMapping(value="/{username}", method = RequestMethod.POST)
	public String updateUser(
			@PathVariable("username") String username,
			@RequestParam(required = true, value = "fName") String fName,
			@RequestParam(required = true, value = "mName") String mName,
			@RequestParam(required = true, value = "lName") String lName,
			@RequestParam(required = true, value = "city") String city,
			@RequestParam(required = true, value = "state") String state,
			@RequestParam(required = true, value = "country") String country,
			@RequestParam(required = true, value = "zipCode") String zipCode,
			@RequestParam(required = false, value = "email") String email,
			@RequestParam(required = true, value = "contact") String contact,
			@RequestParam(required = false, value = "profilePic") MultipartFile profilePic
	) {
		
		try {
			//TODO: USE Builder pattern later
			User user = new User();
			user.setfName(fName);
			user.setmName(mName);
			user.setlName(lName);
			user.setContact(contact);
			user.setEmail(email);
			Location loc = new Location();
			loc.setCountry(country);
			loc.setCity(city);
			loc.setState(state);
			loc.setZip(zipCode);
			user.setLocation(loc);
			
			if(profilePic != null && !profilePic.isEmpty()) {
				user.setProfilePic(profilePic.getBytes());
			}
			user.setUsername(username);
			registrationService.update(user);
		} catch (Exception e) {
			// TODO: handle exception
			//return "hello";
		}
		return "redirect:/html/home";
		

	}
	
	
	@ResponseBody
	@RequestMapping(value="/{userName}/profilePic", method=RequestMethod.GET)
	public byte[] getProfilePic(@PathVariable("userName")String userName, HttpServletResponse response){
		return registrationService.getProfilePic(userName);
		
	}
	

}
