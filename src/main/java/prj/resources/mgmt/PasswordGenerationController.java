package prj.resources.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import prj.resources.mgmt.domain.ResourceError;
import prj.resources.mgmt.domain.User;
import prj.resources.mgmt.services.MailNotifier;
import prj.resources.mgmt.services.RandomGenerator;
import prj.resources.mgmt.services.RegistrationService;

@RequestMapping("/password")
@Controller
public class PasswordGenerationController {

	@Autowired
	RegistrationService registrationService;

	@Autowired
	MailNotifier mailNotifier;

	@Autowired
	RandomGenerator pwdGenerator;

	/**
	 * sets a temporary password for the user and sends an email.
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.PUT)
	public ResponseEntity<?> forgotPassword(	@RequestBody MultiValueMap<String,String> body) {
		try {
			String email = registrationService.getEmailByName(body.getFirst("username"));

			String newPassword = pwdGenerator.generatePwd();
			registrationService.updatePwd(body.getFirst("username"), newPassword, 1);

			mailNotifier.sendPasswordInEmail(email, newPassword);
		} catch (ResourceError e) {
			return new ResponseEntity<ResourceError>(e, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	/**
	 * resets the user's password. This functionality is activated post re-login after after forgot password.
	 * @param username
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.PUT)
	public ResponseEntity<?> resetPassword(@RequestBody MultiValueMap<String,String> body) {
		try {
			registrationService.updatePwd(body.getFirst("username"), body.getFirst("password"), 0);
		} catch (ResourceError e) {
			return new ResponseEntity<ResourceError>(e, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	/**
	 * Is used to determine if the user's password needs to be reset.
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ResponseEntity<?> isResetNeeded(	@RequestParam String username) {
		int reset = 0;
		try {
			reset = registrationService.isPasswordResetNeeded(username);
		} catch (ResourceError e) {
			return new ResponseEntity<ResourceError>(e, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(Integer.valueOf(reset), HttpStatus.OK);
	}

}
