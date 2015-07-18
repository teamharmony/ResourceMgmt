package prj.resources.mgmt.domain;

public class User {
	
	private String name;
	private String contact;
	private String username;
	private String email;
	private String skills;
	private String password;
	private byte[] profilePic;
	private int visible;
	
	
	
	public int getVisible() {
		return visible;
	}

	public String getName() {
		return name;
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

	
	public User(String name, String contact,
			String username, String email, String skills, String password,
			byte[] profilePic, Location location, int visible) {
		super();
		this.name = name;
		this.contact = contact;
		this.username = username;
		this.email = email;
		this.skills = skills;
		this.password = password;
		this.profilePic = profilePic;
		this.visible = visible;
	}
	
	private User(UserBuilder builder) {
		this.name = builder.name;
		this.contact = builder.contact;
		this.username = builder.username;
		this.email = builder.email;
		this.skills = builder.skills;
		this.password = builder.password;
		this.profilePic = builder.profilePic;
		this.visible = builder.visible;
	}
	
	public static class UserBuilder {
		private String name;
		private String contact;
		private String username;
		private String email;
		private String skills;
		private String password;
		private byte[] profilePic;
		private int visible;
		
		public UserBuilder name(String name) {
			this.name = name;
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
			//skills = skills.replace(",", " ");
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
		
		public UserBuilder visible(int visible) {
			this.visible = visible;
			return this;
		}
		
		public User build() {
			User u = new User(this);
			return u;
		}
		
	}
		

}
