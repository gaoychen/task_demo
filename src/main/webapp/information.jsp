<%@ page import="pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Student student = (Student) request.getAttribute("student");
    request.removeAttribute("student");
%>

<html>
<head>
    <title>学生信息页面</title>
</head>
<body>
<div id="informationDiv">
    <h1 align="center">学生信息</h1>
    <table border="1" style="margin:auto" width="60%">
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>学号</th>
            <th>专业</th>
        </tr>
        <tr>
            <td><%=student.getName()%></td>
            <td><%=student.getGender()%></td>
            <td><%=student.getNumber()%></td>
            <td><%=student.getMajor()%></td>
        </tr>
    </table>
</div>
</body>
</html>
