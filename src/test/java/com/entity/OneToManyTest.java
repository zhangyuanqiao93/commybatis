package com.entity;

import com.mapper.ClazzMapper;
import com.mapper.StudentMapper;
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
public class OneToManyTest {
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
                OneToManyTest test = new OneToManyTest();

                /*测试一对多*/
                test.testSelectStudentById(session);
                test.testSelectClazzById(session);
                session.commit();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                /*Session关闭*/
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
        System.out.println("testSelectClazzById method");

        /*获得ClazzMapper接口的代理对象*/
        ClazzMapper clazzMapper = session.getMapper(ClazzMapper.class);
        //调用查询方法
        Clazz clazz = clazzMapper.selectClazzById(1);
        System.out.println("Clazz= " + clazz.toString());

        /*查看clazz对象关联的学生信息*/
        List<Student> students = clazz.getStudents();
        for (Student stu:
             students) {
            System.out.println("students: "+ stu);
        }

    }

    /**
     * 多个学生对应一个班级
     * @param sqlSession session
     */
    public void testSelectStudentById(SqlSession sqlSession){
        /*获取StudentMapper接口的代理对象*/
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectStudentById(1);
        System.out.println(student);
        /*查看Student对象关联的班级信息*/
        System.out.println(student.getClazz());

    }


}
