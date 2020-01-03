package com.xmut.olt.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xmut.olt.seventh.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin getByaName(String aName) ;
//	Admin getByaId(Integer aId);
}
