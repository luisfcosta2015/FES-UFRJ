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
<div class="progress hide">
    <div class="indeterminate"></div>
</div>
<form data-filterTask="" action="generateReport" method="post">
    <div class="container" style="margin-top: 10px">
        <!-- Page Content goes here -->
        <div class="row">
            <div class="input-field col s12 m6 l6">
                <select name="escola" data-filter="escola" disabled>
                    <option value="" disabled selected>Selecione...</option>
                </select>
                <label>Escola</label>
            </div>
            <div class="input-field col s12 m6 l6">
                <select name="ano" data-filter="ano" disabled>
                    <option value=""  disabled selected>Selecione...</option>
                </select>
                <label>Ano letivo</label>
            </div>
            <div class="input-field col s12 m6 l6">
                <select name="turma" data-filter="turma" disabled>
                    <option value=""  disabled selected>Selecione...</option>
                </select>
                <label>Turma</label>
            </div>
        </div>
        <div class="fixed-action-btn">
            <button type="submit" class="btn-floating btn-large red">
                <i class="material-icons">play_arrow</i>
            </button>
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