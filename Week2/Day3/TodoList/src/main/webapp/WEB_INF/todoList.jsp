<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-5">
<h1 class="mt-4">User List</h1>
<a href="/user/new" class="btn btn-primary">Create User</a>

<table class="table table-striped">
<thead>
<tr>
<th>Name</th>
<th>N*Todos</th>
<th>Action</th>

</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}" >
<tr>
<td>

 <c:out value="${user.name}"></c:out>



</td>
<td>
<c:out value="${user.todos.size()}"></c:out>

</td>
<td>
<form action="/user/delete/${user.id}" method="POST">
<input type="hidden" name="_method" value="DELETE">
<button class="btn btn-danger">Delete</button>
</form>
</td>
</tr>
</c:forEach>
</tbody>

</table>
</div>
<div class="col-6">
<h1 class="mt-4">Todo List</h1>
<!-- Test if empty todo -->
       <c:if test="${todos.size() == 0}"> 
       <div class="alert alert-warning" role="alert"> There are no To-Do tasks yet. </div> 
       </c:if>
<a href="/todo/new" class="btn btn-primary">Create Todo</a>
<!-- Search Bar -->
        <form action="/todos/search" method="GET" class="mb-3 mt-4"> 
        <div class="input-group"> 
        <input type="text" name="query" class="form-control" placeholder="Search tasks..."> 
        <button type="submit" class="btn btn-primary">Search</button> 
        </div> 
        </form>
        <c:if test="${todos.size() != 0}">
<table class="table table-striped">
<thead>
<tr>
<th>Title</th>
<th>Last Update</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="todo" items="${todos}" >
<tr>
<td>
<c:if test="${todo.completed}">
 <p style="text-decoration:line-through;color:red"> <c:out value="${todo.title}"></c:out></p>
</c:if>

<c:if test="${!todo.completed}">
<c:out value="${todo.title}"></c:out>
</c:if>
</td>
<td>
<c:out value="${todo.user.getName() }" ></c:out>
<fmt:formatDate value="${todo.updatedAt}" pattern="EEEE, dd MMMM  yyyy HH:mm"/>

</td>
<td>
<a href="/todo/edit/${todo.id}" class="btn btn-success">Edit</a>

<a href="/todo/delete/${todo.id}">Delete</a>

</td>
</tr>
</c:forEach>
</tbody>

</table>
 </c:if>
</div>
</div>
</div>
</body>
</html>