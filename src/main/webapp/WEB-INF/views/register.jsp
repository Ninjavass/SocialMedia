<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <style>
        body {font-family: Arial, sans-serif;}
    </style>
</head>
<body>
    <h1>Register Page</h1>
    <form method="post" action="register">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password: </label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="premium">Premium plan</label>
        <input type="checkbox" id="premium" name="premium" value="false"><br><br>

        <button type="submit" name="action" value="register"> Register                 </button>
        <button type="submit" name="action" value="return">   Return to login screen   </button>
    </form>
    <h2>${errorMsg}</h2>
</body>
</html>