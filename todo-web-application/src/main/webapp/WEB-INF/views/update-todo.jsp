<%@ include file="snippets/header.jspf" %>
<div class="container">
	<h2>Update</h2>
	<form method="post" action="/update-todo-form">
		<input type="hidden" name="id" value="${id}">
		<div class="mb-3">
	    	<label  for="description" class="form-label">Description</label>
	    	<input  type="text" class="form-control" name="description" value="${description}"/>
	    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>-->
	 	</div> 
	  	<div class="mb-3">
	    	<label for="targetDate" class="form-label">Target Date</label>
	    	<input  type="date" class="form-control" name="targetDate" value="<fmt:formatDate value="${targetDate}" pattern="yyyy-MM-dd"/>" />
	  	</div>
	  	<div class="mb-3">
	    	<label for="status" class="form-label">Status</label>
		    <select name="status" class="form-select">
		    	<c:forEach items="${statuses}" var="stats">
		    		<option value="${stats}" ${status == stats ? 'selected' : ''}>${stats}</option>
		    	</c:forEach>
		    </select>
	    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>-->
	 	</div> 
	 	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		<button type="submit" class="btn btn-success">Update</button>
	</form>
</div>
<%@ include file="snippets/footer.jspf" %>