<%@ page import="pojo.Administrator" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Administrator administrator = (Administrator) request.getAttribute("administrator");
  List<Student> students = (List<Student>) request.getAttribute("students");
  request.removeAttribute("administrator");
  request.removeAttribute("students");
%>

<html>
<head>
    <title>后台管理页面</title>
</head>
<body>
<div id="informationDiv">
    <h1 align="center">所有学生信息列表</h1>
    <table border="1" style="margin:auto" width="60%">
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>学号</th>
            <th>专业</th>
            <th>进度</th>
        </tr>
<%
    for (int i = 0; i < students.size(); i++){
        Student student = students.get(i);
%>
        <tr>
            <td><%=student.getName()%></td>
            <td><%=student.getGender()%></td>
            <td><%=student.getNumber()%></td>
            <td><%=student.getMajor()%></td>
            <td><%=student.getProgress()%></td>
        </tr>
<%
    }
%>
    </table>
</div>
</body>
</html>
