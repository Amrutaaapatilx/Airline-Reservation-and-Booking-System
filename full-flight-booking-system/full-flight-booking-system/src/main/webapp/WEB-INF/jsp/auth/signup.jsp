<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Signup</title>

    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header text-center">

                    <h3>User Signup</h3>

                </div>

                <div class="card-body">

                    <form action="/signup"
                          method="post">

                        <div class="mb-3">

                            <label>Full Name</label>

                            <input type="text"
                                   name="name"
                                   class="form-control"
                                   required>

                        </div>

                        <div class="mb-3">

                            <label>Email</label>

                            <input type="email"
                                   name="email"
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
                                class="btn btn-success w-100">

                            Signup

                        </button>

                    </form>

                    <div class="mt-3 text-center">

                        <a href="/">

                            Already have an account?

                        </a>

                    </div>

                    <div class="mt-3 text-center text-danger">

                        ${error}

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>