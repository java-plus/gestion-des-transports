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
							<th scope="col">Date départ</th>
							<th scope="col">Lieu départ</th>
							<th scope="col">Lieu arrivée</th>
							<th scope="col">Nombre de voyageurs</th>
							
							

						</tr>
					</thead>
					<tbody>



						<%

							List<AnnonceCovoiturage> listeFuturesAnnonces = (List<AnnonceCovoiturage>) request.getAttribute("listeDesFuturesAnnonces");
							List<Integer> listeDesNombresDeReservations = (List<Integer>) request.getAttribute("listeDesNombresDeReservations");
							Integer n = 0;

							for (AnnonceCovoiturage futurAnnonceCovoiturage : listeFuturesAnnonces) {
						%>
						<tr>



							<td><%=futurAnnonceCovoiturage.getDateDeDepart()%></td>
							<td><%=futurAnnonceCovoiturage.getLieuDeDepart()%></td>
							<td><%=futurAnnonceCovoiturage.getLieuDeDestination()%></td>
							<td><%=listeDesNombresDeReservations.get(n)%></td>
							
							<td>
								<button type="submit" class="btn btn-primary center-block" onclick="annulerCovoiturage(<%=futurAnnonceCovoiturage.getIdAnnonceCovoiturage()%>)">Supprimer</button>
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
							<th scope="col">Date départ</th>
							<th scope="col">Lieu départ</th>
							<th scope="col">Lieu arrivée</th>
							<th scope="col">Nombre de voyageurs</th>

						</tr>
					</thead>
					<tbody>

						<%
							List<AnnonceCovoiturage> listeAnciennesAnnonces = (List<AnnonceCovoiturage>) request.getAttribute("listeDesAnciennesAnnonces");
						List<Integer> listeDesNombresDeReservations2 = (List<Integer>) request
								.getAttribute("listeDesNombresDeReservations");
						Integer n2 = 0;
							for (AnnonceCovoiturage ancienneAnnonceCovoiturage : listeAnciennesAnnonces) {

				

						%>
						<tr>

							<td><%=ancienneAnnonceCovoiturage.getDateDeDepart()%></td>
							<td><%=ancienneAnnonceCovoiturage.getLieuDeDepart()%></td>
							<td><%=ancienneAnnonceCovoiturage.getLieuDeDestination()%></td>
							<td><%=listeDesNombresDeReservations2.get(n)%></td>

							<td>
								<button type="submit" class="btn btn-primary center-block" onclick="annulerCovoiturage(<%=ancienneAnnonceCovoiturage.getIdAnnonceCovoiturage()%>)">Supprimer</button>
							</td>
						</tr>
						<%
							n2++;
						}
						%>

					</tbody>
				</table>

			</div>
			<div class="col-1"></div>
		</div>
	</div>
	<script type="text/javascript">
	function annulerCovoiturage(idAnnonceCovoiturage) {

		document.location.href = "http://localhost:8080/gdt/controller/collaborateur/annulerAnnonce?idAnnonce="
					+ idAnnonceCovoiturage;

		}
	</script>
	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>

</body>
</html>