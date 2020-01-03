package com.xmut.olt.seventh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xmut.olt.seventh.entity.QItem;

public interface QItemRepository extends JpaRepository<QItem, Integer>,JpaSpecificationExecutor<QItem>{
	public QItem getByqiid(Integer qiid);
}
