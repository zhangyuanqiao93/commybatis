package com.mapper;

import com.entity.Student;

public interface StudentMapper {
    /**
     * 根据id查询学生信息
     * @param id id
     * @return 学生列表
     */
    Student selectStudentById(Integer id);
    Student selectStudentByClazzId(Integer id);

}
