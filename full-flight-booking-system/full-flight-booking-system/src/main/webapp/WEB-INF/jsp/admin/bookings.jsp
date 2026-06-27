<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>All Bookings</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-4">

    <div class="d-flex justify-content-between mb-4">

        <h2>All Bookings</h2>

        <a href="/admin/dashboard"
           class="btn btn-secondary">

            Back

        </a>

    </div>

    <div class="card shadow">

        <div class="card-body">

            <table class="table table-bordered table-hover">

                <thead class="table-dark">

                <tr>

                    <th>Booking ID</th>
                    <th>User</th>
                    <th>Flight</th>
                    <th>Passengers</th>
                    <th>Total Amount</th>
                    <th>Status</th>
                    <th>Date</th>

                </tr>

                </thead>

                <tbody>

                <c:forEach items="${bookings}"
                           var="booking">

                    <tr>

                        <td>${booking.id}</td>

                        <td>${booking.user.name}</td>

                        <td>

                            ${booking.flight.flightName}

                            <br>

                            ${booking.flight.source}
                            →
                            ${booking.flight.destination}

                        </td>

                        <td>${booking.passengerCount}</td>

                        <td>₹ ${booking.totalAmount}</td>

                        <td>

                            <span class="badge bg-success">

                                ${booking.bookingStatus}

                            </span>

                        </td>

                        <td>${booking.bookingDate}</td>

                    </tr>

                </c:forEach>

                </tbody>

            </table>

        </div>

    </div>

</div>

</body>
</html>