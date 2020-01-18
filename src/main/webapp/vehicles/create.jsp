<html>
	<%@include file="../partials/head.html" %>
	
	<body>
 	<%@include file="../partials/navigation.html" %>
	
	 <div class="container">
        <h2> Create New Vehicle </h2>	   
        
        <div class="row">	
        	<div class="col-md-6">
		        <div class="form-group">
			       	<label for="vehicleLicenceNo">License Number</label>
			       	<input type="text" class="form-control" id="vehicleLicenceNo">	
		        </div>
	        </div>
	        
	       <div class="col-md-6">
		       <div class="form-group">
			       	<label for="storeId">Store ID</label>
			       	<input type="text" class="form-control" id="storeId">	
		        </div>
	        </div>
        </div>     
        
        <div class="row">	
        	<div class="col-md-6">
		        <div class="form-group">
			       	<label for="vehicleModel">Vehicle Model</label>
			       	<input type="text" class="form-control" id="vehicleModel">	
		        </div>
	        </div>
	        
	       <div class="col-md-6">
		       <div class="form-group">
			       	<label for="storeId">Vehicle Fuel</label>
			       	<input type="text" class="form-control" id="vehicleFuel">	
		        </div>
	        </div>
        </div>     
        
        <div class="row">	
        	<div class="col-md-6">
		        <div class="form-group">
			       	<label for="vehicleCapacity">Vehicle Capacity</label>
			       	<input type="text" class="form-control" id="vehicleCapacity">	
		        </div>
	        </div>
	        
	       <div class="col-md-6">
		       <div class="form-group">
			       	<label for="vehicleRentalCost">Vehicle Rental Cost</label>
			       	<input type="text" class="form-control" id="vehicleRentalCost">	
		        </div>
	        </div>
        </div>    
        
        <div class="row">	
        	<div class="col-md-6">
		        <div class="form-group">
			       	<label for="vehicleModel">Vehicle Capacity</label>
			       	<input type="text" class="form-control" id="vehicleModel">	
		        </div>
	        </div>
	        
	       <div class="col-md-6">
		       <div class="form-group">
			       	<label for="vehicleType">Vehicle Type</label>
			       	<input type="text" class="form-control" id="vehicleType">	
		        </div>
	        </div>
        </div>    
        
        <div class="row">	
        	<div class="col-md-6">
		        <div class="form-group">
			       	<label for="vehicleSeatHeight">Vehicle Seat Height</label>
			       	<input type="text" class="form-control" id="vehicleSeatHeight">	
		        </div>
	        </div>
	        
	       <div class="col-md-6">
		       <div class="form-group">
			       	<label for="vehicleLuggageSupport">Vehicle Luggage Support</label>
			       	<input type="text" class="form-control" id="vehicleLuggageSupport">	
		        </div>
	        </div>
        </div>  
        
        <div class="row">	
        	<div class="col-md-6">
		        <div class="form-group">
			       	<label for="vehicleSeatNo">Vehicle Seat No</label>
			       	<input type="text" class="form-control" id="vehicleSeatNo">	
		        </div>
	        </div>
	        
	      <div class="col-md-6">
		      <div class="form-group">
			       	<label for="vehicleDoorNumber">Vehicle Door No</label>
			       	<input type="text" class="form-control" id="vehicleDoorNumber">	
		        </div>
	        </div>
        </div>    
        
         
        <div class="row">	
        	<div class="col-md-6">
		        <div class="form-group">
			       	<label for="cityId">City</label>
			       	<input type="text" class="form-control" id="cityId">	
		        </div>
	       </div>
        </div>    
               
        <button id="updateButton" class="btn btn-primary">Save</button>
		<a href="http://localhost:8080/carRental/vehicles/" class="btn btn-danger">Back</a>      
	 </div>
	</body>

 <script>

	
</script>   
</html>