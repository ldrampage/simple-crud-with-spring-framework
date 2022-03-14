<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="snippets/header.jspf" %>
<div class="container">
	<h2>Add something to do</h2>
	<form method="post" action="/add-todo-form">
		<div class="mb-3">
	    	<label  for="description" class="form-label">Description</label>
	    	<input  type="text" class="form-control" name="description"/>
	    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>-->
	 	</div> 
	  	<div class="mb-3">
	    	<label for="targetDate" class="form-label">Target Date</label>
	    	<input type="date" class="form-control" name="targetDate">
	  	</div>
	  	<div class="mb-3">
	    	<label for="status" class="form-label">Status</label>
		    <select name="status" class="form-select">
		    	<option value="in-progress">in-progress</option>
		    	<option value="on-hold">on-hold</option>
		    	<option value="complete">complete</option>
		    </select>
	    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>-->
	 	</div> 
	 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		<button type="submit" class="btn btn-success">Submit</button>
	</form>
</div>
<%@ include file="snippets/footer.jspf" %>