package com.mapper;

import java.util.List;

public interface UserMapper {

    /**
     * 存储一个用户信息到数据库
     */
    void saveUser();

    /**
     * 根据id查询所有用户信息
     * @return 用户信息列表
     */
    List selectAllUserById();
}
