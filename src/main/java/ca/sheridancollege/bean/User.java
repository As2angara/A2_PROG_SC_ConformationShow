package ca.sheridancollege.bean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	//Field Variables
	private long userId;
	private String userName;
	private String encryptedPassword;
	
	//Constructor
	public User(String username, String encryptedPassword) {
		this.userName = username;
		this.encryptedPassword = encryptedPassword;
	}
}
