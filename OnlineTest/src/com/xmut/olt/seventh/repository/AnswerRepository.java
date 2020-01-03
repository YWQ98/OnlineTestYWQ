package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>,JpaSpecificationExecutor<Answer>{
}
