<%@ page import="pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Student student = (Student) request.getAttribute("student");
    request.removeAttribute("student");
%>

<html>
<head>
    <title>Student</title>
</head>
<body>
<div id="informationDiv">
    <h1 align="center">Student Information</h1>
    <table border="1" style="margin:auto" width="60%">
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Number</th>
            <th>Major</th>
            <th>Progress</th>
        </tr>
        <tr>
            <td><%=student.getName()%></td>
            <td><%=student.getGender()%></td>
            <td><%=student.getNumber()%></td>
            <td><%=student.getMajor()%></td>
            <td><%=student.getProgress()%></td>
        </tr>
    </table>
<%
    String cmd = "jupyter notebook /opt/jupyter/"+student.getNumber()+"/"+" --allow-root";
    Process pro = Runtime.getRuntime().exec(cmd);
%>
    <a href="http://localhost:8888/notebooks/<%=student.getNumber()%>.ipynb">Jupyter Notebook</a>
</div>
</body>
</html>
