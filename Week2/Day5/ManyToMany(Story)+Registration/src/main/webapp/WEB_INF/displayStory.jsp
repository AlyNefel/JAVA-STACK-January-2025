<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<p>Title : <c:out value="${story.title }"></c:out></p>
<p>Title : <c:out value="${story.description }"></c:out></p>
<c:forEach var="user" items="${story.likers }">
<li>
<c:out value="${user.getUserName() }"></c:out>
</li>
</c:forEach>
</ul>
</body>
</html>