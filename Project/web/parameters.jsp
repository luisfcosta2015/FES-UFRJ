<%@ page import="example.HelloWorld" %><%--
  Created by IntelliJ IDEA.
  User: fjmrs
  Date: 02/05/2018
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>


<nav class="">
    <div class="nav-wrapper cyan darken-1">
        <a href="#" class="brand-logo center">Logo</a>
    </div>
</nav>
<form action="">
    <div data-filterTask="" class="container" style="margin-top: 10px">
        <!-- Page Content goes here -->
        <div class="row">
            <div class="input-field col s12 m6 l6">
                <select data-filter="escolaNome">
                    <option value="1">Option 1</option>
                </select>
                <label>Nome da Escola</label>
            </div>
            <div class="input-field col s12 m6 l6">
                <select data-filter="ano">
                    <option value="1">Option 1</option>
                </select>
                <label>Ano letivo</label>
            </div>
            <div class="input-field col s12 m6 l6">
                <select data-filter="turma">
                    <option value="1">Option 1</option>
                </select>
                <label>Turma</label>
            </div>
        </div>
        <div class="fixed-action-btn">
            <a onclick="sendFilterTask()" class="btn-floating btn-large red">
                <i class="material-icons">play_arrow</i>
            </a>
        </div>
    </div>
</form>

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
<script src="./main.js"></script>
</body>
</html>