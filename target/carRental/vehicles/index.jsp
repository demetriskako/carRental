<html>
	<%@include file="../partials/head.html" %>
 <body>
 	<%@include file="../partials/navigation.html" %>
	
	 <div class="container">
	 	<div class="content">
			<div class="row p-4">
		 		<div class="col-md-10">
		 			<h2>Vehicles</h2>
		 		</div>
		 		
		 		<div class="row mb-2">
					<a class="btn btn-primary" href="http://localhost:8080/carRental/vehicles/create.jsp" role="button">Add New Vehicle</a>			 
		 		</div>			 
	 		</div>
	 
		 	<div class="row">
		 	 	<div class="col-md-12">
					<div class="profile">
				 	<table id="userdata" class="table">
				 		<thead>
					        <th>Licence</th>
					        <th>Model</th>
					        <th>Fuel</th>
					        <th>Type</th>
					        <th>Model</th>
					        <th>Cost per Day</th>
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
			  $.getJSON('http://localhost:8080/carRental/webapi/vehicles/', function(data) {
			    $.each(data, function(f) {
			    	console.log();
			     	var tblRow = "<tr>" 
			     	+ "<td>" + data[f].licence + "</td>" + "<td>" + data[f].model + "</td>"
			     	+ "<td>" + data[f].fuel + "</td>" + "<td>" + data[f].vehicle_type + "</td>"
			     	+ "<td>" + data[f].model + "</td>" + "<td>" + data[f].cost + "</td>"
	      		    + "<td>"
			     	+ "<a type='button' href='http://localhost:8080/carRental/vehicles/update.jsp?id="  + data[f].licence + "' class='btn btn-primary mr-2'>"
			     	+  	"Edit"
			     	+ "</a>"
	                + "<button id='deleteButton"+ data[f].licence + "' class='btn btn-danger'>Delete</button></td></tr>";
			               
			      	$(tblRow).appendTo("#userdata tbody");
			      	
			      	 $("#deleteButton" + data[f].licence).on("click", function(){
			      		$.ajax({
			      			url: "http://localhost:8080/carRental/webapi/vehicles/" + data[f].licence,
			      			type: "delete",
			      			success : function(data){
			      				alert("Vehicle deleted")
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