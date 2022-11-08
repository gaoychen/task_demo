package web;

import dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;


@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收学号和密码
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String number = request.getParameter("number");
        String major = request.getParameter("major");
        String password = request.getParameter("password");

        //准备MyBatis
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //构造学生对象
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setNumber(number);
        student.setMajor(major);
        student.setPassword(password);

        //插入学生信息
        studentMapper.updateId();
        int result = studentMapper.insertStudent(student);

        //准备对应的Jupyter Notebook资源
        File sourceFolder = new File("/opt/jupyter/source");
        File destFolder = new File("/opt/jupyter/"+student.getNumber());
        File sourceFile = new File("/opt/jupyter/source/Test.ipynb");
        File destFile = new File("/opt/jupyter/"+student.getNumber()+"/"+student.getNumber()+".ipynb");
        Files.copy(sourceFolder.toPath(),destFolder.toPath());
        Files.copy(sourceFile.toPath(),destFile.toPath());

        //释放资源
        sqlSession.commit();
        sqlSession.close();

        //逻辑判断
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(result > 0) {
            response.sendRedirect("login.html");
        } else {
            writer.write("Please complete your information");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}