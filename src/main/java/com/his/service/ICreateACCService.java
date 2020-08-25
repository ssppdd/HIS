package com.his.service;

import java.util.List;

import com.his.domain.CreateAccount;
import com.his.domain.Unlock;

public interface ICreateACCService {
	
	public boolean createAcc(CreateAccount ca);
	
	public String findByEmail(String email);

	public boolean validTempPwd(Unlock unlock);
	
	public List<CreateAccount> viewAccInfo();
	
	public List<CreateAccount> viewAccInfo1(String role);
	
	public CreateAccount getUserById(Integer uid);
	
	public boolean deleteUserById(Integer uid);

	public boolean activateUserById(Integer uid);

	public void updateAcc(CreateAccount ca);

}
