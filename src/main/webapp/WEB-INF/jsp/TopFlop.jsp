<%-- 
    Document   : TopFlop
    Created on : 19 mars 2016, 14:49:31
    Author     : Ut
--%>

<%@ page language="java" isELIgnored="false"
         pageEncoding="ISO-8859-1" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <spring:url value="/resources/css/bootstrap.css" var="bootCSS" />
        <spring:url value="/resources/css/main.css" var="mainCSS" />           
         <link href="${bootCSS}" rel="stylesheet" />
         <link href="${mainCSS}" rel="stylesheet" />
         <jsp:include page="Menu.jsp" ></jsp:include>  
        <title>Top & Flop</title>
    </head>
    <body>
        <br>
        <br>
   
<div class="container">
    <form action="TopPaysController" role="form">
        Choisir un critère
        <div class="form-group">
        <select name = "Indicateur" id = "Indicateur" class="form-control" >
            <c:forEach  var="Indicateur" items="${ListeIndicateur}">
                <OPTION><c:out value="${Indicateur.getIndicatorName()}"/>
                </c:forEach>
        </select>
        </div>
        <div class="form-group">
        <select name = "Date" id = "Date" class="form-control" >
            <c:forEach var="Date" begin="1985" end="2015" >
                <OPTION> <c:out value="${Date}"/> 
                </c:forEach>
        </select>
        </div>
        <div class="form-group">
        <select name = "TopFlop" id = "TopFlop" class="form-control">
            <OPTION>Top
            <OPTION>Flop
        </select>
        </div>
        <input type="submit" value="Pokemon Go." class="btn btn-success">

    </form> 
</div>
</body>
</html>