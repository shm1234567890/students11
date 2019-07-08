package cn.accp.mapper;
import cn.accp.domain.Classes;
import cn.accp.domain.Role;
import cn.accp.domain.Student;
import cn.accp.domain.StudentCondition;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentsMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //在文件mybatis-config.xml上打开一个输入流，准备读取该文件的内容
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSessionFactory表示数据库在内存中的镜像，每个项目需要构建一个该对象，且不应该轻易关闭
    }

    @Test
    public void save() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        //SqlSession表示一个数据库连接，用完后应该立刻关闭
        try {
            StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
            //通过Mybatis内置的功能，为我们生成BlogMApper接口的实现，并送入mapper中
            Classes s = new Classes();
            s.setId(1);

            Student ss = new Student("xiaoli", 18, "m", "32423546576", "4869486@qq.com", s);
            ss.setRole(Role.USER);
            studentsMapper.save(ss);
            /*studentsMapper.findAll().forEach(System.out::println);*/

            session.commit();//提交数据库事务
            System.out.println(ss);

        } finally {
            session.close();//关闭数据库连接
        }
    }

    @Test
    public void findAll() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
        studentsMapper.findAll().forEach(System.out::println);
    }
    @Test
    public void test1() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);

            classesMapper.findAll().forEach(e ->
            {
                System.out.println("Classes Name: " + e.getName());
                e.getStudent().forEach(System.out::println);
                System.out.println();
            });

        } finally {
            session.close();
        }
    }

    @Test
    public void test2(){
        SqlSession Session=sqlSessionFactory.openSession();
        StudentsMapper studentsMapper=Session.getMapper(StudentsMapper.class);
        Session.close();

        Session=sqlSessionFactory.openSession();
        studentsMapper=Session.getMapper(StudentsMapper.class);
        studentsMapper.findAll().forEach(System.out::println);
        Session.close();

    }

    @Test
    public void test3(){
        SqlSession session=sqlSessionFactory.openSession();
        StudentsMapper studentsMapper=session.getMapper(StudentsMapper.class);
        StudentCondition studentCondition=new StudentCondition(null,20,25,null);
        studentsMapper.findByCondition(studentCondition).forEach(System.out::println);
        session.close();
    }

    @Test
    public void test4(){
        SqlSession session=sqlSessionFactory.openSession();
        StudentsMapper studentsMapper=session.getMapper(StudentsMapper.class);
        List<Integer> ids =new ArrayList<>(2);
        ids.add(6);
        ids.add(7);
        studentsMapper.findByids(ids).forEach(System.out::println);
        session.close();
    }

}









