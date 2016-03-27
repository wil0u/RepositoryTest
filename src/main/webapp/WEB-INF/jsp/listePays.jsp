<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
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
        <title>Liste des pays</title>
    </head>
    <body>    
         <br>
        <br>
        <div class="container">
        <table class="table table-bordered table-striped table-condensed">
            <thead>
                <tr>
                    <th>Pays</th>
                    <th>Code</th>
                    <th>Region</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="country" items="${listePays}">
                    <tr>
                        <td><c:out value="${country.getCountryName()}"/></td>
                        <td><c:out value="${country.getCountryCode()}"/></td>
                        <td><c:out value="${country.getRegion()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>