<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.container {
position: relative;
}.topright {
position: absolute;
top: 8px;
right: 16px;
font-size: 18px;
}img {
width: 100%;
height: auto;
opacity: 0.3;
}
</style>
<div class="topright">
<div class="container">
<a href="admin.jsp" >Admin</a>
</div>
</div>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align=center>
</div>
<center>
<h1><b>Employee REGISTRATION</b></h1>
<h2>Employee Login</h2>
<form action="login" method="post">
<table>
<tr><td>Username:</td>
<td><input type=text name=uname></td>
</tr>
<tr><td>Password:</td>
<td><input type=password name=pass></td>
</tr>
<tr><td><input type=submit value=Login></td>
</tr>
<tr><td><a href="add.jsp">New Employee</a></td>
<td><a href="update.jsp">Forget password</a></td></tr>
</table>
</form>
</center>
</body>
</html>