<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06/12/24
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Add post</title>
</head>
<body>
<form action="/post/add" method="post" enctype="multipart/form-data">
<input type="text" name="title" placeholder="title">
<input type="file" name="cover">
<input type="file" name="audio">
<input type="file" name="video">
    <button>ok</button>
</form>
</body>
</html>
