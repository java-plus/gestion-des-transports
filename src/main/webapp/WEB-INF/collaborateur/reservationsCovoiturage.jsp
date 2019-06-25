<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
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


	<h1>
		Vos réservations

		
	</h1>
	<div class="m-3 mt-4">
		<div id="accordion">
			<div class="card ">

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
						<div class="container ">




							<div class="float-right">
								<a href="/gdt/controller/collaborateur/chercherannonces/">
									<button type="submit" class="btn btn-success center-block mb-3">Réserver
										un transport</button>
								</a>
							</div>

							<div>
								<b>Covoiturage en cours</b>
							</div>


							
							

								



									<table class="table">
										<thead class="thead-dark">
											<tr>
												<th scope="col">Date / Heure</th>
												<th scope="col">Depart</th>
												<th scope="col">Destination</th>
												<th scope="col"></th>
												

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


												
												<td><%= annonceCovoiturage.getDateDeDepart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
												<td><%=annonceCovoiturage.getLieuDeDepart()%></td>
												<td><%=annonceCovoiturage.getLieuDeDestination()%></td>
												
												<td>
													<button type="submit" class="btn btn-success center-block"
														
														onclick="afficherModal(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">annuler
														ma reservation</button>
														<button type="submit" class="btn btn-success center-block"
														
														onclick="afficherModalDetails(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">détails</button>
												</td>
											</tr>
											<%
												}
											%>

										</tbody>
									</table>

								

							
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
				<div id="collapseTwo" class="collapse " aria-labelledby="headingTwo"
					data-parent="#accordion">
					<div class="card-body container "></div>

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
					<button id="btnAnnuler" type="button" class="btn btn-primary">Confirmer</button>
				</div>
			</div>
		</div>
	</div>
	
											<%
												for (AnnonceCovoiturage annonceCovoiturage : listeDesReservationsCovoiturage) {
											%>
	
	<!-- Modal Details -->
	<div class="modal fade" id="<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Depart : <%=annonceCovoiturage.getLieuDeDepart()%></p>
					<p>Destination : <%=annonceCovoiturage.getLieuDeDestination()%></p>
					<p>Date - Heure : <%=annonceCovoiturage.getDateDeDepart()%></p>
					
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					
				</div>
			</div>
		</div>
	</div>
											<%
												}
											%>
	<script type="text/javascript">
	
	function afficherModal(idAnnonceCovoiturage){
		const annulation = "annulerReservation("+idAnnonceCovoiturage.toString()+")";
		
		$("#btnAnnuler").attr("onclick", annulation);
		$("#exampleModal").modal("show");
	}
	
	function afficherModalDetails(idAnnonceCovoiturage){
		
		$("#" + idAnnonceCovoiturage).modal("show");
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