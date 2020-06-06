<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizza.Pizza"%>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Modification Pizza</title>

    <!-- Bootstrap core CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">

<link href ="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" rel="script">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
<body>


<div class="container">
	<div class="row">
			<%
				Pizza modifpizza = (Pizza) request.getAttribute("modifpizza");
			%>
	</div>
</div>

<div class="container-fluid bg-light py-3">
    <div class="row">
        <div class="col-md-6 mx-auto">
                <div class="card card-body">
                   <div>
					<form method="GET" class="form-group" action="${pageContext.request.contextPath}/ControllerPizza" enctype="multipart/form-data"> 
					<div class="caption" style="text-align: center;">
							
							<input type="hidden" name="action" value=modifpizzavalid>
							<input type="hidden" name="idpizza" value="<%=modifpizza.getId()%>">
							Tarif Pizza :
							<input type="number" class="form-control" step="0.01" name="TarifPizz" value="<%=modifpizza.getPrice()%>" /><br>
							Désignation Pizza :
							<input type="text" class="form-control" name="DesignPizz" value="<%=modifpizza.getDesignPizz()%>" /><br>
							La Description :
							<textarea class="form-control" name="Description"><%=modifpizza.getDescription()%></textarea><br>
					</div>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/ControllerPizza?action=Listpizza"
						role="button">Retour</a> 
					<button type="submit" name="submit" value="Ajouter" class="btn btn-primary">Valider</button>
					</form>
				</div>
                </div>
        </div>
    </div>
</div>
</body>
</html>