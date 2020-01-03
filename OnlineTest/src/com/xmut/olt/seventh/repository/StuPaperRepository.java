package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.StuPaper;

public interface StuPaperRepository extends JpaRepository<StuPaper, Integer>,JpaSpecificationExecutor<StuPaper>{
	public StuPaper getByspid(Integer spid);
}
