<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container form-control mt-4 " style="padding:32px">
<div class="row mt-4">
<div class="col-4">
<h1>Welcome, <c:out value="${user.userName }"/> ! </h1>

<a href="/logout"  class="btn btn-outline-danger float-end"> Log Out</a>
</div>
</div>
<div class="row mt-4">

<a href="/story/new" class="btn btn-labeled btn-success float-end"  style="width:15% ;border:1px solid #a64d79;background-color:#a64d79">
         <span class="btn-label"><i class="fa fa-plus"></i></span>Add new Story</a>
         
         <!-- <form class="in-line form-control mt-4" action="/search" method="get">
	
					<input class="in-line" type="text" id="celebrity" name="q" placeholder="Search"/>
					<input class="in-line" class="button" type="submit" style="background-color:#a62eff;color:white" value="Search"/>
					
				</form>
				 --> 
<h2 style="color:#a64d79" class="mt-4">All Stories </h2>
<c:if test="${stories.size()==0 }">
<div class="alert alert-primary" role="alert">
  There is no stories added yet! Hit the button above and start ^^
</div>
</c:if>	
<c:if test="${stories.size()!=0 }">			 
<table class="table table-striped mt-4" style="width:70%">
  <thead>
    <tr>
      <th scope="col">Story</th>
     <th scope="col">Creator</th>
     <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${stories}" var="story" >
    <tr>
      <th><a href="/stories/${story.id}">${story.title}</a> <br>
      
      </th>
      <th>
      
      <h4 style="color:#a64d79"><c:out value="${story.creator.getUserName() }"></c:out></h6>
      
      </th>
      <th>
      <c:if test="${story.creator.getId().equals(user.getId()) }">
      <a href="/edit/${story.id}">Edit</a>
      </c:if>
      <c:if test="${story.getLikers().contains(user) }">
      <a href="/dislike/${story.id}">Dislike</a>
      </c:if>
      <c:if test="${!story.getLikers().contains(user) }">
      <a href="/like/${story.id}">Like</a>
      </c:if>
      </th>
    </tr>
    </c:forEach>
  </tbody>
</table>
</c:if>
</div>

</div>
</body>
</html>