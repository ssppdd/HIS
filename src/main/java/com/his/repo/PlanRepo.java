package com.his.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {

}
