<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>Admin Dashboard</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-4">

    <div class="d-flex justify-content-between mb-4">

        <h2>Admin Dashboard</h2>

        <div>

            <a href="/admin/bookings"
               class="btn btn-primary">

                View Bookings

            </a>

            <a href="/logout"
               class="btn btn-danger">

                Logout

            </a>

        </div>

    </div>

    <!-- ADD FLIGHT -->

    <div class="card shadow mb-5">

        <div class="card-header">

            <h4>Add Flight</h4>

        </div>

        <div class="card-body">

            <form action="/admin/add-flight"
                  method="post">

                <div class="row">

                    <div class="col-md-4 mb-3">

                        <label>Flight Name</label>

                        <input type="text"
                               name="flightName"
                               class="form-control"
                               required>

                    </div>

                    <div class="col-md-4 mb-3">

                        <label>Source</label>

                        <input type="text"
                               name="source"
                               class="form-control"
                               required>

                    </div>

                    <div class="col-md-4 mb-3">

                        <label>Destination</label>

                        <input type="text"
                               name="destination"
                               class="form-control"
                               required>

                    </div>

                </div>

                <div class="row">

                    <div class="col-md-3 mb-3">

                        <label>Total Seats</label>

                        <input type="number"
                               name="totalSeats"
                               class="form-control"
                               required>

                    </div>

                    <div class="col-md-3 mb-3">

                        <label>Ticket Price</label>

                        <input type="number"
                               step="0.01"
                               name="ticketPrice"
                               class="form-control"
                               required>

                    </div>

                    <div class="col-md-3 mb-3">

                        <label>Departure Time</label>

                        <input type="datetime-local"
                               name="departureTime"
                               class="form-control"
                               required>

                    </div>

                    <div class="col-md-3 mb-3">

                        <label>Arrival Time</label>

                        <input type="datetime-local"
                               name="arrivalTime"
                               class="form-control"
                               required>

                    </div>

                </div>

                <button type="submit"
                        class="btn btn-success">

                    Add Flight

                </button>

            </form>

        </div>

    </div>

    <!-- FLIGHT TABLE -->

    <div class="card shadow">

        <div class="card-header">

            <h4>All Flights</h4>

        </div>

        <div class="card-body">

            <table class="table table-bordered table-hover">

                <thead class="table-dark">

                <tr>

                    <th>ID</th>
                    <th>Flight</th>
                    <th>Route</th>
                    <th>Price</th>
                    <th>Seats</th>
                    <th>Actions</th>

                </tr>

                </thead>

                <tbody>

                <c:forEach items="${flights}"
                           var="flight">

                    <tr>

                        <td>${flight.id}</td>

                        <td>${flight.flightName}</td>

                        <td>
                            ${flight.source}
                            →
                            ${flight.destination}
                        </td>

                        <td>₹ ${flight.ticketPrice}</td>

                        <td>
                            ${flight.availableSeats}
                            /
                            ${flight.totalSeats}
                        </td>

                        <td>

                            <a href="/admin/edit-flight/${flight.id}"
                               class="btn btn-warning btn-sm">

                                Edit

                            </a>

                            <a href="/admin/delete-flight/${flight.id}"
                               class="btn btn-danger btn-sm">

                                Delete

                            </a>

                        </td>

                    </tr>

                </c:forEach>

                </tbody>

            </table>

        </div>

    </div>

</div>

</body>
</html>