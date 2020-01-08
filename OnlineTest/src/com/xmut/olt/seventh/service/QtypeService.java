package com.xmut.olt.seventh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmut.olt.seventh.entity.QType;
import com.xmut.olt.seventh.repository.QTypeRepository;

@Service
public class QtypeService {

	@Autowired
	private QTypeRepository qTypeRepository;
	
	@Transactional
	public Object sava(QType qType) 
	{
		return qTypeRepository.saveAndFlush(qType);
	}
	@Transactional(readOnly=true)
	public QType getByqitd(Integer qtid) 
	{
		return qTypeRepository.getByqtid(qtid);
	}
	
	@Transactional(readOnly=true)
	public List<QType> findAll()
	{
		return qTypeRepository.findAll();
	}

}
