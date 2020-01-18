<html>
	<%@include file="../partials/head.html" %>
	<%@include file="../partials/navigation.html" %>
	
	<body>
		<div class="container">
			<div class="content">
				<div class="row p-4">
			 		<div class="col-md-10">
			 			<h2>Cities</h2>
			 		</div>
			 		<div class="col-md-2">
						<a class="btn btn-primary" href="http://localhost:8080/carRental/cities/create.jsp" role="button">New City</a>
					</div>			 
		 		</div>
		 		
				<div class="row">
				 	<div class="col-md-12">
						<div class="profile">
						 	<table id="userdata" class="table">
						 		<thead>
							        <th>City ID</th>
							        <th>City Name</th>
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
				  $.getJSON('http://localhost:8080/carRental/webapi/cities/', function(data) {
				    $.each(data, function(f) {
				    	console.log();
				     	var tblRow = "<tr>" + "<td>" + data[f].id + "</td>" + "<td>" + data[f].name+ "</td>" +
				      		   "<td><a type='button' href='http://localhost:8080/carRental/cities/update.jsp?id="  + data[f].id +"' class='btn btn-primary mr-2'>Edit</a>" + "<nbsp>" +
				               "<button id='deleteButton"+ data[f].id +"' class='btn btn-danger'> Delete </button></td></tr>";
				               
				      	$(tblRow).appendTo("#userdata tbody");
				      	
				      	 $("#deleteButton" + data[f].id).on("click", function(){
				      		$.ajax({
				      			url: "http://localhost:8080/carRental/webapi/cities/" + data[f].id,
				      			type: "delete",
				      			success : function(data){
				      				location.reload();
				      			}
				      		});
						 });
				   	});
				  });
			 });
		 });
	</script>
</html>