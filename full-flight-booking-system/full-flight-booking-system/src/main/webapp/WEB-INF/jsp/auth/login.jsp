<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Login</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-5">

            <div class="card shadow">

                <div class="card-header text-center">

                    <h3>Flight Booking Login</h3>

                </div>

                <div class="card-body">

                    <form action="/login"
                          method="post">

                        <div class="mb-3">

                            <label>Email</label>

                            <input type="email"
                                   name="username"
                                   class="form-control"
                                   required>

                        </div>

                        <div class="mb-3">

                            <label>Password</label>

                            <input type="password"
                                   name="password"
                                   class="form-control"
                                   required>

                        </div>

                        <button type="submit"
                                class="btn btn-primary w-100">

                            Login

                        </button>

                    </form>

                    <div class="mt-3 text-center">

                        <a href="/signup">

                            Create Account

                        </a>

                    </div>

                    <div class="mt-3 text-center text-danger">

                        ${error}

                    </div>

                    <div class="mt-3 text-center text-success">

                        ${success}

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>