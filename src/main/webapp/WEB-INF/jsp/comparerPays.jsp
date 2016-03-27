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
        <title>Comparer des Pays</title>
    </head>
    <body>
         <br>
        <br>
        <div class="container">
        <center><h1>Resultat de la comparaison</h1></center>
        <ul>
        <li>Nombre de Pays : ${nbPays} |  Nombre d'indicateurs : ${nbIndic}</li>
        <li>Pays 1 : ${pays1}  Code : ${pays1Code}</li>
	<li>Pays 2 : ${pays2}  Code : ${pays2Code}</li>
        <li>Indicateur1 : ${indic1}  Code : ${indic1Code}</li>
        <li>Indicateur2 : ${indic2}  Code : ${indic2Code}</li>
        </ul>
        <table class="table table-bordered table-striped table-condensed">
            <thead>
                <tr>
                    <th></th>
                    <th>${pays1}</th>
                    <th>${pays2}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${indic1}</td>
                    <td>${val1et1}</td>
                    <td>${val2et1}</td>
                </tr>
                <tr>
                    <td>${indic2}</td>
                    <td>${val1et2}</td>
                    <td>${val2et2}</td>
                </tr>
            </tbody>
        </table>
        <img src="histogramme?pays1=${pays1}&pays2=${pays2}&val1pays1=${val1et1}&val2pays1=${val1et2}&val1pays2=${val2et1}&val2pays2=${val2et2}&indicateur1=${indic1}&indicateur2=${indic2}" class="img-thumbnail"  >

    </div>
    </body>
</html>
