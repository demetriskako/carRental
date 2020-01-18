<html>
	<%@include file="../partials/head.html" %>
	
	<body>
 	<%@include file="../partials/navigation.html" %>
	
	 <div class="container">
        <h2> Create Store </h2>	        	
        <div class="form-group">
	       	<label for="id">Store ID: </label>
	       	<input type="text" class="form-control" id="id">	
        </div>
        <div class="form-group">
        	<label for="name">Store Name: </label>
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
	 //Get cities data
	 $.getJSON('http://localhost:8080/carRental/webapi/cities', function(data) {
		 data.map( (city) => {
				$("#city").append("<option value=" + city.id + ">" + city.name + "</option>")
		 })
	  });
	 
	 //Get store data
	 $.getJSON('http://localhost:8080/carRental/webapi/stores/<%= request.getParameter("id") %>', function(data) {
		  $("#name").val(data.name)
		  $("#id").val(data.id)
	  });
	 
 	 $("#updateButton").on("click", function(){
 		$.ajax({
 			url: "http://localhost:8080/carRental/webapi/stores/<%= request.getParameter("id") %>",
 			type: "PUT",
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