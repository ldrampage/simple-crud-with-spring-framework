<%@ include file="snippets/header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="container">
	<h2>Your todos list </h2>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Description</th>
	      <th scope="col">Target Date</th>
	      <th scope="col">Status</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${todos}" var="todo">
	  		<tr>
	  			<td>${todo.description}</td>
	  			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${todo.targetDate}"/></td>
	  			<td>${todo.status}</td>
	  			<td><a href="/update-todo?id=${todo.id}" class="btn btn-info">Update</a>&nbsp;<a class="btn btn-danger" onclick="confirmation(${todo.id})">Delete</a></td>
	  		</tr>
	  	</c:forEach>
	  </tbody>
	</table>
	<a href="/add-todo" class="btn btn-success">Add</a>
</div>
<script>
	function confirmation(id){
		var res = confirm("Are you sure to delete?");
		if(res) {
			window.location = "/delete-todo?id="+id;
		}
	}
</script>
<%@ include file="snippets/footer.jspf" %>

