<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Edit Flight</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">

            <h3>Edit Flight</h3>

        </div>

        <div class="card-body">

            <form action="/admin/update-flight"
                  method="post">

                <input type="hidden"
                       name="id"
                       value="${flight.id}">

                <div class="mb-3">

                    <label>Flight Name</label>

                    <input type="text"
                           name="flightName"
                           value="${flight.flightName}"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label>Source</label>

                    <input type="text"
                           name="source"
                           value="${flight.source}"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label>Destination</label>

                    <input type="text"
                           name="destination"
                           value="${flight.destination}"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label>Total Seats</label>

                    <input type="number"
                           name="totalSeats"
                           value="${flight.totalSeats}"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label>Available Seats</label>

                    <input type="number"
                           name="availableSeats"
                           value="${flight.availableSeats}"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label>Ticket Price</label>

                    <input type="number"
                           step="0.01"
                           name="ticketPrice"
                           value="${flight.ticketPrice}"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label>Departure Time</label>

                    <input type="datetime-local"
                           name="departureTime"
                           value="${flight.departureTime}"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label>Arrival Time</label>

                    <input type="datetime-local"
                           name="arrivalTime"
                           value="${flight.arrivalTime}"
                           class="form-control">

                </div>

                <button type="submit"
                        class="btn btn-primary">

                    Update Flight

                </button>

            </form>

        </div>

    </div>

</div>

</body>
</html>