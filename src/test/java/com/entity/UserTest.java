package com.entity;

import org.apache.ibatis.cursor.Cursor;
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
            //1.获取配置文件
            InputStream inputStream = Resources.getResourceAsStream(config);
            //2.获取SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //3.获取Session对象
            session = sqlSessionFactory.openSession();//创建session实例
            //4.创建User对象
            User user = new User("admin",22);
            String name = user.getName();
            System.out.println(name);

            Cursor<Object> userById = session.selectCursor("selectAllUserById", user);
            System.out.println("userById: " + userById);
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