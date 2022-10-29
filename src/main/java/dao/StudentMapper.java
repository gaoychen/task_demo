package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Student;

import java.util.List;

public interface StudentMapper {
    //解决主键自增混乱
    @Update("alter table student AUTO_INCREMENT=1")
    int updateId();

    @Select("select * from student where number = #{number} and password = #{password}")
    Student selectStudent(@Param("number") String number, @Param("password") String password);

    @Insert("insert into student(name, gender, number, major, password) values(#{name}, #{gender}, #{number}, #{major}, #{password})")
    int insertStudent(Student student);

    @Select("select * from student")
    List<Student> selectAll();
}
