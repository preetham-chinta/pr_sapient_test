package com.apps.preetham.api.users.shared;

import java.io.Serializable; 
import java.util.List;
import com.apps.preetham.api.users.ui.model.TheatreResponseModel;
 
public class UserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -953297098295050686L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userId;
	private String roleName;
	private String encryptedPassword;
	private List<TheatreResponseModel> theatres;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public List<TheatreResponseModel> getTheatres() {
		return theatres;
	}
	public void setTheatres(List<TheatreResponseModel> theatres) {
		this.theatres = theatres;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
