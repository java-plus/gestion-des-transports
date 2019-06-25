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

	
	<h1>Vos réservations

<div class="float-right">
	<a href="/gdt/controller/collaborateur/reservations/creer">
		<button type="submit" class="btn btn-success center-block">Réserver un transport</button>
	</a>
</div></h1>
		<div class="m-3 mt-4">
			<div id="accordion">
				<div class="car ">
					
						<div class="card-header bg-dark text-light" id="headingOne">
							<h5 class="mb-0">
								<button class="btn btn-link collapsed text-light"
									data-toggle="collapse" data-target="#collapseOne"
									aria-expanded="false" aria-controls="collapseOne">
									Covoiturage</button>
							</h5>
						</div>
					
					<div id="collapseOne" class="collapse show"
						aria-labelledby="headingOne" data-parent="#accordion">
						<div class="card-body">
						<div class="container mt-5">

		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<a href="/gdt/controller/collaborateur/chercherannonces/"><button
						type="submit" class="btn btn-success center-block">Chercher
						un covoiturage pour réserver</button></a>

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
							List<AnnonceCovoiturage> listeDesReservationsCovoiturage = (List<AnnonceCovoiturage>) request
									.getAttribute("listeDesReservationsCovoiturage");
							Integer idUtilisateur = (Integer) request.getAttribute("idUtilisateur");
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
								<button type="submit" class="btn btn-success center-block"
									data-toggle="modal" data-target="#exampleModal" onclick="afficherModal(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">annuler
									ma reservation</button>
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
						</div>
					</div>
				</div>
				<div class="card ">
				<a href="/gdt/controller/collaborateur/reservations">
					<div class="card-header bg-dark " id="headingTwo">
						<h5 class="mb-0">
							<button class="btn btn-link text-light show"
								data-toggle="collapse" data-target="#collapseTwo "
								aria-expanded="true" aria-controls="collapseTwo">
								Véhicule de société</button>
						</h5>
					</div>
					</a>
					<div id="collapseTwo" class="collapse "
						aria-labelledby="headingTwo" data-parent="#accordion">
						<div class="card-body container ">

						</div>

					</div>

				</div>
			</div>
	</div>
	


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Annulation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h5>Etes-vous sûr de vouloir annuler cette réservation ?</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button id="btnAnnuler" type="button" class="btn btn-primary"
						>Confirmer</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
	function afficherModal(idAnnonceCovoiturage){
		const annulation = "annulerReservation("+idAnnonceCovoiturage.toString()+")";
		$("#btnAnnuler").attr("onclick", annulation);
		$("#exampleModal").modal("show");
	}
	
	function annulerReservation(idAnnonceCovoiturage) {

		document.location.href = "http://localhost:8080/gdt/controller/collaborateur/annulerReservation?idAnnonceCovoiturage="
					+ idAnnonceCovoiturage;

		}
	
	</script>
	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>


</body>
</html>