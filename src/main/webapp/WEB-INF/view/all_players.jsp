<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 27.08.2020
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <script src="../../resources/js/script.js" async></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LoL Team Manager</title>
</head>

<body>
<!-- Here a loader is created which
     loads till response comes -->
<div class="d-flex justify-content-center">
    <div class="spinner-border" role="status" id="loading">
        <span class="sr-only">Loading...</span>
    </div>
</div>
<h1>Players</h1>
<!-- table for showing data -->
<table id="players"></table>

<form action="${pageContext.request.contextPath}/add_player">
    <input type="submit" value="Add player" />
</form>
</body>

</html>