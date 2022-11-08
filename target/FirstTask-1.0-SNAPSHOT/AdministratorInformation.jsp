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
    <title>Administrator</title>
</head>
<body>
<div id="informationDiv">
    <h1 align="center">All Students</h1>
    <table border="1" style="margin:auto" width="60%">
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Number</th>
            <th>Major</th>
            <th>Progress</th>
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
