<html>
	<%@include file="../partials/head.html" %>
	<%@include file="../partials/navigation.html" %>
	
	<body>
		<div class="container">
			<div class="row p-4">
				<h2>Create Client</h2>
			</div>			 
		            	
	    	<div class="row">	
		      	<div class="col-md-6">
			        <div class="form-group">
				       	<label for="id">Client ID</label>
				       	<input type="text" class="form-control" id="id">	
				    </div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
					 	<label for="license">License</label>
					 	<input type="text" class="form-control" id="license">	
					 </div>
				</div> 
	      	</div>
			           
			<div class="row">	
				<div class="col-md-6">
					 <div class="form-group">
						<label for="name">Name</label>
						<input type="text" class="form-control" id="name">	
					 </div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="storeId">Surname</label>
					 	<input type="text" class="form-control" id="surname">	
					 </div>
				</div> 
			</div>
		      
			<div class="row">	
				<div class="col-md-6">
					<div class="form-group">
						<label for="email">Email</label>
						<input type="text" class="form-control" id="email">	
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
					  	<label for="tel">Telephone</label>
					  	<input type="text" class="form-control" id="tel">	
				 	</div>
				</div>  
			</div>
	      		     
	        <div class="row">	
	     		<div class="col-md-6">
	      			<div class="form-group">
	       				<label for="address">Address</label>
	       				<input type="text" class="form-control" id="address">	
	       			</div>
	     		 </div>
	    	</div>    
		             
			<button id="saveButton" class="btn btn-primary">Save</button>
			<a href="http://localhost:8080/carRental/clients/" class="btn btn-danger">Back</a>      
		</div>
	</body>
	

	 <script>
	 $(document).ready(function($){  
		 
	 	 $("#saveButton").on("click", function(){
	 		$.ajax({
	 			url: "http://localhost:8080/carRental/webapi/clients/create",
	 			type: "POST",
	 			dataType: 'json',
	 			contentType: 'application/x-www-form-urlencoded',
	 			data: {
	 				"id": $('#id').val(),
	 				"name": $('#name').val(),
	 				"surname": $('#surname').val(),
	 				"license": $('#license').val(),
	 				"email": $('#email').val(),
	 				"tel": $('#tel').val(),
	 				"address": $('#address').val(),
	 			},
	 			success: function(data){
	 				window.location.replace('http://localhost:8080/carRental/clients');
	 			}
	 		});
		 });   
	});
	</script>   
</html>