package com.entity;

import com.mapper.ClazzMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis一对多项目测试
 */
public class OnetoManyTest {
    public static void main(String[] args) {
        String config = "mybatis-config.xml";
        SqlSession session = null;
        InputStream inputStream;

        {
            try {
                inputStream = Resources.getResourceAsStream(config);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                session = sqlSessionFactory.openSession();

//                测试一对多
                OnetoManyTest test = new OnetoManyTest();
                test.testSelectClazzById(session);
                session.commit();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (session != null) {
                    session.close();
                }
            }
        }
    }

    /**
     * 测试一对多，查询班级Clazz（一）的时候级联查询学生Student（多）
     * @param session session
     */
    private void testSelectClazzById(SqlSession session) {

        /*获得ClazzMapper接口的代理对象*/
        ClazzMapper clazzMapper = session.getMapper(ClazzMapper.class);
        //调用查询方法
        Clazz clazz = clazzMapper.selectClazzById(1);
        System.out.println("Clazz= " + clazz.toString());

        /*查看clazz对象关联的学生信息*/
        List<Student> students = clazz.getStudents();
        for (Student stu:
             students) {
            System.out.println(stu);
        }

    }


}
