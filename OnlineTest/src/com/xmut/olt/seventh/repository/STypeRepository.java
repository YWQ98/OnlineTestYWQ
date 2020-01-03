package com.xmut.olt.seventh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.SType;

public interface STypeRepository extends JpaRepository<SType, Integer>,JpaSpecificationExecutor<SType>{
	public SType getBystid(Integer stid);
	
//	@Query("SELECT s FROM SType s;")
//	public List<SType> findAll() ;
	
	
}
