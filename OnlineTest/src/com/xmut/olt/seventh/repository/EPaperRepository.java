package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.EPaper;

public interface EPaperRepository extends JpaRepository<EPaper, Integer>,JpaSpecificationExecutor<EPaper>{

	public EPaper getByename(String ename);
	public EPaper getByeid(Integer eid);
	
}
