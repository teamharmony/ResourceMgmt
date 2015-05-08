package prj.resources.mgmt.services;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;


import org.springframework.jdbc.support.lob.DefaultLobHandler;

import prj.resources.mgmt.domain.Location;
import prj.resources.mgmt.domain.User;


public class RegistrationServiceImpl implements RegistrationService {
	
	private DataSource dataSource;
	   
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Fetches User info from the back-end based on the supplied user name.
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserDetailsByName(String userName) {
		SimpleJdbcCall getUserDetailsJdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("getUserDetails");
	     
		SqlParameterSource in = new MapSqlParameterSource().addValue("_username", userName);
		Map<String, Object> out = getUserDetailsJdbcCall.execute(in);

		User user = new User();
		user.setUsername(userName);
		user.setfName((String) out.get("_fname"));
		user.setmName((String) out.get("_mname"));
		user.setlName((String) out.get("_lname"));
		user.setEmail((String) out.get("_email"));
		user.setContact((String) out.get("_contact"));
		Location loc = new Location();
		loc.setCountry((String) out.get("_country"));
		loc.setCity((String) out.get("_city"));
		loc.setState((String) out.get("_province"));
		loc.setZip((String) out.get("_zip"));
		user.setLocation(loc);
		return user;
	}
	
	/**
	 * Fetches the Email id of the user based on the supplied user name.
	 * 
	 * @param userName
	 * @return
	 */
	public String getEmailByName(String userName) {
		User user = getUserDetailsByName(userName);
		return user.getEmail();
	}
	
	/**
	 * Registers a user in the database.
	 * 
	 * @param user
	 */
	public void register(User user) {
		SimpleJdbcCall registerJdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("registerUser");
		
		Map<String, Object> inputData = new HashMap<String, Object>();
		
		inputData.put("_username", user.getUsername());
		inputData.put("_pwd", user.getPassword());
		inputData.put("_authority", "ROLE_USER");
		inputData.put("_fName", user.getfName());
		inputData.put("_mName", user.getmName());
		inputData.put("_lName", user.getlName());
		inputData.put("_email", user.getEmail());
		inputData.put("_country", user.getLocation().getCountry());
		inputData.put("_province", user.getLocation().getState());
		inputData.put("_city", user.getLocation().getCity());
		inputData.put("_zip", user.getLocation().getZip());
		inputData.put("_contact", user.getContact());
		inputData.put("_profilePic", user.getProfilePic());
		
		
	    SqlParameterSource in = new MapSqlParameterSource().addValues(inputData);
	    registerJdbcCall.execute(in);

	}
	
	/**
	 * Registers a user in the database.
	 * 
	 * @param user
	 */
	public void update(User user) {
		SimpleJdbcCall updateJdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("updateUser");
		
		Map<String, Object> inputData = new HashMap<String, Object>();
		inputData.put("_username", user.getUsername());
		inputData.put("_fName", user.getfName());
		inputData.put("_mName", user.getmName());
		inputData.put("_lName", user.getlName());
		inputData.put("_email", user.getEmail());
		inputData.put("_country", user.getLocation().getCountry());
		inputData.put("_province", user.getLocation().getState());
		inputData.put("_city", user.getLocation().getCity());
		inputData.put("_zip", user.getLocation().getZip());
		inputData.put("_contact", user.getContact());
		inputData.put("_profilePic", user.getProfilePic());
		
		
	    SqlParameterSource in = new MapSqlParameterSource().addValues(inputData);
	    updateJdbcCall.execute(in);		
		
	}

	
	public byte[] getProfilePic(String userName) {
		SimpleJdbcCall getUserDetailsJdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("getUserProfilePic");
	     
		SqlParameterSource in = new MapSqlParameterSource().addValue("_username", userName);
		Map<String, Object> out = getUserDetailsJdbcCall.execute(in);

		return (byte[])out.get("_profilepic");
	}
	
	
	
	public void updatePwd(String userName, String pwd) {
		SimpleJdbcCall updatePasswordJdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("updatePassword");
		
		Map<String, Object> inputData = new HashMap<String, Object>();
		inputData.put("_username", userName);
		inputData.put("_pwd", pwd);
		
	    SqlParameterSource in = new MapSqlParameterSource().addValues(inputData);
	    updatePasswordJdbcCall.execute(in);			
	}

}
