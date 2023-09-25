<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {font-family: Arial, sans-serif;}
    </style>
</head>
<body>
    <h1>Login Page</h1>
    <form method="post" action="login">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>

        <button type="submit" name="action" value="log_in">   Log in   </button>
        <button type="submit" name="action" value="register"> Register </button>
    </form>
    <h2>${errorMsg}</h2>
</body>
</html>