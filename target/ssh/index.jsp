<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="addStudent.do" method="get">
    <button type="submit">增加学生</button>
</form>
<form action="updateStudent.do" method="get">
    <button type="submit">修改学生</button>
</form>
<form action="queryStudent.do" method="get">
    <button type="submit">查询学生</button>
</form>
<form action="deleteStudent.do" method="get">
    <button type="submit">删除学生</button>
</form>
</body>
</html>