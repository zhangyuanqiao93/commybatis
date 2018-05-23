package com.mapper;

import com.entity.Clazz;

public interface ClazzMapper {

    /**
     * 根据id查询班级信息
     * @param id 学生id
     * @return 班级信息
     */
    Clazz selectClazzById(Integer id);
}
