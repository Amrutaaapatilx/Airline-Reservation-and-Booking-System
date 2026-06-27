<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Booking</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">

            <h3>Book Ticket</h3>

        </div>

        <div class="card-body">

            <form action="/booking/calculate-payment"
                  method="post">

                <input type="hidden"
                       name="flightId"
                       value="${flight.id}">

                <div class="mb-3">

                    <label>Passenger Count</label>

                    <input type="number"
                           name="passengerCount"
                           class="form-control"
                           min="1"
                           required>

                </div>

                <button type="submit"
                        class="btn btn-primary">

                    Continue

                </button>

            </form>

        </div>

    </div>

</div>

</body>
</html>