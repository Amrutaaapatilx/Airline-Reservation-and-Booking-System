<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>Ticket</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header text-center">

            <h2>Flight Ticket</h2>

        </div>

        <div class="card-body">

            <h4>Booking ID: ${booking.id}</h4>

            <p>
                Flight:
                ${booking.flight.flightName}
            </p>

            <p>
                Route:
                ${booking.flight.source}
                →
                ${booking.flight.destination}
            </p>

            <p>
                Boarding:
                ${booking.flight.departureTime}
            </p>

            <p>
                Landing:
                ${booking.flight.arrivalTime}
            </p>

            <p>
                Total Amount:
                ₹ ${booking.totalAmount}
            </p>

            <p>
                Status:
                ${booking.bookingStatus}
            </p>

            <hr>

            <h5>Passengers</h5>

            <table class="table table-bordered">

                <thead>

                <tr>

                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Seat</th>

                </tr>

                </thead>

                <tbody>

                <c:forEach items="${booking.passengers}"
                           var="passenger">

                    <tr>

                        <td>${passenger.name}</td>
                        <td>${passenger.age}</td>
                        <td>${passenger.gender}</td>
                        <td>${passenger.seatNumber}</td>

                    </tr>

                </c:forEach>

                </tbody>

            </table>

        </div>

    </div>

</div>

</body>
</html>