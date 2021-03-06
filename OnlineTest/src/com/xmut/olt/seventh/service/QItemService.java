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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmut.olt.seventh.entity.QItem;
import com.xmut.olt.seventh.entity.SType;
import com.xmut.olt.seventh.repository.QItemRepository;

@Service
public class QItemService {

	@Autowired
	private QItemRepository qItemRepository;
	@Transactional(readOnly=true)
	public long count() {
		return qItemRepository.count();
	}
	@Transactional
	public QItem save(QItem qitem) 
	{
		return qItemRepository.save(qitem);
	}
	@Transactional(readOnly=true)
	public QItem getByqiid(Integer qiid) 
	{
		return qItemRepository.getByqiid(qiid);
	}
	
	@Transactional(readOnly=true)
	public Page<QItem> getBySType(final SType sType)
	{
		PageRequest pageRequest=new PageRequest(0, 9999);
		Specification<QItem> specification=new Specification<QItem>() {
			
			@Override
			public Predicate toPredicate(Root<QItem> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				Path<SType> theme =arg0.get("sType");
				return arg2.equal(theme, sType);
			}
		};
		return qItemRepository.findAll(specification, pageRequest);
	}
	
	@Transactional(readOnly=true)
	public Page<QItem> getBySType(final SType sType,Integer page)
	{
		PageRequest pageRequest=new PageRequest(page-1, 3);
		Specification<QItem> specification=new Specification<QItem>() {
			
			@Override
			public Predicate toPredicate(Root<QItem> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				Path<SType> theme =arg0.get("sType");
				return arg2.equal(theme, sType);
			}
		};
		return qItemRepository.findAll(specification, pageRequest);
	}
	
	
}
