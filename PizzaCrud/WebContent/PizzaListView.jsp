<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizza.Pizza"%>
<!doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
   
    <!-- Custom styles for this template -->
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
  <div class="col-md-12">
  <br><a href="${pageContext.request.contextPath}/ControllerPizza?action=addPizza" class="btn btn-primary center">Ajouter une pizza</a><br>
  </div>
  <div class="album py-5 bg-light">
    <div class="container">
  <div class="row">
  
 
 	<% List<Pizza> listedepizza = (ArrayList<Pizza>) request.getAttribute("listpizza");
				for (Pizza item : listedepizza) {
			%>
 
      
        <div class="col-md-4">
          <div class="card mb-4 shadow-sm">
            	<img src="imagesPizza/<%=item.getId()%>.jpg" class="bd-placeholder-img card-img-top" width="100%" height="225">
            <div class="card-body">
              <p class="card-text">	<p>
							Tarif Pizza :
							<%=item.getPrice()%> euros
						</p>
						<p>
							Désignation Pizza :
							<%=item.getDesignPizz()%>
						</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                <a type="button" class="btn btn-light" href="${pageContext.request.contextPath}/ControllerPizza?action=editpizza&idpizza=<%=item.getId()%>">Info</a>
                 <a type="button" class="btn btn-light" href="${pageContext.request.contextPath}/ControllerPizza?action=modifpizza&idpizza=<%=item.getId()%>">Modifier</a>
                 <a type="button" class="btn btn-light" href="${pageContext.request.contextPath}/ControllerPizza?action=deletepizza&idpizza=<%=item.getId()%>">Supprimer</a>
                </div>
              </div>
            </div>
          </div>
        </div>
			<%
				}
			%>
		</div>
	</div>
	</div>
</body>
</html>
