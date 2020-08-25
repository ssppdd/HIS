package com.his.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.his.entity.CreateAccountEntity;

public interface CreateAccRepo extends JpaRepository<CreateAccountEntity, Integer> {

	CreateAccountEntity findByEmail(String email);

	List<CreateAccountEntity> findByUserRole(String role);
	


}
