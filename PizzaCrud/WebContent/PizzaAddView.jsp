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
    <title>AjoutPizz</title>

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

<div class="container-fluid bg-light py-3">
    <div class="row">
        <div class="col-md-6 mx-auto">
                <div class="card card-body">
                   <div>
                  				<form method="post"action="ControllerPizza" enctype="multipart/form-data"> 
                  					<div class="caption" style="text-align: center;">
					
										<input type="hidden" name="action" value="addPizzaValid">
											Tarif Pizza :
											<input type="number" class="form-control" placeholder="Entrez tarif" name="TarifPizz"/><br>
											Désignation Pizza :
											<input type="text" class="form-control" placeholder="Entrez la désignation" name="DesignPizz" /><br>
											La Description :
											<input type="text" class="form-control" placeholder="Entrez la description" name="Description" /><br>
										
										<input type="file" class="form-control" placeholder="Enter email"name="fileToUpload">
									</div>
									<br>
									<a class="btn btn-primary"
										href="${pageContext.request.contextPath}/ControllerPizza?action=Listpizza"
										role="button">Retour à la liste</a> 
										
									<button type="submit" name="submit" value="Ajouter" class="btn btn-primary">Valider</button>
								</form>
					</div>
                 </div>
           </div>
    </div>
</div>
</body>
</html>