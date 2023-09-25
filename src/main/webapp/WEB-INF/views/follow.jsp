<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Follow user by e-mail</title>
    <style>
        body {font-family: Arial, sans-serif;}
    </style>
</head>
<body>
    <h1>${Msg}</h1>
    <h2>Choose user to follow by their e-mail</h2>
    <form method="post" action="follow">
         <select name="selectedUser">
             <c:forEach items="${users}" var="user">
                  <option value="${user.userId}">${user.email}</option>
             </c:forEach>
         </select>
         <br><br>
        <button type="submit" name="action" value="follow"> Follow                 </button>
        <button type="submit" name="action" value="return"> Return to welcome page </button>
    </form>
</body>
</html>