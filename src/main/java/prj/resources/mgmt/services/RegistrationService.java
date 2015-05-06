package prj.resources.mgmt.services;

import prj.resources.mgmt.domain.User;

public interface RegistrationService {
	
	/**
	 * Fetches User info from the back-end based on the supplied user name.
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByName(String userName);
	
	/**
	 * Fetches the Email id of the user based on the supplied user name.
	 * 
	 * @param userName
	 * @return
	 */
	public String getEmailByName(String userName);
	
	/**
	 * Registers a user in the database.
	 * 
	 * @param user
	 */
	public void register(User user);

}
