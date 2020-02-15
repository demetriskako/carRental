<html>
	<%@include file="../partials/head.html" %>
	
	<body>
 	<%@include file="../partials/navigation.html" %>
	
	 <div class="container">
	 	<div class="row p-4">
			<h2>Update City</h2>	        	
		</div>	
          
         <div class="form-group">
        	<label for="id">City ID: </label>
        	<input type="text" class="form-control" id="id" disabled>
        </div>
        <div class="form-group">
        	<label for="name">City Name: </label>
        	<input type="text" class="form-control" id="name">	
        </div>
               
        <button id="updateButton" class="btn btn-primary">Update</button>
		<a href="http://localhost:8080/carRental/cities/" class="btn btn-danger">Back</a> 
	 </div>
	</body>

	<script>
		 $(document).ready(function($){
			  $.getJSON('http://localhost:8080/carRental/webapi/cities/<%= request.getParameter("id") %>', function(data) {
				  $("#name").val(data.name);
				  $("#id").val(data.id);
			  });
			   
	      	 $("#updateButton").on("click", function(){
	      		$.ajax({
	      			url: "http://localhost:8080/carRental/webapi/cities/<%= request.getParameter("id") %>",
	      			type: "PUT",
	     			dataType: 'json',
	      			contentType: 'application/x-www-form-urlencoded',
	      			data: {
	      				"id": $('#id').val(),
	      				"name": $('#name').val(),
	      			},
	      			success: function(data){
	      				window.location.replace('http://localhost:8080/carRental/cities');
	      			},
	      			error: function(data) { 
		 		        alert("There was an Error!"); 
		 		    }   
	      		});
			 });   
		 });
	</script>   
</html>