<%--
  Created by IntelliJ IDEA.
  User: filipe
  Date: 06/07/18
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<%
    String msg="";
    String s="";
    boolean showStack=false;
    if(exception!=null){
        String[] ex= exception.getMessage().split("##");
        msg = ex[0];
        if(ex.length>1){
            showStack = (ex[1].toUpperCase().equals("TRUE"));
        }
    }
    if(showStack){
        StackTraceElement[] trace = exception.getStackTrace();
        int traceMaxSize=5;
        StringBuilder sbuilder = new StringBuilder();
        if(trace!=null){
            int  size = trace.length;
            String msgLog="";
            if(trace.length>traceMaxSize){
                size = traceMaxSize;
                msgLog  = "<div>Para mais informações consulte o Log<div>";
            }
            sbuilder.append("<div class=\"traceBox\">");
            for(int i=0;i<size;i++){
                sbuilder.append("<div>");
                sbuilder.append(trace[i]);
                sbuilder.append("</div>");
            }
            sbuilder.append("</div>");
            s=sbuilder.toString();
        }
    }
%>

<html>
<head>
    <title>Erro - SSLREL</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
    <link rel="stylesheet" href="error.css">
</head>
<body>
    <div class="header">
        <div>
            <div>
                SSLRel
            </div>
            <div>
                Ops! Algo deu errado. <i class="far fa-frown"></i>
            </div>
            <div class="msgBox">
                <%= msg %>
            </div>
        </div>
    </div>
    <div class="container">
        <%= s %>
    </div>
</body>
</html>