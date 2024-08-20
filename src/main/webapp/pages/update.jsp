<%@ page import="com.kimmy.model.User" %>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="container">
    <h2>User Record</h2>
    <div class="row">
        <%
            User user = (User) request.getAttribute("user");
        %>
        <form action="UserServlet" method="post">
            <input type="hidden" name="_method" value="put">

            <div class="mb-3">
                <label for="userId" class="form-label">ID:</label>
                <input type="text" disabled class="form-control" id="userId" name="userId" value="<%=user.getId()%>"
                       aria-describedby="userId">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%=user.getName()%>"
                       aria-describedby="name">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
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
                       aria-describedby="country" disabled>
            </div>
            <div class="mb-3">
                <label for="state" class="form-label">State:</label>
                <input type="text" class="form-control" id="state" name="state" value="<%= user.getState()%>"
                       aria-describedby="state" disabled>
            </div>
            <div class="mb-3">
                <label for="city" class="form-label">City:</label>
                <input type="text" class="form-control" id="city" name="city" value="<%= user.getCity()%>"
                       aria-describedby="city" disabled>
            </div>
            <div class="d-flex me-2">
                <input type="hidden" name="userId" value="<%=user.getId()%>"/>
                <button type="submit" class="btn btn-info">Update</button>
                <a class="btn btn-link" href="${pageContext.request.contextPath}/UserServlet">Close</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>