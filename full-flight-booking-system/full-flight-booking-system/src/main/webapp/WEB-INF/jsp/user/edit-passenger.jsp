<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Edit Passenger</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">

            <h3>Edit Passenger</h3>

        </div>

        <div class="card-body">

            <form action="/passenger/update"
                  method="post">

                <input type="hidden"
                       name="id"
                       value="${passenger.id}">

                <input type="text"
                       name="name"
                       value="${passenger.name}"
                       class="form-control mb-3">

                <input type="number"
                       name="age"
                       value="${passenger.age}"
                       class="form-control mb-3">

                <select name="gender"
                        class="form-control mb-3">

                    <option>Male</option>
                    <option>Female</option>

                </select>

                <input type="text"
                       name="seatNumber"
                       value="${passenger.seatNumber}"
                       class="form-control mb-3">

                <button type="submit"
                        class="btn btn-primary">

                    Update Passenger

                </button>

            </form>

        </div>

    </div>

</div>

</body>
</html>