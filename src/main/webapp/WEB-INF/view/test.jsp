<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<h1>Test</h1>
<h1>Welcome <%String username = (String) request.getAttribute("username");%> <%= username%></h1>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Nick</th>
        <th>Role</th>
        <th>Age</th>
    </tr>
    <%--@elvariable id="players" type="java.util.List"--%>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.name}</td>
            <td>${player.surname}</td>
            <td>${player.nick}</td>
            <td>${player.role}</td>
            <td>${player.age}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>