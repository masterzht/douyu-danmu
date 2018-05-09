package com.zht.dao.repository;

import com.zht.dao.entity.DanmuInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanmuRepository extends JpaRepository<DanmuInfo,Integer> {

    DanmuInfo findTopByOrderByIdDesc();

}
