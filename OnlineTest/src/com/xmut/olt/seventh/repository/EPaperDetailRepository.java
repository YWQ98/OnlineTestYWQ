package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.EPaperDetail;

public interface EPaperDetailRepository extends JpaRepository<EPaperDetail, Integer>,JpaSpecificationExecutor<EPaperDetail>{
	
	public EPaperDetail getByedid(String edid);

}
