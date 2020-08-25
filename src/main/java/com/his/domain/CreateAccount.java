package com.his.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CreateAccount {
	
	private Integer userId;

	private String firstName;
	
	private String lastName;

	private String email;

	private String gender;
	
	private String accountStatus;
	
	private String userRole;
	
	private String userActive;

	private String userPwd;
	
	private Date createdDate;
	
	private Date updatedDate;

}
