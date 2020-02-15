<html>
<%@include file="../partials/head.html" %>

<body>
<%@include file="../partials/navigation.html" %>

    <div class="container">
        <div class="content">
            <div class="row p-4">
                <div class="col-md-10">
                    <h2>Active Rentals</h2>
                </div>
                <div class="col-md-2">
                    <a class="btn btn-primary" href="http://localhost:8080/carRental/rental/search.jsp" role="button">Make New Rental</a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="profile">
                        <table id="userdata" class="table table-striped">
                            <thead class="thead-dark">
                                <th>ID</th>
                                <th>Vlihicle Plates</th>
                                <th>Client</th>
                                <th>Pickup Location</th>
                                <th>Pickup Date</th>
                                <th>Return Location</th>
                                <th>Return Date</th>
                                <th>Cost</th>
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
            url: "http://localhost:8080/carRental/webapi/rental",
            type: "GET",
            success: function(data){
                $.each(data, function(f) {
                    console.log();
                    var tblRow = "<tr>"
                        + "<td>" + data[f].id + "</td>"
                        + "<td>" + data[f].vehicle.licence + "</td>"
                        + "<td>" + data[f].client.name + " " +  data[f].client.surname  + "</td>"
                        + "<td>" + data[f].pickupLocation.name + "</td>"
                        + "<td>" + data[f].pickupDatetime + "</td>"
                        + "<td>" + data[f].returnLocation.name + "</td>"
                        + "<td>" + data[f].returnDatetime + "</td>"
                        + "<td>" + data[f].totalCost + "</td>"
                        + "<td>"
                        + "<button id='deleteButton"+ data[f].id +"' class='btn btn-danger'>Cancel</button></td>"
                        + "</tr>";

                    $(tblRow).appendTo("#userdata tbody");

                    $("#deleteButton" + data[f].id).on("click", function(){
                        $.ajax({
                            url: "http://localhost:8080/carRental/webapi/rental/" + data[f].id,
                            type: "delete",
                            success : function(data){
                                location.reload();
                            },
                            error: function(data) {
                                alert("There was an Error!");
                            }
                        });
                    });
                });
            },
            error: function(data) {
                alert("There was an Error!");
            }
        })
    };

</script>
</html>