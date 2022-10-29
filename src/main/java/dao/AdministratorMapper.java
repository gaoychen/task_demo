package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Administrator;

public interface AdministratorMapper {
    //解决主键自增混乱
    @Update("alter table student AUTO_INCREMENT=1")
    int updateId();

    @Select("select * from administrator where number = #{number} and password = #{password}")
    Administrator selectAdministrator(@Param("number") String number, @Param("password") String password);
}
