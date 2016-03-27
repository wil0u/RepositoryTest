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
         <title>Comparer des Pays</title>
    </head>
    <body>
        <br>
        <br>
        <div class="container">
        <center><h1>Menu de la comparaison</h1></center>
       
        <form action="comparer" role="form">
        <div class="form-group">
            <p>Pays 1 :</p>
        <SELECT name="pays1" id="pays1" class="form-control">
        <c:forEach var="pays" items="${listePays}">
        <OPTION><c:out value="${pays.getCountryName()}"/>
        </c:forEach>
        </SELECT>
        </div>
        <div class="form-group">
        <p>Pays 2 :</p>
        <SELECT name="pays2" id="pays2" class="form-control">
        <c:forEach var="pays" items="${listePays}">
        <OPTION><c:out value="${pays.getCountryName()}"/>
        </c:forEach>
        </SELECT>
        </div>
        <div class="form-group">
        <p>Indicateur 1 :</p>
        <SELECT name="indicateur1" id="indicateur1" class="form-control">
        <c:forEach var="indic" items="${listeIndicateurs}">
        <OPTION><c:out value="${indic.getIndicatorName()}"/>
        </c:forEach>
        </SELECT>
        </div>
        <div class="form-group">
        <p>Indicateur 2 :</p>
        <SELECT name="indicateur2" id="indicateur2" class="form-control">
        <c:forEach var="indic" items="${listeIndicateurs}">
        <OPTION><c:out value="${indic.getIndicatorName()}"/>
        </c:forEach>
        </SELECT>
        </div>
        <p>             </p>
        <input type="submit" class="btn btn-success" value="GO !">
        </form>
        </div>
    </body>
</html>
