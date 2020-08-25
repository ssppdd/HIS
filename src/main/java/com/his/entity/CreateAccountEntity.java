package com.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_ACCOUNT")
public class CreateAccountEntity {
	@GeneratedValue
	@Id
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(length = 20, name = "FIRST_NAME")
	private String firstName;
	
	@Column(length = 20, name = "LAST_NAME")
	private String lastName;

	@Column(length = 50, name = "EMAIL")
	private String email;
	
	@Column(length = 20, name = "GENDER")
	private String gender;
	
	@Column(name = "USER_ROLE")
	private String userRole;

	@Column(name = "USER_ACTIVE")
	private String userActive;
	
	@Column(name = "ACC_STATUS")
	private String accountStatus;

	@Column(name = "USER_PWD")
	private String userPwd;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable=false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable=false)
	private Date updatedDate;

}
