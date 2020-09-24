<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 20.09.2020
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Update player</title>
            <script src="../../resources/js/updatePlayer.js" async></script>
        </head>

        <body>
            <div class="d-flex justify-content-center">
                <div class="spinner-border" role="status" id="loading">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>

            <div id=player-info>
                <div id="player-name">
                    <p id="name">Name: </p>
                </div>
                <div id="edit-name">
                    <button class="edit-button">Edit</button>
                </div>

                <div id="player-surname">
                    <p id="surname">Surname: </p>
                </div>
                <div id="edit-surname">
                    <button class="edit-button">Edit</button>
                </div>

                <div id="player-nick">
                    <p id="nick">Nick: </p>
                    <button class="edit-button">Edit</button>
                </div>
                <div id="edit-nick">
                    <button class="edit-button">Edit</button>
                </div>

                <div id="player-role">
                    <p id="role">Role: </p>
                    <button class="edit-button">Edit</button>
                </div>
                <div id="edit-role">
                    <button class="edit-button">Edit</button>
                </div>

                <div id="player-age">
                    <p id="age">Age: </p>
                    <button class="edit-button">Edit</button>
                </div>
                <div id="edit-age">
                    <button class="edit-button">Edit</button>
                </div>

                <div id="player-team">
                    <p id="team">Team: </p>
                    <button class="edit-button">Edit</button>
                </div>
                <div id="edit-team">
                    <button class="edit-button">Edit</button>
                </div>
            </div>

            <table id="players"></table>

        </body>

        </html>