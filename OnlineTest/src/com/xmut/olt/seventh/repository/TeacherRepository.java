package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>,JpaSpecificationExecutor<Teacher>{
	Teacher getBytNum(String tNum);
}
