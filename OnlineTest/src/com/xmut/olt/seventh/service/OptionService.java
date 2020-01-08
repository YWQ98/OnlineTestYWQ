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

import com.xmut.olt.seventh.entity.Option;
import com.xmut.olt.seventh.entity.QItem;
import com.xmut.olt.seventh.repository.OptionRepository;

@Service
public class OptionService {

	@Autowired
	private OptionRepository optionRepository;
	
	@Transactional
	public Option save(Option option) 
	{
		return  optionRepository.save(option);
	}
	
	@Transactional(readOnly=true)
	public Page<Option> finqItem(final QItem qItem)
	{
		PageRequest pageRequest=new PageRequest(0, 9999);
		Specification<Option> specification=new Specification<Option>() {
			
			@Override
			public Predicate toPredicate(Root<Option> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				Path<String> path=arg0.get("qItem");
				return arg2.equal(path, qItem);
			}
		};
		return optionRepository.findAll(specification, pageRequest);
	}

}
