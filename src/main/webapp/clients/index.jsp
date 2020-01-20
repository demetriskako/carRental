<html>
	<%@include file="../partials/head.html" %>
 <body>
 	<%@include file="../partials/navigation.html" %>
	
	 <div class="container">
	 	<div class="content">
		 	<div class="row p-4">
		 		<div class="col-md-10">
		 			<h2>Clients</h2>
		 		</div>
		 		<div class="col-md-2">
					<a class="btn btn-primary" href="http://localhost:8080/carRental/clients/create.jsp" role="button">New Client</a>
				</div>			 
		 	</div>
	 
	 		<div class="row">
	 	 		<div class="col-md-12">
					<div class="profile">
				 		<table id="userdata" class="table">
					 		<thead>
						        <th>ID</th>
						        <th>Name</th>
						        <th>Lastname</th>
						        <th>E-mail</th>
						        <th>Tel</th>
						        <th style="width: 20%">Actions</th>
					   	 	</thead>
				    		<tbody>
				    		</tbody>
			   			</table>		   	
			 		</div>
			 	</div>
		 	</div>
		</div>
	</div>
</body>

<script>
	 $(document).ready(function($){
		 $(function() { 
			 var people = [];
			  $.getJSON('http://localhost:8080/carRental/webapi/clients/', function(data) {
			    $.each(data, function(f) {
			    	console.log();
			     	var tblRow = "<tr>" 
			     		+ "<td>" + data[f].id + "</td>"
			     		+ "<td>" + data[f].name + "</td>" 
			     		+ "<td>" + data[f].surname + "</td>"
			     		+ "<td>" + data[f].email + "</td>"
			     		+ "<td>" + data[f].tel + "</td>"
			     		+ "<td><a type='button' href='http://localhost:8080/carRental/clients/update.jsp?id="  + data[f].id + "' class='btn btn-primary mr-2'>Edit</a>"
			     		+ "<button id='deleteButton"+ data[f].id +"' class='btn btn-danger'>Delete</button></td>"
			     		+ "</tr>";
			               
			      	$(tblRow).appendTo("#userdata tbody");
			      	
			      	 $("#deleteButton" + data[f].id).on("click", function(){
			      		$.ajax({
			      			url: "http://localhost:8080/carRental/webapi/clients/" + data[f].id,
			      			type: "delete",
			      			success : function(data){
			      				location.reload();
			      			},
			      			error: function(data) { 
				 		        alert("There was an Error!"); 
				 		    }   
			      		});
					 });
			   	});
			  })
			  .error(function() { alert("Database Error"); });
		 });
	 });
</script>
</html>