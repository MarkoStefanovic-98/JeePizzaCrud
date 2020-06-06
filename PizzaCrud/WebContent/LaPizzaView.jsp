<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizza.Pizza"%>
<!doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">

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
   
.thumbnail {
	height: 380px;
	margin-bottom: 50px;
}

.button {
	background-color: gray;
	color: white;
}

.button:hover {
	background-color: darkgray;
}

.zoom {
	-webkit-transform: scale(1);
	transform: scale(1);
	-webkit-transition: .3s ease-in-out;
	transition: .3s ease-in-out;
}

.zoom:hover {
	-webkit-transform: scale(1.1);
	transform: scale(1.1);
}
</style>


</head>
<body>
	<div class="album py-5 bg-light">
    <div class="container">
  <div class="row">

			<%
				Pizza mapizza = (Pizza) request.getAttribute("mapizza");
			%>
        <div class="col-md-12">
          <div class="card mb-12 shadow-sm">
            	<img src="imagesPizza/<%=mapizza.getId()%>.jpg" class="bd-placeholder-img card-img-top" width="50%" height="350">
            <div class="card-body">
              <p class="card-text">	<p>
							Tarif Pizza :
							<%=mapizza.getPrice()%> euros
						</p>
						<p>
							Désignation Pizza :
							<%=mapizza.getDesignPizz()%>
						</p>
						<p style="text-align: left;">la description:
						<%=mapizza.getDescription()%></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                <a type="button" class="btn btn-light" 	href="${pageContext.request.contextPath}/ControllerPizza?action=Listpizza"
						role="button">Retour a la liste</a>
                 <a type="button" class="btn btn-light" href="${pageContext.request.contextPath}/ControllerPizza?action=modifpizza&idpizza=<%=mapizza.getId()%>">Modifier</a>
                 <a type="button" class="btn btn-light" href="${pageContext.request.contextPath}/ControllerPizza?action=deletepizza&idpizza=<%=mapizza.getId()%>">Supprimer</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        
</div>
</div>
	</div>
</body>
</html>
