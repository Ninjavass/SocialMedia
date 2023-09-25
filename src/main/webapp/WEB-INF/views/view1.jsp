<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>View posts</title>
</head>
<body>
    <h1>View all original posts by the people you follow, ordered by reverse
        chronological order</h1>
    <form method="post">
        <button type="submit">Return to welcome page</button>
    </form>
    <table border="2">
        <thead>
            <tr>
                <th>Post</th>
                <th>Creation date</th>
                <th>Creator</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>${post.post}</td>
                    <c:set var="javaDate" value="${post.createdAt}" />
                    <%
                        LocalDateTime localDateTime = (LocalDateTime) pageContext.getAttribute("javaDate");
                        Timestamp javaTimestamp = Timestamp.valueOf(localDateTime);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        String formattedDate = sdf.format(javaTimestamp);
                        String originalDateTime = formattedDate.replace("T", " ");
                    %>
                    <td>
                        <%= originalDateTime %>
                    </td>
                    <td>${post.user1.username}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>