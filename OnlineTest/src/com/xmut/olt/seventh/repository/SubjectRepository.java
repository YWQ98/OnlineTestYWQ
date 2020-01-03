package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>,JpaSpecificationExecutor<Subject>{
	public Subject getBysjid(Integer sjid);
	public Subject getBysjname(String sjname);
}
