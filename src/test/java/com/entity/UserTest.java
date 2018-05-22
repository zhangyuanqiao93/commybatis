package com.entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class UserTest {


    public static void main(String[] args) {
        String config = "mybatis-config.xml";
        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();//创建session实例
            //创建User对象
            User user = new User("admin",22);
            String name = user.getName();
            System.out.println(name);
            //session.selectCursor("selectAllUserById");
            int saveUser = session.insert("com.mapper.UserMapper.saveUser", user);
            System.out.println("saveUser: " + saveUser);
            session.commit();
        } catch (IOException e) {
            System.out.println("数据操作异常！");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }
}