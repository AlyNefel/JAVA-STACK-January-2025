<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- New line below to use the JSP Standard Tag Library --> 
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/index.js"></script> 
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>First JSP</title>
</head>
<body>
<button class="btn btn-danger">Test Bootstrap</button>
<h1 id="testJs" onclick="testJs()">Hello From JSP !</h1>
<c:out value="${name }"></c:out>
<ul>

 <!-- How to declare it 
  <c:forEach var="item" items="${items}">
        <p><c:out value="${item}"></c:out></p>
    </c:forEach>
  -->
  
<c:forEach var="item" items="${list}">
<li>
<c:out value="${item}"></c:out>
</li>
</c:forEach>
</ul>

<!-- Condition -->
<c:if test="${age<10}">
<h3 style="color:red">Error please check ur age</h3>
</c:if>
<c:if test="${age>=10}">
<h3 style="color:green"><c:out value="${sessionScope.age}"></c:out></h3>
</c:if>


<!-- if else if  -->
<c:choose>
<c:when test="${age<10}"><h3>This is if the test pass !!</h3></c:when>
<c:otherwise><h1>This is for else !</h1></c:otherwise>

</c:choose>

</body>
</html>