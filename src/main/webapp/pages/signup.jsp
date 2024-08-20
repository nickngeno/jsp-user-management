<%@ page import="com.kimmy.model.State" %>
<%@ page import="com.kimmy.model.City" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kimmy.model.Country" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .error { color: red; }
    </style>
    <script>
        function validateForm() {
            var password = document.forms["signupForm"]["password"].value;
            var confirmPassword = document.forms["signupForm"]["confirm_password"].value;
            if (password !== confirmPassword) {
                document.getElementById("errorMsg").innerHTML = "Passwords do not match!";
                return false;
            }
            return true;
        }

        function updateStates() {
            var countryId = document.getElementById("country").value;
            fetch("StateServlet?countryId=" + countryId)
                .then(response => response.json())
                .then(data => {
                    var stateSelect = document.getElementById("state");
                    stateSelect.innerHTML = "<option value=''>Select State</option>";
                    data.forEach(state => {
                        console.log({state});
                        stateSelect.innerHTML += `<option value='${state.id}'>${state.name}</option>`;
                    });
                });
        }

        function updateCities() {
            console.log("updating cities ......")
            var stateId = document.getElementById("state").value;
            fetch("CityServlet?stateId=" + stateId)
                .then(response => response.json())
                .then(data => {
                    var citySelect = document.getElementById("city");
                    citySelect.innerHTML = "<option value=''>Select City</option>";
                    data.forEach(city => {
                        console.log({city});
                        citySelect.innerHTML += `<option value='${city.id}'>${city.name}</option>`;
                    });
                })
                .catch(error => console.error('Error fetching cities:', error));

        }
    </script>
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Users Dashboard</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/pages/signup.jsp">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/allUsers">All Users</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <h1 class="text-center mb-4">Sign Up</h1>
    <form name="signupForm" action="${pageContext.request.contextPath}/Signup" method="post" class="needs-validation" novalidate onsubmit="return validateForm()">
        <div class="row mb-3">
            <div class="col-md-6">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
                <div class="invalid-feedback">
                    Please enter your name.
                </div>
            </div>
            <div class="col-md-6">
                <label for="email" class="form-label">Email Address</label>
                <input type="email" class="form-control" id="email" name="email" required>
                <div class="invalid-feedback">
                    Please enter a valid email address.
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-md-4">
                <label for="country" class="form-label">Country</label>
                <select class="form-select" id="country" name="country" onchange="updateStates()">
                    <option value="">Select Country</option>
                    <%
                        List<Country> countries = (List<Country>) request.getAttribute("countries");
                        if (countries != null) {
                            for (Country country : countries) {
                                out.println("<option value='" + country.getId() + "'>" + country.getName() + "</option>");
                            }
                        }
                    %>
                </select>
                <div class="invalid-feedback">
                    Please select your country.
                </div>
            </div>
            <div class="col-md-4">
                <label for="state" class="form-label">State</label>
                <select class="form-select" id="state" name="state" onchange="updateCities()">
                    <option value="">Select State</option>
                </select>
                <div class="invalid-feedback">
                    Please select your state.
                </div>
            </div>
            <div class="col-md-4">
                <label for="city" class="form-label">City</label>
                <select class="form-select" id="city" name="city" >
                    <option value="">Select City</option>
                </select>
                <div class="invalid-feedback">
                    Please select your city.
                </div>
            </div>
        </div>
        <div class="mb-3">
            <label for="house_number" class="form-label">House/Flat/Block Number</label>
            <input type="text" class="form-control" id="house_number" name="house_number" required>
            <div class="invalid-feedback">
                Please enter your house/flat/block number.
            </div>
        </div>
        <div class="mb-3">
            <label for="phone_number" class="form-label">Phone Number</label>
            <input type="text" class="form-control" id="phone_number" name="phone_number" required>
            <div class="invalid-feedback">
                Please enter your phone number.
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-md-6">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
                <div class="invalid-feedback">
                    Please enter your password.
                </div>
            </div>
            <div class="col-md-6">
                <label for="confirm_password" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="confirm_password" name="confirm_password" required>
                <div class="invalid-feedback">
                    Please confirm your password.
                </div>
            </div>
        </div>
        <div id="errorMsg" class="error"></div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary btn-block">Register</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    (function () {
        'use strict'

        var forms = document.querySelectorAll('.needs-validation')

        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })();
</script>
</body>
</html>
