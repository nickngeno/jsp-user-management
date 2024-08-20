<%@ page import="com.kimmy.model.Student" %>
<%@ page import="com.kimmy.model.User" %>
<!DOCTYPE html>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="allUsers">Users Dashboard</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="allUsers">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h2>User Record</h2>
    <div class="row">
        <%
            User user = (User) request.getAttribute("user");
        %>
        <form action="allUsers" method="post">
            <input type="hidden" name="_method" value="put">

            <div class="mb-3">
                <label for="id" class="form-label">ID:</label>
                <input type="text" disabled class="form-control" id="id" value="<%= user.getId()%>"
                       aria-describedby="userId">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%=user.getName()%>"
                       aria-describedby="name">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Name:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%=user.getEmail()%>"
                       aria-describedby="email">
            </div>
            <div class="mb-3">
                <label for="phoneNo" class="form-label">Phone No:</label>
                <input type="text" class="form-control" id="phoneNo" name="phoneNo" value="<%= user.getPhoneNumber()%>"
                       aria-describedby="phoneNo">
            </div>
            <div class="mb-3">
                <label for="houseNo" class="form-label">House No:</label>
                <input type="text" class="form-control" id="houseNo" name="houseNo" value="<%= user.getHouseNumber()%>"
                       aria-describedby="houseNo">
            </div>
            <div class="mb-3">
                <label for="country" class="form-label">Country:</label>
                <input type="text" class="form-control" id="country" name="country" value="<%= user.getCountry()%>"
                       aria-describedby="country">
            </div>
            <div class="mb-3">
                <label for="state" class="form-label">State:</label>
                <input type="text" class="form-control" id="state" name="state" value="<%= user.getState()%>"
                       aria-describedby="state">
            </div>
            <div class="mb-3">
                <label for="city" class="form-label">City:</label>
                <input type="text" class="form-control" id="city" name="city" value="<%= user.getCity()%>"
                       aria-describedby="city">
            </div>
            <div class="d-flex me-2">
                <input type="hidden" name="userId" value="<%=user.getId()%>"/>
                <button type="submit" class="btn btn-info">Update</button>
                <form action="${pageContext.request.contextPath}/allUsers" method="GET">
                    <input type="hidden" name="userId"/>
                    <button type="submit" class="btn btn-link">Close</button>
                </form>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>