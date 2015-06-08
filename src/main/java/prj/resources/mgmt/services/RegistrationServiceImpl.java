package prj.resources.mgmt.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import prj.resources.mgmt.domain.Location;
import prj.resources.mgmt.domain.ResourceError;
import prj.resources.mgmt.domain.User;

//TODO: Implement AOP for Logging

public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationServiceImpl.class);

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
		try {
			SimpleJdbcCall getUserDetailsJdbcCall = new SimpleJdbcCall(
					dataSource).withProcedureName("getUserDetails");

			SqlParameterSource in = new MapSqlParameterSource().addValue(
					"_username", userName);
			Map<String, Object> out = getUserDetailsJdbcCall.execute(in);

			Location loc = new Location();
			loc.setCountry((String) out.get("_country"));
			loc.setCity((String) out.get("_city"));
			loc.setState((String) out.get("_province"));
			loc.setZip((String) out.get("_zip"));

			User user = new User.UserBuilder().userName(userName)
					.fName((String) out.get("_fname"))
					.mName((String) out.get("_mname"))
					.lName((String) out.get("_lname"))
					.email((String) out.get("_email"))
					.skills((String) out.get("_skill"))
					.contact((String) out.get("_contact")).location(loc)
					.build();

			return user;
		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}
	}

	/**
	 * Fetches the Email id of the user based on the supplied user name.
	 * 
	 * @param userName
	 * @return
	 */
	public String getEmailByName(String userName) {
		try {
			User user = getUserDetailsByName(userName);
			return user.getEmail();
		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}
	}

	/**
	 * Registers a user in the database.
	 * 
	 * @param user
	 */
	public void register(User user) {
		try {
			SimpleJdbcCall registerJdbcCall = new SimpleJdbcCall(dataSource)
					.withProcedureName("registerUser");

			Map<String, Object> inputData = new HashMap<String, Object>();

			inputData.put("_username", user.getUsername());
			inputData.put("_pwd", user.getPassword());
			inputData.put("_authority", "ROLE_USER");
			inputData.put("_fName", user.getfName());
			inputData.put("_mName", user.getmName());
			inputData.put("_lName", user.getlName());
			inputData.put("_email", user.getEmail());
			inputData.put("_skill", user.getSkills());
			inputData.put("_country", user.getLocation().getCountry());
			inputData.put("_province", user.getLocation().getState());
			inputData.put("_city", user.getLocation().getCity());
			inputData.put("_zip", user.getLocation().getZip());
			inputData.put("_contact", user.getContact());
			inputData.put("_profilePic", user.getProfilePic());

			SqlParameterSource in = new MapSqlParameterSource()
					.addValues(inputData);
			registerJdbcCall.execute(in);
		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}

	}

	/**
	 * Registers a user in the database.
	 * 
	 * @param user
	 */
	public void update(User user) {
		try {
			SimpleJdbcCall updateJdbcCall = new SimpleJdbcCall(dataSource)
					.withProcedureName("updateUser");

			Map<String, Object> inputData = new HashMap<String, Object>();
			inputData.put("_username", user.getUsername());
			inputData.put("_fName", user.getfName());
			inputData.put("_mName", user.getmName());
			inputData.put("_lName", user.getlName());
			inputData.put("_email", user.getEmail());
			inputData.put("_skill", user.getSkills());
			inputData.put("_country", user.getLocation().getCountry());
			inputData.put("_province", user.getLocation().getState());
			inputData.put("_city", user.getLocation().getCity());
			inputData.put("_zip", user.getLocation().getZip());
			inputData.put("_contact", user.getContact());
			inputData.put("_profilePic", user.getProfilePic());

			SqlParameterSource in = new MapSqlParameterSource()
					.addValues(inputData);
			updateJdbcCall.execute(in);
		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}
	}

	public byte[] getProfilePic(String userName) {
		try {
			SimpleJdbcCall getUserDetailsJdbcCall = new SimpleJdbcCall(
					dataSource).withProcedureName("getUserProfilePic");

			SqlParameterSource in = new MapSqlParameterSource().addValue(
					"_username", userName);
			Map<String, Object> out = getUserDetailsJdbcCall.execute(in);

			return (byte[]) out.get("_profilepic");
		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}
	}

	public void updatePwd(String userName, String pwd, int reset) {
		try {
			SimpleJdbcCall updatePasswordJdbcCall = new SimpleJdbcCall(
					dataSource).withProcedureName("updatePassword");

			Map<String, Object> inputData = new HashMap<String, Object>();
			inputData.put("_username", userName);
			inputData.put("_pwd", pwd);
			inputData.put("_resetpwd", reset);

			SqlParameterSource in = new MapSqlParameterSource()
					.addValues(inputData);
			updatePasswordJdbcCall.execute(in);

			// TODO: Need to update user status to show reset page

		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}
	}

	public List<User> findUsers(String key, String searchString) {
		String procName = null;
		try {
			if (key.equals("city"))
				procName = "findUserByCity";
			else if (key.equals("skill"))
				procName = "findUserBySkill";

			SimpleJdbcCall findByCity = new SimpleJdbcCall(dataSource)
					.withProcedureName(procName).returningResultSet("rs1",
							new RowMapper<User>() {
								public User mapRow(ResultSet rs, int rowCount)
										throws SQLException {
									Location l = new Location();
									l.setCity(rs.getString("city"));
									l.setCountry(rs.getString("country"));
									l.setState(rs.getString("province"));
									l.setZip(rs.getString("zip"));

									User u = new User.UserBuilder()
											.fName(rs.getString("fName"))
											.mName(rs.getString("mName"))
											.lName(rs.getString("lName"))
											.email(rs.getString("email"))
											.skills(rs.getString("skill"))
											.contact(rs.getString("contact"))
											.location(l)
											.build();

									return u;
								}
							});

			SqlParameterSource in = null;
			if (key.equals("city"))
				in = new MapSqlParameterSource()
						.addValue("_city", searchString);
			else if (key.equals("skill"))
				in = new MapSqlParameterSource().addValue("_skill",
						searchString);

			Map<String, Object> out = findByCity.execute(in);

			return (List<User>) out.get("rs1");

		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}
	}

	// isPwdReset
	public int isPasswordResetNeeded(String userName) {
		try {
			SimpleJdbcCall getUserDetailsJdbcCall = new SimpleJdbcCall(
					dataSource).withProcedureName("isPwdReset");

			SqlParameterSource in = new MapSqlParameterSource().addValue(
					"_username", userName);
			Map<String, Object> out = getUserDetailsJdbcCall.execute(in);
			Integer i = (Integer)out.get("_resetpwd");
			return i == null ? 0: i.intValue();
		} catch (DataAccessException e) {
			SQLException sqe = (SQLException) e.getCause();
			logger.error("Error While invoking "
					+ this.getClass().getEnclosingMethod().getName()
					+ sqe.getSQLState());
			ResourceError re = new ResourceError(e);
			re.setErrorCode(sqe.getErrorCode());
			re.setErrorString(sqe.getSQLState());
			throw re;
		}
	}

}
