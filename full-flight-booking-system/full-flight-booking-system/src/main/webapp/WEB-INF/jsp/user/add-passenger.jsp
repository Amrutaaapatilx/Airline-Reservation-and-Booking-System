<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Add Passenger</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header">

            <h3>Add Passenger</h3>

        </div>

        <div class="card-body">

            <form action="/passenger/save"
                  method="post">

                <input type="text"
                       name="name"
                       class="form-control mb-3"
                       placeholder="Name">

                <input type="number"
                       name="age"
                       class="form-control mb-3"
                       placeholder="Age">

                <select name="gender"
                        class="form-control mb-3">

                    <option>Male</option>
                    <option>Female</option>

                </select>

                <button type="submit"
                        class="btn btn-success">

                    Save Passenger

                </button>

            </form>

        </div>

    </div>

</div>

</body>
</html>