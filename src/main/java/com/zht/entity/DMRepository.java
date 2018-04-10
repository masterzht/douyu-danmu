package com.zht.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DMRepository extends JpaRepository<DanMuInfo,Integer> {

    DanMuInfo findTopByOrderByIdDesc();

}
