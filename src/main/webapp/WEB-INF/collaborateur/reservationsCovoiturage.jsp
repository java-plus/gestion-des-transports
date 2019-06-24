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
    
    <h1>liste de vos réservations</h1>
    
    <div class="container mt-5">
    
    <div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<a href="/gdt/controller/collaborateur/chercherannonces/"><button
						type="submit" class="btn btn-success center-block">Chercher un covoiturage pour réserver</button></a>

			</div>
			<div class="col-4"></div>
		</div>
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">

				<p></p>
			</div>
			<div class="col-4"></div>
		</div>
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
						Integer idUtilisateur = (Integer)request.getAttribute("idUtilisateur");
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
								<td>
								<button
						type="submit" class="btn btn-success center-block" onclick="annulerReservation(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">annuler ma reservation</button>
						</td>
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
	<script type="text/javascript">
	function annulerReservation(idAnnonceCovoiturage) {

	alert("jnklnlkn");
			document.location.href = "http://localhost:8080/gdt/controller/collaborateur/annulerReservation?idAnnonceCovoiturage="
					+ idAnnonceCovoiturage;

		}
	
	</script>
			<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>
	
	
</body>
</html>