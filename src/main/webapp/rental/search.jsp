<html>
<%@include file="../partials/head.html" %>

<body>
<%@include file="../partials/navigation.html" %>

<div class="container">
    <div class="content">
        <div class="row p-4">
            <div class="col-md-10">
                <h2>Search Criteria</h2>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="delivery_place">Delivery Place</label>
                            <select class="form-control" id="delivery_place">
                                <option value="null" disabled selected>Please select a location...</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="datetimepicker1">Delivery Date</label>
                            <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                                <input type="text" id="delivery_date" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
                                <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="return_place">Return Place</label>
                            <select class="form-control" id="return_place">
                                <option value="null" disabled selected>Please select a location...</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="datetimepicker2">Return Date</label>
                            <div class="input-group date" id="datetimepicker2" data-target-input="nearest">
                                <input type="text" id="return_date" class="form-control datetimepicker-input" data-target="#datetimepicker2"/>
                                <div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="vehicle_type">Vehicle Type</label>
                            <select class="form-control" id="vehicle_type" name="type">
                                <option disabled selected>Please Select</option>
                                <option>Scooter</option>
                                <option>Motorcycle</option>
                                <option>Small Car</option>
                                <option>Medium Car</option>
                                <option>Big Car</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="cost">Max Cost/Day</label>
                            <input type="number" class="form-control" id="cost" placeholder="Euros/Day">
                        </div>
                    </div>
                </div>

                <button id="searchButton" class="btn btn-primary">Search</button>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="profile">
                    <table id="userdata" class="table">
                        <thead>
                        <th>Licence</th>
                        <th>Store</th>
                        <th>Location</th>
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
</div>
</body>

<script>
    window.onload = function() {
        $.ajax({
            url: "http://localhost:8080/carRental/webapi/cities",
            type: "GET",
            success: function(data){
                data.map( (city) => {
                    $("#delivery_place").append("<option value=" + city.id + ">" + city.name + "</option>");
                    $("#return_place").append("<option value=" + city.id + ">" + city.name + "</option>");
                })
            },
            error: function(data) {
                alert("There was an Error!");
            }
        })
    };

    $('#datetimepicker1').datetimepicker({
        format:'DD/MM/YYYY HH:mm'
    });

    $('#datetimepicker2').datetimepicker({
        format: 'DD/MM/YYYY HH:mm'
    });

    $("#searchButton").on("click", function(){

        $.ajax({
            url: "http://localhost:8080/carRental/webapi/vehicles/search",
            type: "POST",
            dataType: 'json',
            contentType: 'application/x-www-form-urlencoded',
            data: {
                "vehicle_type": $('#vehicle_type').val(),
                "delivery_place": $('#delivery_place').val(),
                "delivery_date": $('#delivery_date').val(),
                "return_place": $('#return_place').val(),
                "return_date": $('#return_date').val(),
                "cost": $('#cost').val(),
            },
            success: function(data){
                $('#userdata tbody').empty();

                $.each(data, function(f) {
                    console.log();
                    var tblRow = "<tr>"
                        + "<td>" + data[f].licence + "</td>" + "<td>" + data[f].model + "</td>"
                        + "<td>" + data[f].fuel + "</td>" + "<td>" + data[f].vehicle_type + "</td>"
                        + "<td>" + data[f].model + "</td>" + "<td>" + data[f].cost + "</td>"
                        + "<td>"
                        + "<a type='button' href='http://localhost:8080/carRental/rental/create.jsp?licence="  + data[f].licence +
                        "&delivery_place=" + $('#delivery_place').val() + "&delivery_date=" + $('#delivery_date').val()
                        + "&return_place=" + $('#return_place').val() + "&return_date=" + $('#return_date').val()
                        + "&cost=" + $('#cost').val() + "'  class='btn btn-primary mr-2'>"
                        + "Rent"
                        + "</a>"
                        + "</td></tr>";
                    $(tblRow).appendTo("#userdata tbody");
                });
            },
            error: function(data) {
                alert("There was an Error!");
            }
        });
    });

</script>
</html>