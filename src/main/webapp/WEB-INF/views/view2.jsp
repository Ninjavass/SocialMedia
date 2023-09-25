<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>View posts and their comments</title>
</head>
<body>
    <h1>Own posts, including the latest 100 comments, sorted by reverse chronological order</h1>
    <form method="post">
        <button type="submit">Return to welcome page</button>
    </form>
    <table border="2">
        <thead>
            <tr>
                <th>Post</th>
                <th>Post creation date</th>
                <th>Comment</th>
                <th>Comment creation date</th>
                <th>Comment creator</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${comments}" var="comment">
                <tr>
                    <td>${comment.post.post}</td>
                    <c:set var="javaDate" value="${comment.post.createdAt}" />
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
                    <td>${comment.comment}</td>
                    <c:set var="javaDate2" value="${comment.createdAt}" />
                    <%
                        LocalDateTime localDateTime2 = (LocalDateTime) pageContext.getAttribute("javaDate2");
                        Timestamp javaTimestamp2 = Timestamp.valueOf(localDateTime2);
                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        String formattedDate2 = sdf2.format(javaTimestamp2);
                        String originalDateTime2 = formattedDate2.replace("T", " ");
                    %>
                    <td>
                        <%= originalDateTime2 %>
                    </td>
                    <td>${comment.user1.username}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>