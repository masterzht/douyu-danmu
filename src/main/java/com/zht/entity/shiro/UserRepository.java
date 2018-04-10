package com.zht.entity.shiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by masterzht on 2018/4/9.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**通过username查找用户信息,这里规定的表里面用户名是不能重复的，所以返回的不是list;*/
    User findByUsername(String username);



}
