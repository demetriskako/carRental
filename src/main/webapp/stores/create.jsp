<html>
	<%@include file="../partials/head.html" %>
	
	<body>
 	<%@include file="../partials/navigation.html" %>
	
	 <div class="container">
        <h2> Create Store </h2>	        	
        <div class="form-group">
	       	<label for="email">Store ID: </label>
	       	<input type="text" class="form-control" id="id">	
        </div>
        <div class="form-group">
        	<label for="email">Store Name: </label>
        	<input type="text" class="form-control" id="name">	
        </div>
        
        <div class="form-group">
		    <label for="exampleFormControlSelect2">Select city</label>
		    <select class="form-control" id="city">
		    </select>
	  </div>
	               
        <button id="updateButton" class="btn btn-primary">Save</button>
		<a href="http://localhost:8080/carRental/cities/" class="btn btn-danger">Back</a>      
	 </div>
	</body>

 <script>
 $(document).ready(function($){  
	 
	 window.onload = function() {
		$.ajax({
 			url: "http://localhost:8080/carRental/webapi/cities",
 			type: "GET",
	 		success: function(data){
	 			let cities = data
	 			
	 			cities.map( (city) => {
	 				$("#city").append("<option value=" + city.id + ">" + city.name + "</option>")
	 			})
			}
		})
	};
	 
 	 $("#updateButton").on("click", function(){
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
 				location.reload();
 			}
 		});
	 });   
});
	
</script>   
</html>