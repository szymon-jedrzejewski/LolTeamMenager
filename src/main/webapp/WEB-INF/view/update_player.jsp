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
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <script src="../../resources/js/updatePlayer.js" async></script>
            <link rel="stylesheet" type="text/css" href="../../resources/css/edit-button.css" />
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
                    <div class="content">
                        <label>Name</label>
                        <input type="text">
                    </div>
                </div>

                <div id="player-surname">
                    <p id="surname">Surname: </p>
                </div>
                <div id="edit-surname">
                    <button class="edit-button">Edit</button>
                    <div class="content">
                        <label>Surname</label>
                        <input type="text">
                    </div>
                </div>

                <div id="player-nick">
                    <p id="nick">Nick: </p>
                </div>
                <div id="edit-nick">
                    <button class="edit-button">Edit</button>
                    <div class="content">
                        <label>Nick</label>
                        <input type="text">
                    </div>
                </div>

                <div id="player-role">
                    <p id="role">Role: </p>
                </div>
                <div id="edit-role">
                    <button class="edit-button">Edit</button>
                    <div class="content">
                        <label>Role</label>
                        <input type="text">
                    </div>
                </div>

                <div id="player-age">
                    <p id="age">Age: </p>
                </div>
                <div id="edit-age">
                    <button class="edit-button">Edit</button>
                    <div class="content">
                        <label>Age</label>
                        <input type="text">
                    </div>
                </div>

                <div id="player-team">
                    <p id="team">Team: </p>
                </div>
                <div id="edit-team">
                    <button class="edit-button">Edit</button>
                    <div class="content">
                        <label>Team</label>
                        <input type="text">
                    </div>
                </div>
            </div>

            <input id="save" type="submit" value="Save" />

        </body>

        </html>