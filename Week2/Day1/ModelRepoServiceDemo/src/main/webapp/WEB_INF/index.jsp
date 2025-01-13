<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>Login Form</legend>
<form action="/login" method="POST">
<div>
<label>User Name :</label>
<input type="text" name="userName">
</div>
<div>
<label>Password :</label>
<input type="password" name="password">
</div>
<button type="submit">Login</button>
<div>
<h1 style="color:red"> <c:out value="${errorMessage}"></c:out> </h1>
</div>
</form>


</fieldset>
</body>
</html>