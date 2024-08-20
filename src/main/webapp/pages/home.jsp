<%@ page import="java.util.List" %>
<%@ page import="com.kimmy.model.User" %>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
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
                    <form class="me-2" action="${pageContext.request.contextPath}/ViewServlet" method="GET">
                        <input type="hidden" name="id" value="<%=user.getId()%>"/>
                        <button type="submit" value="submit" class="btn btn-info">View</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/UserServlet" method="POST">
                        <input type="hidden" name="_method" value="delete">
                        <input type="hidden" name="userId" value="<%=user.getId()%>"/>
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
</body>
</html>