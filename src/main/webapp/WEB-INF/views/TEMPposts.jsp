<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Posts and Comments</title>
    <style>
        body {font-family: Arial, sans-serif;}
    </style>
</head>
<body>
    <h1>Posts and Comments</h1>
    <form method="post">
        <table border="1">
            <tr>
                <th>Post creator</th>
                <th>Post</th>
                <th>Comment</th>
                <th>Comment Creator</th>
            </tr>
            <c:forEach items="${posts}" var="item">
                <tr>
                    <td>${item.user1.username}</td>
                    <td>${item.post}</td>
                    <td>
                        <ul>
                            <c:forEach items="${item.comments}" var="comments">
                                <li>${comments.comment}</li>
                                <li>${comments.user_id}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <button type="submit" name="action" value="comment"> Create Comment </button>
        <button type="submit" name="action" value="post">    Create Post    </button>
    </form>
</body>
</html>