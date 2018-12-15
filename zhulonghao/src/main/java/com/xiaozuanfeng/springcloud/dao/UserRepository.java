package com.xiaozuanfeng.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xiaozuanfeng.springcloud.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
