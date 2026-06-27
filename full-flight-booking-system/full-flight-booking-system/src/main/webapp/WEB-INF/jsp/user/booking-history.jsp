<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>Booking History</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <h2 class="mb-4">My Bookings</h2>

    <table class="table table-bordered table-hover">

        <thead class="table-dark">

        <tr>

            <th>ID</th>
            <th>Flight</th>
            <th>Total</th>
            <th>Status</th>
            <th>Actions</th>

        </tr>

        </thead>

        <tbody>

        <c:forEach items="${bookings}"
                   var="booking">

            <tr>

                <td>${booking.id}</td>

                <td>
                    ${booking.flight.flightName}
                </td>

                <td>
                    ₹ ${booking.totalAmount}
                </td>

                <td>
                    ${booking.bookingStatus}
                </td>

                <td>

                    <a href="/booking/ticket/${booking.id}"
                       class="btn btn-primary btn-sm">

                        Ticket

                    </a>

                    <a href="/booking/cancel/${booking.id}"
                       class="btn btn-danger btn-sm">

                        Cancel

                    </a>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

</body>
</html>