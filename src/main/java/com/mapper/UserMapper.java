package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    /*mybatis 注解的实例start*/

    /**
     * 存储一个用户信息到数据库(插入数据)
     * @param user user
     * @return int id
     */
    @Insert("INSERT INTO tb_user(name,sex,age) VALUES (#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id")//设置主键自增
    int saveUser(User user);


    /**
     * 根据id删除数据
     * @param id 用户id
     * @return 删除后的数据表
     */
    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    int removeUser(@Param("id") Integer id);//注解表示给参数后面的变量取一个参数名称

    @Update("UPDATE tb_user SET name = #{name},sex=#{sex},age = #{age} WHERE id = #{id}")
    void modifyUser(User user);

    /**
     * 根据id查询用户
     * @return list user
     */
    @Select("SELECT * FROM tb_user")
    List<User> selectAllUser();

    /**
     * 查询所有用户
     * @param id id
     * @return user
     */
    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age")
    })
    User selectUserById(Integer id);

    /*mybatis 注解的实例end*/


    /*mybatis 动态sql 注解实例start*/
    @SelectProvider(type = UserDynaSqlProvider.class,method = "selectWithParam")
    List<User> selectWithParam(Map<String,Object> param);


    /*mybatis 动态sql 注解实例start*/
}
