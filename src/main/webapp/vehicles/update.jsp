<html>
<%@include file="../partials/head.html" %>

<body>
<%@include file="../partials/navigation.html" %>

<div class="container">
	<div class="row p-4">
		<h2>Update Vehicle:</h2>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="licence">License Number</label>
				<input type="text" class="form-control" id="licence">
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label for="vehicle_type">Vehicle Type</label>
				<select class="form-control" id="vehicle_type">
					<option disabled selected>Please Select</option>
					<option>Scooter</option>
					<option>Motorcycle</option>
					<option>Small Car</option>
					<option>Medium Car</option>
					<option>Big Car</option>
				</select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="model">Vehicle Model</label>
				<input type="text" class="form-control" id="model">
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label for="fuel">Vehicle Fuel</label>
				<select class="form-control" id="fuel">
					<option disabled selected>Please Select</option>
					<option>Gas</option>
					<option>Petrol</option>
				</select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="capacity">Vehicle Capacity</label>
				<input type="number" class="form-control" id="capacity">
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label for="cost">Rental Cost</label>
				<input type="number" min="0" class="form-control" id="cost" placeholder="Euros/Day">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="seatHeight">Vehicle Seat Height</label>
				<input type="number" min="0" class="form-control" id="seatHeight" placeholder="(cm)">
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label for="luggage">Vehicle Luggage Support</label>
				<select class="form-control" id="luggage">
					<option disabled selected>Please Select</option>
					<option>Yes</option>
					<option>No</option>
				</select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="seats">Vehicle Seat No</label>
				<input type="number" min="1" class="form-control" id="seats">
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label for="doors">Vehicle Door No</label>
				<input type="number" min="1" class="form-control" id="doors">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="store">Store</label>
				<select class="form-control" id="store">
				</select>
			</div>
		</div>
	</div>

	<button id="updateButton" class="btn btn-primary">Save</button>
	<a href="http://localhost:8080/carRental/vehicles/" class="btn btn-danger">Back</a>
</div>
</body>

<script>
	$(document).ready(function($){
		window.onload = function() {
			$.ajax({
				url: "http://localhost:8080/carRental/webapi/stores",
				type: "GET",
				success: function(data){
					let stores = data;

					stores.map( (store) => {
						$("#store").append("<option value=" + store.id + ">" + store.name + "</option>")
					})
				},
				error: function(data) {
					alert("There was an Error!");
				}
			})
		};

		$.getJSON('http://localhost:8080/carRental/webapi/vehicles/<%= request.getParameter("id") %>', function(data) {
			$("#licence").val(data.licence);
			$("#model").val(data.model);
			$("#capacity").val(data.capacity);
			$("#cost").val(data.cost);
			$("#fuel").append("<option value='" + data.fuel + "' selected>" + data.fuel + "</option>");
			$("#vehicle_type").append("<option value='" + data.vehicle_type + "' selected>" + data.vehicle_type + "</option>");

			if(data.vehicle_type === "Scooter" || data.vehicle_type === "Motorcycle"){
				$("#luggage").append("<option value='" + data.luggage + "' selected>" + data.luggage + "</option>");
				$("#seatHeight").val(data.seatHeight);
			}else{
				$("#doors").val(data.doors);
				$("#seats").val(data.seats);
			}
		});

		$("#updateButton").on("click", function(){
			$.ajax({
				url: "http://localhost:8080/carRental/webapi/vehicles/<%= request.getParameter("id") %>",
				type: "PUT",
				dataType: 'json',
				contentType: 'application/x-www-form-urlencoded',
				data: {
					"licence": $('#licence').val(),
					"model": $('#model').val(),
					"vehicle_type": $('#vehicle_type').val(),
					"fuel": $('#fuel').val(),
					"capacity": $('#capacity').val(),
					"cost": $('#cost').val(),
					"seats": $('#seats').val(),
					"doors": $('#doors').val(),
					"seatHeight": $('#seatHeight').val(),
					"luggage": $('#luggage').val(),
					"store": $('#store').val(),
				},
				success: function(data){
					window.location.replace('http://localhost:8080/carRental/vehicles');
				},
				error: function(data) {
					alert("There was an Error!");
				}
			});
		});
	});

</script>
</html>