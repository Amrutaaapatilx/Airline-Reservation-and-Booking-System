<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Payment</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">

            <h3>Payment Summary</h3>

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
                Passenger Count:
                ${passengerCount}
            </p>

            <p>
                Total Amount:
                ₹ ${totalAmount}
            </p>
            <form action="/booking/confirm-booking"
                  method="post">

                <input type="hidden"
                       name="flightId"
                       value="${flight.id}">

                <input type="hidden"
                       name="passengerCount"
                       value="${passengerCount}">

                <c:forEach begin="1"
                           end="${passengerCount}"
                           var="i">

                    <div class="border p-3 mb-3">

                        <h5>Passenger ${i}</h5>

                        <input type="text"
                               name="passengerNames"
                               class="form-control mb-2"
                               placeholder="Passenger Name"
                               required>

                        <input type="number"
                               name="passengerAges"
                               class="form-control mb-2"
                               placeholder="Passenger Age"
                               required>

                        <select name="passengerGenders"
                                class="form-control mb-2">

                            <option>Male</option>
                            <option>Female</option>

                        </select>

                    </div>

                </c:forEach>

                <button type="submit"
                        class="btn btn-success">

                    Confirm Booking

                </button>

            </form>

        </div>

    </div>

</div>

</body>
</html>