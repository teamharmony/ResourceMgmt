package prj.resources.mgmt.services;

import prj.resources.mgmt.domain.User;

//TODO: DAO Exception
//TODO: Change the naming to DAO 
public interface RegistrationService {
	
	/**
	 * Fetches User info from the back-end based on the supplied user name.
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserDetailsByName(String userName);
	
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
	
	/**
	 * updates a user
	 * @param user
	 */
	public void update(User user);

	
	/**
	 * gets Profile picture of a user
	 * @param userName
	 * @return
	 */
	public byte[] getProfilePic(String userName);
	
	/**
	 * updates the password of the user to a new generated one.
	 * @param pwd
	 * @return
	 */
	public void updatePwd(String userName, String pwd);
}
