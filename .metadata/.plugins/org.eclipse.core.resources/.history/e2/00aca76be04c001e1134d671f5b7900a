<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
</head>
<body>
    <h2>
        <c:if test="${empty user.id}">Add New User</c:if>
        <c:if test="${not empty user.id}">Edit User</c:if>
    </h2>
    <form action="<%= request.getContextPath() %>/insert" method="post">
        <input type="hidden" name="id" value="${user.id}" />
        <label for="firstname">First name:</label>
        <input type="text" id="firstname" name="firstname" value="${user.firstname}" /><br/>
        <label for="lastname">Last name:</label>
        <input type="text" id="lastname" name="lastname" value="${user.lastname}" /><br/>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${user.address}" /><br/>
        <label for="city">City:</label>
        <input type="text" id="city" name="city" value="${user.city}" /><br/>
        <label for="state">State:</label>
        <input type="text" id="state" name="state" value="${user.state}" /><br/>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${user.email}" /><br/>
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${user.phone}" /><br/>
        <input type="submit" value="Save" />
    </form>
    <a href="<%= request.getContextPath() %>/list">Back to User List</a>
</body>
</html>
