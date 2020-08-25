package com.his.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Plan {
	
	private Integer planId;
	
	private String planName;
	
	private String planDesc;
	
	private String planActive;
	
	private String startDate;
	
	private String endDate;
	
	private Date createdDate;
	
	private Date updatedDate;

}
