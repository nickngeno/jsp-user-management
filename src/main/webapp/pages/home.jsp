<%@ page import="java.util.List" %>
<%@ page import="com.kimmy.model.Student" %>
<%@ page import="com.kimmy.model.User" %>
<!DOCTYPE html>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>--%>
<%--<%@include file="index.jsp"  %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
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
                    <a class="nav-link active" aria-current="page" href="allUsers">All Users</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h2>All Users</h2>
    <div class="col-8">
        <form class="d-flex" role="search" action="fetch">
            <input class="form-control me-4" name="query" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>State</th>
                <th>City</th>
                <th>House No</th>
                <th>Phone No</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                if (!users.isEmpty()) {
                    for (User user : users) {
            %>
            <tr>
                <td><%=user.getId() %>
                </td>
                <td><%=user.getName() %>
                </td>
                <td><%=user.getEmail()%>
                </td>
                <td><%=user.getCountry() %>
                </td>
                <td><%=user.getState() %>
                </td>
                <td><%=user.getCity() %>
                </td>
                <td><%=user.getHouseNumber() %>
                </td>
                <td><%=user.getPhoneNumber() %>
                </td>
                <td class="d-flex">
                    <form class="me-2" action="result" method="GET">
                        <input type="hidden" name="id" value=<%=user.getId()%> />
                        <button type="submit" value="submit" class="btn btn-secondary">View</button>
                    </form>
                    <form action="allUsers" method="POST">
                        <input type="hidden" name="userId" value=<%=user.getId()%>/>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <p>No Users found.</p>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>