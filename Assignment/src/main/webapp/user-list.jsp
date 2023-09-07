<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.address}</td>
                <td>${user.city}</td>
                <td>${user.state}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>
                    <a href="<%= request.getContextPath() %>/edit?id=${user.id}">Edit</a>
                    <a href="<%= request.getContextPath() %>/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="<%= request.getContextPath() %>/add">Add New User</a>
</body>
</html>
