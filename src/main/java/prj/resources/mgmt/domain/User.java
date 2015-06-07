package prj.resources.mgmt.domain;

public class User {
	
	private String fName;
	private String lName;
	private String mName;
	private String contact;
	private String username;
	private String email;
	private String skills;
	private String password;
	private byte[] profilePic;
	private Location location;
	
	
	
	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getmName() {
		return mName;
	}

	public String getContact() {
		return contact;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getSkills() {
		return skills;
	}

	public String getPassword() {
		return password;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}

	public Location getLocation() {
		return location;
	}

	public User(String fName, String lName, String mName, String contact,
			String username, String email, String skills, String password,
			byte[] profilePic, Location location) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.mName = mName;
		this.contact = contact;
		this.username = username;
		this.email = email;
		this.skills = skills;
		this.password = password;
		this.profilePic = profilePic;
		this.location = location;
	}
	
	private User(UserBuilder builder) {
		this.fName = builder.fName;
		this.lName = builder.lName;
		this.mName = builder.mName;
		this.contact = builder.contact;
		this.username = builder.username;
		this.email = builder.email;
		this.skills = builder.skills;
		this.password = builder.password;
		this.profilePic = builder.profilePic;
		this.location = builder.location;
	}
	
	public static class UserBuilder {
		private String fName;
		private String lName;
		private String mName;
		private String contact;
		private String username;
		private String email;
		private String skills;
		private String password;
		private byte[] profilePic;
		private Location location;
		
		public UserBuilder fName(String fName) {
			this.fName = fName;
			return this;
		}
		
		public UserBuilder mName(String mName) {
			this.mName = mName;
			return this;
		}

		public UserBuilder lName(String lName) {
			this.lName = lName;
			return this;
		}

		public UserBuilder contact(String contact) {
			this.contact = contact;
			return this;
		}

		public UserBuilder userName(String userName) {
			this.username = userName;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder skills(String skills) {
			this.skills = skills;
			return this;
		}

		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public UserBuilder profilePic(byte[] profilePic) {
			this.profilePic = profilePic;
			return this;
		}
		
		public UserBuilder location(Location location) {
			this.location = location;
			return this;
		}
		
		public User build() {
			User u = new User(this);
			return u;
		}
		
	}
		

}
