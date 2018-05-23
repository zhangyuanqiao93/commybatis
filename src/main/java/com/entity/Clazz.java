package com.entity;

import java.util.List;

/**
 * Clazz对象，对应班级表
 */
public class Clazz {

    private Integer id;//班级id
    private String code;//班级编号
    private String name;//班级名称

    private List<Student> students;

    public Clazz() {
    }

    public Clazz(Integer id, String code, String name, List<Student> students) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.students = students;
    }

    //toString
    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
