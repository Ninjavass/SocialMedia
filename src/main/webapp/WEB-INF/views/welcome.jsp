<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
        body {font-family: Arial, sans-serif;}
    </style>
</head>
<body>
    <h1>Welcome ${username}</h1>

    <form method="post">
         <button type="submit" name="action" value="log_out">  Log out         </button><br><br>
         <button type="submit" name="action" value="post">     Create Post     </button>
         <button type="submit" name="action" value="comment">  Create Comment  </button><br><br>
         <button type="submit" name="action" value="follow">   Add Follower    </button>
         <button type="submit" name="action" value="unFollow"> Remove Follower </button><br><br>
         <button type="submit" name="action" value="view1">    View all original posts by the people you follow, ordered by reverse
                                                               chronological order </button><br><br>
         <button type="submit" name="action" value="view2">    View own posts, including the latest 100 comments, sorted by reverse
                                                               chronological order </button><br><br>
         <button type="submit" name="action" value="view4">    View your followers </button><br><br>
    </form>
</body>
</html>