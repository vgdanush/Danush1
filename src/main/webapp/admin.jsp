<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align=center>
</div>
<center>
<h1>Admin Login</h1>
<form action="admin" method="post">
<table>
<tr><td>Username:</td> 
<td><input type=text name=uname></td>
</tr>
<tr><td>Password:</td>
<td><input type=password name=pass></td>
</tr>
<tr><td><input type=submit value=Login></td>
</tr>
<td><a href="forg.jsp">Forget password</a></td></tr>
</table>
</form>
</center>
</body>
</html>