package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Integer>,JpaSpecificationExecutor<Option>{

}
