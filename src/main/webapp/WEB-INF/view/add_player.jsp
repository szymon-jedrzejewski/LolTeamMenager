<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 27.08.2020
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <script src="../../resources/js/addPlayer.js" async></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LoL Team Manager</title>
</head>

<body>
<form>
    <table>
        <tbody>
        <tr>
            <td><label>First name:</label></td>
            <td><input type="text" id="name"></td>
        </tr>
        <tr>
            <td> <label>Last name:</label></td>
            <td><input type="text" id="surname"></td>
        </tr>
        <tr>
            <td><label>Nick:</label></td>
            <td><input type="text" id="nick"></td>
        </tr>
        <tr>
            <td><label>Role:</label></td>
            <td><input type="text" id="role"></td>
        </tr>
        <tr>
            <td><label>Age:</label></td>
            <td><input type="number" id="age"></td>
        </tr>

        </tbody>
    </table>
</form>
<form action="${pageContext.request.contextPath}/all_players">
    <input id="add-player-button" type="submit" value="Add player" />
</form>

</body>

</html>
