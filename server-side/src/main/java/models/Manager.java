package models;

public class Manager {
	private int managerId;
	private String managerUsername;
	private String managerPassword;
	
	public Manager(int managerId, String username, String password) {
		super();
		this.managerId = managerId;
		this.managerUsername = username;
		this.managerPassword = password;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerUsername() {
		return managerUsername;
	}

	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	
	
}
