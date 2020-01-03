package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>,JpaSpecificationExecutor<Student>{
	Student getBysNum(String sNum);
	Student getBysName(String sName);
}
