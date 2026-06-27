<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Verify OTP</title>

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

                    <h3>OTP Verification</h3>

                </div>

                <div class="card-body">

                    <form action="/verify-otp"
                          method="post">

                        <div class="mb-3">

                            <label>Enter OTP</label>

                            <input type="number"
                                   name="otp"
                                   class="form-control"
                                   required>

                        </div>

                        <button type="submit"
                                class="btn btn-primary w-100">

                            Verify OTP

                        </button>

                    </form>

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