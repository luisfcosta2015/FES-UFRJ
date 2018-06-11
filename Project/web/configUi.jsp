<%--
  Created by IntelliJ IDEA.
  User: filipe
  Date: 09/06/18
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(sslRel.helpers.Permission.isSuperAdmin(request)){ %>
<% String urlRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort(); %>
<link rel="stylesheet" href="<%=urlRoot+"/config.css"%>">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<div class="menu-icon-wrapper">
    <div class="menu-icon">
        <i class="fas fa-times"></i>
    </div>
</div>


<!--MODELOS DE INPUT-->

<div data-model="buttonchoice" class="input-container">
    <a data-match="true" class="btn-choice btn " href="#">
        <div class="java-name"></div> :
        <div class="html-name"></div>
    </a>
    <span class="msg-box"></span>
</div>

<!-------------------->
<div class="SSLRel">
    <header>
        <h5>
            SSLRel
        </h5>
       <%-- <div class="nav">
            <ul>
                <li>
                    <a href="#" data-section="criar" selected="true">Criar</a>
                </li>
                <li>
                    <a href="#" data-section="editar">Editar</a>
                </li>
            </ul>
        </div>--%>
    </header>
    <div class="container">
        <%--<div class="section criar" selected="true">
            <form action="">
                <div class="input-container">
                    <label for="JobNameCreate">Job Name:</label>
                    <input class="input-field" id="JobNameCreate" type="text">
                </div>
                <div class="input-container">
                    <input type="button" class="btn btn-primary" value="Submit">
                </div>
            </form>
        </div>--%>
        <div class="section editar" selected="true">
            <form action="">
                <div class="input-container">
                    <label for="jobNameEdit">Job Name:</label>
                    <div class="input-container">
                        <select id="jobNameEdit" class="custom-select" name="">
                        </select>
                    </div>
                    <span class="msg-box"></span>
                </div>
                <div id="choices">

                </div>
                <div class="input-container">
                    <input type="button" class="btn btn-primary" value="Submit">
                </div>
            </form>
        </div>
    </div>
</div>
<% }else{ %>
    {"msg": "Acesso não autorizado"}
<%}%>