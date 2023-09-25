<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Post</title>
    <style>
        body {font-family: Arial, sans-serif;}
    </style>
</head>
<body>
    <h1>${Msg}</h1>
    <h2>Write your post</h2>
    <form method="post">
        <textarea name="post" id="post" rows="5" cols="40"></textarea><br><br>
         <p id="charCount">Characters remaining: 1000</p>

         <script>
           var textarea = document.getElementById("post");
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

        <button type="submit" name="action" value="post">   Create Post            </button>
        <button type="submit" name="action" value="return"> Return to welcome page </button>
    </form>
</body>
</html>