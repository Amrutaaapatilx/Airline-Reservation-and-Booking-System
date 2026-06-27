<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>Flights</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-4">

    <div class="d-flex justify-content-between mb-4">

        <h2>Available Flights</h2>

        <div>

            <a href="/booking/history"
               class="btn btn-primary">

                Booking History

            </a>

            <a href="/logout"
               class="btn btn-danger">

                Logout

            </a>

        </div>

    </div>

    <form action="/flights/search"
          method="get"
          class="row mb-4">

        <div class="col-md-4">

            <input type="text"
                   name="source"
                   class="form-control"
                   placeholder="Source">

        </div>

        <div class="col-md-4">

            <input type="text"
                   name="destination"
                   class="form-control"
                   placeholder="Destination">

        </div>

        <div class="col-md-4">

            <button type="submit"
                    class="btn btn-success w-100">

                Search Flights

            </button>

        </div>

    </form>

    <div class="row">

        <c:forEach items="${flights}"
                   var="flight">

            <div class="col-md-4 mb-4">

                <div class="card shadow">

                    <div class="card-body">

                        <h4>${flight.flightName}</h4>

                        <p>
                            ${flight.source}
                            →
                            ${flight.destination}
                        </p>

                        <p>
                            Price:
                            ₹ ${flight.ticketPrice}
                        </p>

                        <p>
                            Seats:
                            ${flight.availableSeats}
                        </p>

                        <a href="/flights/details/${flight.id}"
                           class="btn btn-primary">

                            View Details

                        </a>

                    </div>

                </div>

            </div>

        </c:forEach>

    </div>

</div>

</body>
</html>