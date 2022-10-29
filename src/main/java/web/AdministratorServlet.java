package web;

import dao.AdministratorMapper;
import dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Administrator;
import pojo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/administratorServlet")
public class AdministratorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收账号和密码
        String number = request.getParameter("number");
        String password = request.getParameter("password");

        //准备MyBatis
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdministratorMapper administratorMapper = sqlSession.getMapper(AdministratorMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //调用方法查找数据库是否有这个管理员,并生成学生列表
        Administrator administrator = administratorMapper.selectAdministrator(number, password);
        List<Student> students = studentMapper.selectAll();

        //释放资源
        sqlSession.commit();
        sqlSession.close();

        //逻辑判断
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(administrator != null) {
            request.setAttribute("students",students);
            request.setAttribute("administrator",administrator);
            request.getRequestDispatcher("AdministratorInformation.jsp").forward(request,response);
        } else {
            writer.write("账号或密码错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}