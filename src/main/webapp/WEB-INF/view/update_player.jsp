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
                <div id="name">

                </div>
                <div id="surname">

                </div>
                <div id="nick">

                </div>
                <div id="role">

                </div>
                <div id="age">

                </div>
                <div id="team">

                </div>
            </div>

            <table id="players"></table>

        </body>

        </html>