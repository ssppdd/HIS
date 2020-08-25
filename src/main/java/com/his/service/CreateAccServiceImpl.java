package com.his.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.constant.Constants;
import com.his.domain.CreateAccount;
import com.his.domain.Unlock;
import com.his.entity.CreateAccountEntity;
import com.his.repo.CreateAccRepo;
import com.his.util.EmailUtils;
import com.his.util.PwdUtils;

@Service
public class CreateAccServiceImpl implements ICreateACCService {
	
	@Autowired
	CreateAccRepo repo;
	
	@Autowired
	EmailUtils eu;

	@Override
	public boolean createAcc(CreateAccount ca) {
		CreateAccountEntity cae=new CreateAccountEntity();
		
		ca.setUserPwd(PwdUtils.genrateTempPwd(Constants.PWD_LEN));
		ca.setAccountStatus(Constants.LOCK_STR);
		ca.setUserActive(Constants.ACTIVE_STR);
		eu.sendEmailNew(ca);
		BeanUtils.copyProperties(ca, cae);
		CreateAccountEntity cae1=repo.save(cae);
		if(cae1 != null) {
			return true;
		}
		return false;
	}

	@Override
	public String findByEmail(String email) {
		CreateAccountEntity re=repo.findByEmail(email);
		if(null!=re) {
			return "Duplicate";
		}
		return "Unique";
	}

	@Override
	public boolean validTempPwd(Unlock unlock) {
		CreateAccountEntity r=repo.findByEmail(unlock.getEmail());
		if(r.getUserPwd().equals(unlock.getTemPwd())) {
			r.setAccountStatus("UNLOCK");
			r.setUserPwd(unlock.getCnfPwd());
			repo.save(r);
			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<CreateAccount> viewAccInfo() {
		
		List<CreateAccountEntity> entities = repo.findAll();
		return entities.stream().map(entity -> {
		CreateAccount acc = new CreateAccount();
		BeanUtils.copyProperties(entity, acc);
		return acc;
	}).collect(Collectors.toList());
	
	}
	@Override
	public List<CreateAccount> viewAccInfo1(String role) {
		List<CreateAccountEntity> entities = repo.findByUserRole(role);
		return entities.stream().map(entity -> {
		CreateAccount acc = new CreateAccount();
		BeanUtils.copyProperties(entity, acc);
		return acc;
	}).collect(Collectors.toList());
	
	}

	@Override
	public CreateAccount getUserById(Integer uid) {
		Optional<CreateAccountEntity> findById=repo.findById(uid);
		if(findById.isPresent()) {
			CreateAccountEntity entity = findById.get();
			CreateAccount ca = new CreateAccount();
			BeanUtils.copyProperties(entity, ca);
			return ca;
		}
		return null;
	}

	@Override
	public boolean deleteUserById(Integer uid) {
		String useractive = "false";
		Optional<CreateAccountEntity> r1=repo.findById(uid);
		CreateAccountEntity r=r1.get();
		r.setUserActive(useractive);
		CreateAccountEntity r2=repo.saveAndFlush(r);
		if(r2.getUserActive().equalsIgnoreCase("false")) {
		return true;
	    }else return false;
	}

	@Override
	public boolean activateUserById(Integer uid) {
		String useractive = "true";
		Optional<CreateAccountEntity> r1=repo.findById(uid);
		CreateAccountEntity r=r1.get();
		r.setUserActive(useractive);
		CreateAccountEntity r2=repo.saveAndFlush(r);
		if(r2.getUserActive().equalsIgnoreCase("true")) {
			return true;
	    }else return false;
	}

	@Override
	public void updateAcc(CreateAccount ca) {
		CreateAccountEntity cae=repo.findById(ca.getUserId()).get();
		cae.setFirstName(ca.getFirstName());
		cae.setLastName(ca.getLastName());
		cae.setEmail(ca.getEmail());
		cae.setGender(ca.getGender());
		cae.setUserRole(ca.getUserRole());
		repo.save(cae);
		
	}	

}
