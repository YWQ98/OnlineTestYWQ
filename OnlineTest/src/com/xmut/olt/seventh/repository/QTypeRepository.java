package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.QType;

public interface QTypeRepository extends JpaRepository<QType, Integer>,JpaSpecificationExecutor<QType>{
	public QType getByqtid(Integer qtid);
}
