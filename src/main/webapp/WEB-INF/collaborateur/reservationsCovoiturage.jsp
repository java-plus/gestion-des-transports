<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.model.AnnonceCovoiturage,fr.diginamic.model.Collaborateur"%>

<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>




<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>"/collaborateur/reservationsCovoiturage"</h1>
    <h1>liste des réservation faites par l'utilisateur courant</h1>
    
    <div class="container mt-5">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">



				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">places disponibles</th>
							<th scope="col">date départ</th>
							<th scope="col">lieu départ</th>
							<th scope="col">lieu arrivée</th>
							<th scope="col">durée</th>
							<th scope="col">distance</th>
							<th scope="col">id utilisateur</th>
							<th scope="col">id vehicule</th>

						</tr>
					</thead>
					<tbody>

						

						<%
							List<AnnonceCovoiturage> listeDesReservationsCovoiturage = (List<AnnonceCovoiturage>) request.getAttribute("listeDesReservationsCovoiturage");
						
								for (AnnonceCovoiturage annonceCovoiturage : listeDesReservationsCovoiturage) {
							%>
							<tr>
								
								
								<td><%=annonceCovoiturage.getIdAnnonceCovoiturage()%></td>
								<td><%=annonceCovoiturage.getNbPlacesDisponibles()%></td>
								<td><%=annonceCovoiturage.getDateDeDepart()%></td>
								<td><%=annonceCovoiturage.getLieuDeDepart()%></td>
								<td><%=annonceCovoiturage.getLieuDeDestination()%></td>
								<td><%=annonceCovoiturage.getDuree()%></td>
								<td><%=annonceCovoiturage.getDistanceEnKm()%></td>
								<td><%=annonceCovoiturage.getIdUtilisateur()%></td>
								<td><%=annonceCovoiturage.getIdVehicule()%></td>
							</tr>
							<%
								}
							%>
						
					</tbody>
				</table>

			</div>
			<div class="col-1"></div>
		</div>
	</div>
	
	
			<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>
	
	
</body>
</html>