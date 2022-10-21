package web;

import dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收学号和密码
        String number = request.getParameter("number");
        String password = request.getParameter("password");

        //准备MyBatis
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //调用方法查找数据库是否有这个学生
        Student student = studentMapper.selectStudent(number, password);

        //释放资源
        sqlSession.commit();
        sqlSession.close();

        //逻辑判断
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(student != null) {
            request.setAttribute("student",student);
            request.getRequestDispatcher("information.jsp").forward(request,response);
        } else {
            writer.write("学号或密码错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
