package cn.accp.mapper;

import cn.accp.domain.Student;
import cn.accp.domain.StudentCondition;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface StudentsMapper {

    //dao层接口中方法名字永远应该是增删改查

    List<Student> findAll();

    int save(Student student);

    List<Student> findByCondition(StudentCondition studentCondition);

    List<Student> findByids(List<Integer> ids);

}
