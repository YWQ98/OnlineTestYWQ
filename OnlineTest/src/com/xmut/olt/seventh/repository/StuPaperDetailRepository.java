package com.xmut.olt.seventh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.StuPaper;
import com.xmut.olt.seventh.entity.StuPaperDetail;

public interface StuPaperDetailRepository extends JpaRepository<StuPaperDetail, Integer>,JpaSpecificationExecutor<StuPaperDetail>{
	public StuPaperDetail getByspdid(Integer spdid);
	public List<StuPaperDetail> getBystuPaper(StuPaper paper);
}
