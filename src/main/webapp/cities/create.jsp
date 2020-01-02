<html>
	<%@include file="../partials/head.html" %>
	
	<body>
 	<%@include file="../partials/navigation.html" %>
	
	 <div class="container">
        <h2> Create City </h2>	        	
        <div class="form-group">
	       	<label for="email">City ID: </label>
	       	<input type="text" class="form-control" id="id">	
        </div>
        <div class="form-group">
        	<label for="email">City Name: </label>
        	<input type="text" class="form-control" id="name">	
        </div>
               
        <button id="updateButton" class="btn btn-primary">Save</button>
		<a href="http://localhost:8080/carRental/cities/" class="btn btn-danger">Back</a>      
	 </div>
	</body>

 <script>
 $(document).ready(function($){  
 	 $("#updateButton").on("click", function(){
 		$.ajax({
 			url: "http://localhost:8080/carRental/webapi/cities/create",
 			type: "POST",
 			dataType: 'json',
 			contentType: 'application/x-www-form-urlencoded',
 			data: {
 				"id": $('#id').val(),
 				"name": $('#name').val(),
 			},
 			success: function(data){
 				console.log("OK");
 				 location.reload();
 			}
 		});
	 });   
});
	
</script>   
</html>