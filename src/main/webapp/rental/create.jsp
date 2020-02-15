<html>
<%@include file="../partials/head.html" %>

<body>
<%@include file="../partials/navigation.html" %>

<div class="container">
    <div class="content">
        <div class="card">
            <div class="card-body">
          
                <h2>Rental Info</h2>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="delivery_place">Delivery Place</label>
                            <input class="form-control" type="text" id="delivery_place" readonly value='<%= request.getParameter("delivery_place") %>'>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="delivery_date">Delivery Date</label>
                            <input class="form-control" type="text" id="delivery_date" readonly value='<%= request.getParameter("delivery_date") %>'>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="return_place">Return Place</label>
                            <input class="form-control" type="text" id="return_place" readonly value='<%= request.getParameter("return_place") %>'>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="return_date">Return Date</label>
                            <input class="form-control" type="text" id="return_date" readonly value='<%= request.getParameter("return_date") %>'>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="cost">Total Cost (Euro)</label>
                            <input type="number" class="form-control" id="cost" readonly value='<%= request.getParameter("cost") %>'>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-body">
                <h2>Vehicle Info</h2>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="licence">Licence No</label>
                            <input class="form-control" type="text" id="licence" disabled>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="vehicle_type">Vehicle Type</label>
                            <input class="form-control" type="text" id="vehicle_type" disabled>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="vehicle_model">Vehicle Model</label>
                            <input class="form-control" type="text" id="vehicle_model" disabled>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="vehicle_cost">Vehicle Cost / Day (Euro)</label>
                            <input class="form-control" type="text" id="vehicle_cost" disabled>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-body">
                <h2>Customer Info</h2>
                <nav>
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Existing Client</a>
                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">New Client</a>
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <div class="existing-client">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="existingClient">Clients</label>
                                        <select class="form-control" id="existingClient">
                                            <option selected disabled>Select Client</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="clientID">ID</label>
                                    <input type="text" class="form-control" id="clientID">
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="drivingLicence">Driving Licence</label>
                                    <input type="text" class="form-control" id="drivingLicence">
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
                                    <label for="surname">Surname</label>
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
                    </div>
                </div>

                <button id="finalizeButton" class="btn btn-primary">Finalize</button>

            </div>
        </div>

    </div>
</div>
</body>

<script>
    window.onload = function() {
        $.ajax({
            url: "http://localhost:8080/carRental/webapi/vehicles/<%= request.getParameter("licence") %>",
            type: "GET",
            success: function(data){
                $('#licence').val(data.licence);
                $('#vehicle_model').val(data.model);
                $('#vehicle_fuel').val(data.fuel);
                $('#vehicle_cost').val(data.cost);$('#vehicle_type').val(data.vehicle_type);

            },
            error: function(data) {
                alert("There was an Error!");
            }
        });
        
        $.ajax({
            url: "http://localhost:8080/carRental/webapi/cities/<%= request.getParameter("delivery_place") %>",
            type: "GET",
            success: function(data){
                $('#delivery_place').val(data.name);
            },
            error: function(data) {
                alert("There was an Error!");
            }
        });
        
        $.ajax({
            url: "http://localhost:8080/carRental/webapi/cities/<%= request.getParameter("return_place") %>",
            type: "GET",
            success: function(data){
                $('#return_place').val(data.name);
            },
            error: function(data) {
                alert("There was an Error!");
            }
        });

        $.ajax({
            url: "http://localhost:8080/carRental/webapi/clients",
            type: "GET",
            success: function(data){
                data.map( function (client){
                    $("#existingClient").append("<option value=" + client.id + ">" + client.name + " " + client.surname + "</option>")
                })
            },
            error: function(data) {
                alert("There was an Error!");
            }
        })

    };

    $("#finalizeButton").on("click", function(){
        $.ajax({
            url: "http://localhost:8080/carRental/webapi/rental/create",
            type: "POST",
            dataType: 'json',
            contentType: 'application/x-www-form-urlencoded',
            data: {
                "licence": $('#licence').val(),
                "delivery_place": <%= request.getParameter("delivery_place") %>,
                "delivery_date": $('#delivery_date').val(),
                "return_place": <%= request.getParameter("return_place") %>,
                "return_date": $('#return_date').val(),
                "cost": $('#cost').val(),
                "existingClientID": $('#existingClient').val(),
                "name": $('#name').val(),
                "surname": $('#surname').val(),
                "drivingLicence": $('#drivingLicence').val(),
                "email": $('#email').val(),
                "tel": $('#tel').val(),
                "address": $('#address').val(),
                "clientID": $('#clientID').val(),
            },
            success: function(data){
                window.location.replace('http://localhost:8080/carRental/rental');
            },
            error: function(data) {
                alert("There was an Error!");
            }
        });
    });
</script>
</html>