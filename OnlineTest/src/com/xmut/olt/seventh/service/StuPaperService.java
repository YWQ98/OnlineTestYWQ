package com.xmut.olt.seventh.service;

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

import com.xmut.olt.seventh.entity.EPaper;
import com.xmut.olt.seventh.entity.StuPaper;
import com.xmut.olt.seventh.entity.Student;
import com.xmut.olt.seventh.repository.StuPaperRepository;

@Service
public class StuPaperService {

	@Autowired
	private StuPaperRepository stuPaperRepository;
	public StuPaper save(StuPaper stuPaper) 
	{
		return stuPaperRepository.saveAndFlush(stuPaper);
	}
	
	@Transactional(readOnly=true)
	public Page<StuPaper> finAllStuPaper(final EPaper ePaper){
		PageRequest pageRequest=new PageRequest(0, 9999);
		Specification<StuPaper> specification=new Specification<StuPaper>() {
			
			@Override
			public Predicate toPredicate(Root<StuPaper> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				Path<String> path=arg0.get("ePaper");
				return arg2.equal(path, ePaper);
			}
		};
		return stuPaperRepository.findAll(specification, pageRequest);
	}
	@Modifying
	@Transactional
	public boolean deleteStuPaper(Integer spid) 
	{
		boolean b=false;
		if(spid!=null) {
			stuPaperRepository.delete(spid);
			b=true;
		}
		return b;
	}
	
	@Transactional(readOnly=true)
	public Page<StuPaper> finAll(final Student student) 
	{
		PageRequest pageRequest=new PageRequest(0, 9999);
		Specification<StuPaper> specification=new Specification<StuPaper>() {
			
			@Override
			public Predicate toPredicate(Root<StuPaper> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				Path<String> path=arg0.get("student");
				return arg2.equal(path, student);
			}
		};
		return stuPaperRepository.findAll(specification, pageRequest);
	}
	@Transactional(readOnly=true)
	public StuPaper getByspid(Integer spid) 
	{
		return stuPaperRepository.getByspid(spid);
	}

}
