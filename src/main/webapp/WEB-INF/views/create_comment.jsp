<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Comment</title>
    <style>
        body {font-family: Arial, sans-serif;}
    </style>
</head>
<body>
    <h1>${Msg}</h1>
    <h2>Write your Comment</h2>
    <form method="post">
         <select name="selectedPost">
             <c:forEach items="${posts}" var="post">
                  <option value="${post.postId}">${post.post}</option>
             </c:forEach>
         </select>
         <br><br>
        <textarea name="comment" id="comment" rows="5" cols="40"></textarea>
         <p id="charCount">Characters remaining: 1000</p>
         <script>
           var textarea = document.getElementById("comment");
           var charCount = document.getElementById("charCount");

           textarea.addEventListener("input", function () {
             var currentCount = textarea.value.length;
             var remaining = 1000 - currentCount;

             charCount.textContent = "Characters remaining: " + remaining;

             if (remaining < 0) {
               textarea.value = textarea.value.slice(0, 1000);
               charCount.textContent = "Characters remaining: 0";
             }
           });
         </script>
        <button type="submit" name="action" value="comment"> Create Comment         </button>
        <button type="submit" name="action" value="return">  Return to welcome page </button>
    </form>
</body>
</html>