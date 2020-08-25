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
@Table(name = "PLAN_DETAILS")
public class PlanEntity {
	
	@GeneratedValue
	@Id
	@Column(name = "PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_DESC")
	private String planDesc;
	
	@Column(name = "PLAN_ACTIVE")
	private String planActive;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable=false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable=false)
	private Date updatedDate;

}
