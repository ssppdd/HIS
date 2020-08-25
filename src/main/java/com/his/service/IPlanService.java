package com.his.service;

import java.util.List;

import com.his.domain.Plan;

public interface IPlanService {
	
	public boolean createPlan(Plan p);
	
	public boolean updatePlan(Plan p);
	
	public boolean deletePlan(Integer pid);
	
	public boolean activatePlan(Integer pid);

	public List<Plan> viewPlan();

	public Plan findById(Integer pid);

}
