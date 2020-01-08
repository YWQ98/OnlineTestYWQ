package com.xmut.olt.seventh.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmut.olt.seventh.entity.StuPaper;
import com.xmut.olt.seventh.entity.StuPaperDetail;
import com.xmut.olt.seventh.repository.StuPaperDetailRepository;

@Service
public class StuPaperDetailService {

	@Autowired
	private StuPaperDetailRepository stuPaperDetailRepository;
	

	@Transactional(readOnly=true)
	public StuPaperDetail getByspdid(Integer spdid) 
	{
		return stuPaperDetailRepository.getByspdid(spdid);
	}
	@Transactional(readOnly=true)
	public List<StuPaperDetail> getBystuPaper(StuPaper spid) 
	{
		return (List<StuPaperDetail>) stuPaperDetailRepository.getBystuPaper(spid);
	}
	@Modifying
	@Transactional
	public Boolean deleteStuPaperDetail(StuPaper spid) //根据外键删除试卷详情表相关字段
	{
		boolean b=false;
		
		if(spid!=null) 
		{
			b=true;
			List<StuPaperDetail> bystuPaper = getBystuPaper(spid);
			for (StuPaperDetail stuPaperDetail : bystuPaper) {
				stuPaperDetailRepository.delete(stuPaperDetail.getSpdid());
			}
		}
		
		return b;
	}
	@Transactional
	public Page<StuPaperDetail> getBystuPaperDetailOne(final StuPaper stuPaper,Integer page) 
	{
		PageRequest pageRequest=new PageRequest(page-1, 999);
		Specification<StuPaperDetail> specification=new Specification<StuPaperDetail>() {
			
			@Override
			public Predicate toPredicate(Root<StuPaperDetail> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				Path<String> path=arg0.get("stuPaper");
				return arg2.equal(path, stuPaper);
			}
		};
		return stuPaperDetailRepository.findAll(specification, pageRequest);
	}
	@Transactional
	public StuPaperDetail save(StuPaperDetail stuPaperDetail) 
	{
		return stuPaperDetailRepository.saveAndFlush(stuPaperDetail);
	}
	@Transactional(readOnly=true)
	public Page<StuPaperDetail> findStuPaper(final StuPaper paper)
	{
		
		PageRequest pageRequest=new PageRequest(0, 9999);
		Specification<StuPaperDetail> specification=new Specification<StuPaperDetail>() {
			
			@Override
			public Predicate toPredicate(Root<StuPaperDetail> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				Path<String> path=arg0.get("stuPaper");
				return arg2.equal(path, paper);
			}
		};
		return stuPaperDetailRepository.findAll(specification, pageRequest);
	}
	
	

}
