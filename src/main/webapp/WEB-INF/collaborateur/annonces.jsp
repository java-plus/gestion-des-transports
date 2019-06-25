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

	<div class="container mt-5">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<a href="/gdt/controller/collaborateur/creerannonce/"><button
						type="submit" class="btn btn-success center-block">Creer
						une nouvelle annonce</button></a>

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


<div><Strong>Réservations en cours</Strong></div>
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
							List<AnnonceCovoiturage> listeFuturesAnnonces = (List<AnnonceCovoiturage>) request.getAttribute("listeDesFuturesAnnonces");

							for (AnnonceCovoiturage futurAnnonceCovoiturage : listeFuturesAnnonces) {
						%>
						<tr>


							<td><%=futurAnnonceCovoiturage.getIdAnnonceCovoiturage()%></td>
							<td><%=futurAnnonceCovoiturage.getNbPlacesDisponibles()%></td>
							<td><%=futurAnnonceCovoiturage.getDateDeDepart()%></td>
							<td><%=futurAnnonceCovoiturage.getLieuDeDepart()%></td>
							<td><%=futurAnnonceCovoiturage.getLieuDeDestination()%></td>
							<td><%=futurAnnonceCovoiturage.getDuree()%></td>
							<td><%=futurAnnonceCovoiturage.getDistanceEnKm()%></td>
							<td><%=futurAnnonceCovoiturage.getIdUtilisateur()%></td>
							<td><%=futurAnnonceCovoiturage.getIdVehicule()%></td>
							<td>
								<button type="submit" class="btn btn-primary center-block">Supprimer</button>
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
				
				<div><b>Historique</b></div>
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
							List<AnnonceCovoiturage> listeAnciennesAnnonces = (List<AnnonceCovoiturage>) request.getAttribute("listeDesAnciennesAnnonces");

							for (AnnonceCovoiturage ancienneAnnonceCovoiturage : listeAnciennesAnnonces) {
						%>
						<tr>


							<td><%=ancienneAnnonceCovoiturage.getIdAnnonceCovoiturage()%></td>
							<td><%=ancienneAnnonceCovoiturage.getNbPlacesDisponibles()%></td>
							<td><%=ancienneAnnonceCovoiturage.getDateDeDepart()%></td>
							<td><%=ancienneAnnonceCovoiturage.getLieuDeDepart()%></td>
							<td><%=ancienneAnnonceCovoiturage.getLieuDeDestination()%></td>
							<td><%=ancienneAnnonceCovoiturage.getDuree()%></td>
							<td><%=ancienneAnnonceCovoiturage.getDistanceEnKm()%></td>
							<td><%=ancienneAnnonceCovoiturage.getIdUtilisateur()%></td>
							<td><%=ancienneAnnonceCovoiturage.getIdVehicule()%></td>
							<td>
								<button type="submit" class="btn btn-primary center-block">Supprimer</button>
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

	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>

</body>
</html>