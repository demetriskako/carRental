<html>
<%@include file="../partials/head.html" %>

<body>
<%@include file="../partials/navigation.html" %>

    <div class="container">
        <div class="content">
            <div class="row p-4">
                <div class="col-md-10">
                    <h2>Search Citeria</h2>
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
                                <label for="cost">Delivery Date</label>
                                <input type="datetime-local" class="form-control" id="cost" placeholder="Euros/Day">
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
                                <label for="return_date">Return Date</label>
                                <input type="datetime-local" class="form-control" id="return_date" placeholder="Euros/Day">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="type">Vehicle Type</label>
                                <select class="form-control" id="type" name="type">
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

                    <button id="seachButton" class="btn btn-primary">Search</button>
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
                let cities = data

                cities.map( (city) => {
                    $("#delivery_place").append("<option value=" + city.id + ">" + city.name + "</option>")
                    $("#return_place").append("<option value=" + city.id + ">" + city.name + "</option>")
                })
            },
            error: function(data) {
                alert("There was an Error!");
            }
        })
    };

</script>
</html>