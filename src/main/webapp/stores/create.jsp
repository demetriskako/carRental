<html>
	<%@include file="../partials/head.html" %>
	<%@include file="../partials/navigation.html" %>
	
	<body>	
		<div class="container">
	     	<div class="row p-4">
				<h2>Create Store</h2>
			</div>	
			  
			<div class="row"> 	
	        	<div class="col-md-6">     	
			        <div class="form-group">
				       	<%--@declare id="email"--%><label for="id">Store ID: </label>
				       	<input type="text" class="form-control" id="id">	
			        </div>
			    </div>
			    
			    <div class="col-md-6">
			        <div class="form-group">
			        	<label for="name">Store Name: </label>
			        	<input type="text" class="form-control" id="name">	
			        </div>
				</div>
			</div>
	        
	        
	        <div class="row"> 	
	        	<div class="col-md-6">   
			        <div class="form-group">
					    <%--@declare id="exampleformcontrolselect2"--%><label for="exampleFormControlSelect2">Select city</label>
					    <select class="form-control" id="city">
					    </select>
				  	</div>
				</div>
			</div>
		               
	        <button id="saveButton" class="btn btn-primary">Save</button>
			<a href="http://localhost:8080/carRental/cities/" class="btn btn-danger">Back</a>      
		</div>
	</body>

	<script>
		$(document).ready(function($){
			$.getJSON('http://localhost:8080/carRental/webapi/cities', function(data) {
				data.map( (city) => {
					$("#city").append("<option value=" + city.id + ">" + city.name + "</option>")
				})
			});
			 
		 	 $("#saveButton").on("click", function(){
		 		$.ajax({
		 			url: "http://localhost:8080/carRental/webapi/stores/create",
		 			type: "POST",
		 			dataType: 'json',
		 			contentType: 'application/x-www-form-urlencoded',
		 			data: {
		 				"id": $('#id').val(),
		 				"name": $('#name').val(),
		 				"city": $('#city').val(),
		 			},
		 			success: function(data){
		 				window.location.replace('http://localhost:8080/carRental/stores');
		 			},
		 			error: function(data) { 
		 		        alert("There was an Error!"); 
		 		    }  
		 		});
			 });   
		});
	</script>   
</html>