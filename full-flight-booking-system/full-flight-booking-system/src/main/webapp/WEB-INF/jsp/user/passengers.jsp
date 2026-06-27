<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>Passengers</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="d-flex justify-content-between mb-4">

        <h2>Passengers</h2>

        <a href="/passenger/add"
           class="btn btn-success">

            Add Passenger

        </a>

    </div>

    <table class="table table-bordered table-hover">

        <thead class="table-dark">

        <tr>

            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Seat</th>
            <th>Actions</th>

        </tr>

        </thead>

        <tbody>

        <c:forEach items="${passengers}"
                   var="passenger">

            <tr>

                <td>${passenger.id}</td>
                <td>${passenger.name}</td>
                <td>${passenger.age}</td>
                <td>${passenger.gender}</td>
                <td>${passenger.seatNumber}</td>

                <td>

                    <a href="/passenger/edit/${passenger.id}"
                       class="btn btn-warning btn-sm">

                        Edit

                    </a>

                    <a href="/passenger/delete/${passenger.id}"
                       class="btn btn-danger btn-sm">

                        Delete

                    </a>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

</body>
</html>