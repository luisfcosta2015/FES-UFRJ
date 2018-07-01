<%--
  Created by IntelliJ IDEA.
  User: filipe
  Date: 09/06/18
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(sslRel.helpers.Permission.isSuperAdmin(request)){ %>
<% String urlRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
<link rel="stylesheet" href="<%=urlRoot+"/config.css"%>">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<div class="menu-icon-wrapper">
    <div class="menu-icon">
        <i class="fas fa-times"></i>
    </div>
</div>
<div class="loader">
    <div class="spinner">

    </div>
</div>

<div id="sslModalWrapper">
    <div class="sslModal">
        <header>
            <div class="titleModal">
            </div>
            <div class="closeBtn">
                <i class="fas fa-times"></i>
            </div>
        </header>
        <section>
        </section>
        <footer>
            <input class="btn btn-primary" type="button" value="Sim">
            <input class="btn btn-secondary" type="button" value="Não">
        </footer>
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
        <h5 class="app-title">
            SSLRel
        </h5>
        <div class="nav">
            <ul>
                <li data-wrappersection="criar">
                    <a href="#" data-section="criar">Criar</a>
                </li>
                <li  data-wrappersection="editar">
                    <a href="#" data-section="editar" selected="true">Editar</a>
                </li>
                <li data-wrappersection="excluir">
                    <a href="#" data-section="excluir">Excluir</a>
                </li>
            </ul>
        </div>
    </header>
    <div class="container">
        <div class="section criar">
            <form action=""  enctype="multipart/form-data" method="post">
                <div class="input-container">
                    <label for="JobNameCreate">Job Model Name:</label>
                    <input class="input-field" onkeyup="this.parentElement.classList.remove('error')" id="JobNameCreate" name="jobModelName" type="text">
                </div>
                <div class="input-container">
                    <label>Arquivo .rssql.json:</label>
                    <div class="file-wrapper">
                        <label class=" btn btn-generics" for="rssqlFile">Clique para fazer upload</label>
                        <input onchange="this.parentElement.querySelector('label').innerHTML=this.files.item(0).name" id="rssqlFile" type="file" name="rssqlFile">
                    </div>
                </div>
                <div class="input-container">
                    <label for="htmlFile">Arquivo .html:</label>
                    <div class="file-wrapper">
                        <label class=" btn btn-generics" for="htmlFile">Clique para fazer upload</label>
                        <input onchange="this.parentElement.querySelector('label').innerHTML=this.files.item(0).name" id="htmlFile" type="file" name="htmlFile">
                    </div>
                </div>
                <div class="input-container">
                    <input type="submit" class="btn btn-primary" value="Criar">
                </div>
            </form>
        </div>
        <div class="section editar"  selected="true">
            <form action="">
                <div class="input-container">
                    <label for="jobNameEdit">Job Model:</label>
                    <div class="input-container">
                        <select id="jobNameEdit" class="custom-select" name="">
                        </select>
                    </div>
                    <span class="msg-box"></span>
                </div>
                <div id="choices">

                </div>
                <div class="input-container">
                    <input id="saveJobEdit" type="button" class="btn btn-primary" value="Salvar Job">
                </div>
                <div class="input-container">
                    <input id="clearJobEdit" type="button" class="btn btn-secondary" value="Desvincular Job">
                </div>
            </form>
        </div>
        <div class="section excluir">
            <form action="" method="post">
                <div class="input-container">
                    <label for="jobNameExcluir">Job Model:</label>
                    <div class="input-container">
                        <select id="jobNameExcluir" class="custom-select" name="">
                        </select>
                    </div>
                    <span class="msg-box"></span>
                </div>

                <div class="input-container">
                    <input id="deleteJob" type="submit" class="btn btn-primary" value="Excluir Job">
                </div>
            </form>
        </div>
    </div>
</div>
<% }else{ %>
    {"msg": "Acesso não autorizado"}
<%}%>