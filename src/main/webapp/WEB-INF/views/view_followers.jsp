<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>View followers</title>
</head>
<body>
    <h1>View all followers</h1>
    <form method="post">
        <button type="submit">Return to welcome page</button>
    </form>
    <table border="2">
        <thead>
            <tr>
                <th>Follower</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${followers}" var="follower">
                <tr>
                    <td>${follower.follower.username}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>