package prj.resources.mgmt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import prj.resources.mgmt.domain.Location;
import prj.resources.mgmt.domain.ResourceError;
import prj.resources.mgmt.domain.User;
import prj.resources.mgmt.services.RegistrationService;

@RequestMapping("/resources")
@Controller
public class ResourceController {

	@Autowired
	RegistrationService registrationService;

	// TODO: Need a common validator end-point Which can be utilized by both client and mid tier.

	//Currently we rely on multi-part form data  request and each form element is separated by a boundary.
	//Going forward we can have just 2 parameters in the multi-part request, one representing
	//the user object and the second the associated Image.
	
	/**
	 * Registers a new user
	 * 
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
	public ResponseEntity<?> registerNewUser(
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
			@RequestParam(required = true, value = "skills") String skills,
			@RequestParam(required = true, value = "password") String password,
			@RequestParam(required = false, value = "profilePic") MultipartFile profilePic) {

		try {
			Location l = new Location();
			l.setCity(city);
			l.setCountry(country);
			l.setZip(zipCode);
			l.setState(state);

			User user = new User.UserBuilder()
					.fName(fName)
					.mName(mName)
					.lName(lName)
					.contact(contact)
					.userName(username)
					.location(l)
					.email(email)
					.password(password)
					.profilePic(
							profilePic != null ? profilePic.getBytes() : null)
					.skills(skills).build();
			registrationService.register(user);
		} catch (ResourceError e) {
			return new ResponseEntity<ResourceError>(e, HttpStatus.CONFLICT);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<ResourceError>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	
	/**
	 * Fetches the details of a given user based on the user-name.
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/{username:.+}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(
			@PathVariable("username") String username) {
		try {
			User user = registrationService.getUserDetailsByName(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (ResourceError e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	
	/**
	 * Updates the details for a given user
	 * 
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
	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(
			@PathVariable("username") String username,
			@RequestParam(required = false, value = "fName") String fName,
			@RequestParam(required = false, value = "mName") String mName,
			@RequestParam(required = false, value = "lName") String lName,
			@RequestParam(required = false, value = "city") String city,
			@RequestParam(required = false, value = "state") String state,
			@RequestParam(required = false, value = "country") String country,
			@RequestParam(required = false, value = "zipCode") String zipCode,
			@RequestParam(required = false, value = "skills") String skills,
			@RequestParam(required = false, value = "email") String email,
			@RequestParam(required = false, value = "contact") String contact,
			@RequestParam(required = false, value = "profilePic") MultipartFile profilePic) {

		try {

			Location l = new Location();
			l.setCity(city);
			l.setCountry(country);
			l.setZip(zipCode);
			l.setState(state);

			User user = new User.UserBuilder()
					.fName(fName)
					.mName(mName)
					.lName(lName)
					.contact(contact)
					.userName(username)
					.location(l)
					.email(email)
					.profilePic(
							profilePic != null ? profilePic.getBytes() : null)
					.skills(skills)
					.build();
			
			registrationService.update(user);
		} catch (ResourceError e) {
			e.printStackTrace();
			return new ResponseEntity<ResourceError>(HttpStatus.CONFLICT);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Get the binary data of the profile Picture representing a given user.
	 * @param userName
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{userName}/profilePic", method = RequestMethod.GET)
	public byte[] getProfilePic(@PathVariable("userName") String userName,
			HttpServletResponse response) {
		return registrationService.getProfilePic(userName);
	}
	
	
	/**
	 * find by either city or skill.
	 * @param key
	 * @param searchString
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find(
			@RequestParam(required = true, value = "searchKey") String key,
			@RequestParam(required = true, value = "searchString") String searchString
			) {
		try {
			List<User> users = registrationService.findUsers(key, searchString);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (ResourceError e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} 
	}
	
	

}
