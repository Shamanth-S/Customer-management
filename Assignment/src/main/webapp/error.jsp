<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <h2>Error</h2>
    <p>${errorMessage}</p>
    <a href="<%= request.getContextPath() %>/list">Back to User List</a>
</body>
</html>
