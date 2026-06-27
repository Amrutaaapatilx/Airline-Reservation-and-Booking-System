<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Flight Details</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">

            <h3>Flight Details</h3>

        </div>

        <div class="card-body">

            <h4>${flight.flightName}</h4>

            <p>
                Route:
                ${flight.source}
                →
                ${flight.destination}
            </p>

            <p>
                Price:
                ₹ ${flight.ticketPrice}
            </p>

            <p>
                Available Seats:
                ${flight.availableSeats}
            </p>

            <p>
                Departure:
                ${flight.departureTime}
            </p>

            <p>
                Arrival:
                ${flight.arrivalTime}
            </p>

            <a href="/booking/${flight.id}"
               class="btn btn-success">

                Book Ticket

            </a>

        </div>

    </div>

</div>

</body>
</html>