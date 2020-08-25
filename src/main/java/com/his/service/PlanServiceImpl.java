package com.his.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.domain.Plan;
import com.his.entity.PlanEntity;
import com.his.repo.PlanRepo;
@Service
public class PlanServiceImpl implements IPlanService {
	
	@Autowired
	PlanRepo repo;

	@Override
	public boolean createPlan(Plan p) {
		PlanEntity pe=new PlanEntity();
		p.setPlanActive("true");
		BeanUtils.copyProperties(p, pe);
		PlanEntity pe1=repo.save(pe);
		if(pe1 != null) {
		return true;
		}else return false;
	}

	@Override
	public boolean updatePlan(Plan p) {
		PlanEntity pe=repo.findById(p.getPlanId()).get();
		pe.setPlanName(p.getPlanName());
		pe.setPlanDesc(p.getPlanDesc());
		pe.setStartDate(p.getStartDate());
		pe.setEndDate(p.getEndDate());
		PlanEntity pe1=repo.save(pe);
		if(pe1 != null) {
		return true;
	
		}else return false;
	}	

	@Override
	public boolean deletePlan(Integer pid) {
		PlanEntity pe = repo.findById(pid).get();
		pe.setPlanActive("false");
		PlanEntity pe1=repo.save(pe);
		if(pe1 != null) {
		return true;
	
		}else return false;
	
	}

	@Override
	public boolean activatePlan(Integer pid) {
		PlanEntity pe = repo.findById(pid).get();
		pe.setPlanActive("true");
		PlanEntity pe1=repo.save(pe);
		if(pe1 != null) {
		return true;
	
		}else return false;
	}

	@Override
	public List<Plan> viewPlan() {
		List<PlanEntity> pe = repo.findAll(); 
		return pe.stream().map(entity -> {
			Plan p = new Plan();
			BeanUtils.copyProperties(entity, p);
			return p;
		}).collect(Collectors.toList());
	
	}

	@Override
	public Plan findById(Integer pid) {
	    PlanEntity pe = repo.findById(pid).get();
	    Plan p = new Plan();
	    BeanUtils.copyProperties(pe, p);
		return p;
	}

}
