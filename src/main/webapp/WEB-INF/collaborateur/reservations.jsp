<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.model.AnnonceCovoiturage,fr.diginamic.model.Collaborateur, fr.diginamic.model.ReservationVoiture, java.time.format.DateTimeFormatter,java.time.LocalDate"%>

<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>		

		<h1>Vos réservations</h1>
		<div class="m-3 mt-4">
			<div id="accordion">
				<div class="car ">
					<a href="/gdt/controller/collaborateur/reservations/creer">
						<div class="card-header bg-dark text-light" id="headingOne">
							<h5 class="mb-0">
								<button class="btn btn-link collapsed text-light"
									data-toggle="collapse" data-target="#collapseOne"
									aria-expanded="false" aria-controls="collapseOne">
									Covoiturage
								</button>
							</h5>
						</div>
					</a>
					<div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
						<div class="card-body"></div>
					</div>
				</div>
				<div class="card ">
					<div class="card-header bg-dark " id="headingTwo">
						<h5 class="mb-0">
							<button class="btn btn-link text-light show"
								data-toggle="collapse" data-target="#collapseTwo "
								aria-expanded="true" aria-controls="collapseTwo">
								Véhicule de société</button>
						</h5>
					</div>
					<div id="collapseTwo" class="collapse show"
						aria-labelledby="headingTwo" data-parent="#accordion">
						<div class="card-body container ">
							<div class="float-right">
	<a href="/gdt/controller/collaborateur/reserverVehiculeSociete">
		<button type="submit" class="btn btn-success center-block mb-3">Réserver un transport</button>
	</a>
</div>
							<div><b>Réservations en cours</b></div>
							
							<% List<ReservationVoiture> listeDesReservationsVehiculeFutur = (List<ReservationVoiture>) request.getAttribute("listeDesReservationsVehiculeFutur");%>
							<% if (request.getAttribute("listeDesReservationsVehiculeFutur") != null && !listeDesReservationsVehiculeFutur.isEmpty()) {%>
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Date départ</th>
										<th scope="col">Date retour</th>
										<th scope="col">Immatriculation</th>
										<th scope="col">Marque</th>
										<th scope="col">Modèle</th>
<!-- 									<th scope="col">Chauffeur</th> -->
									</tr>
								</thead>
								<tbody>

									<%
										for (int i = 0; i < listeDesReservationsVehiculeFutur.size(); i++) {
									%>
									<tr>


										<td><%=listeDesReservationsVehiculeFutur.get(i).getDateTimeDeDebut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
										<td><%=listeDesReservationsVehiculeFutur.get(i).getDateTimeDeFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
										<td><%=listeDesReservationsVehiculeFutur.get(i).getImmatriculation()%></td>
										<td><%=listeDesReservationsVehiculeFutur.get(i).getMarque()%></td>
										<td><%=listeDesReservationsVehiculeFutur.get(i).getModele()%></td>
<%-- 									<td><%=listeDesReservationsVehiculeFutur.get(i).getNomChauffeur()%></td> --%>
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
							<% } else { %>
								<p>Aucune réservation enregistrée.</p>
							<% } %>

							<div><b>Historique</b></div>
							<% List<ReservationVoiture> listeDesReservationsVehiculePassees = (List<ReservationVoiture>) request.getAttribute("listeDesReservationsVehiculePassees"); %>
							<% if (request.getAttribute("listeDesReservationsVehiculePassees") != null && !listeDesReservationsVehiculePassees.isEmpty()) {%>

							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Date départ</th>
										<th scope="col">Date retour</th>
										<th scope="col">Immatriculation</th>
										<th scope="col">Marque</th>
										<th scope="col">Modèle</th>
									</tr>
								</thead>
								<tbody>

									<%
										for (int i = 0; i < listeDesReservationsVehiculePassees.size(); i++) {
											System.out.println("qtt liste resa = " + listeDesReservationsVehiculePassees.size());
											System.out.println("i = " + i);
									%>
									
									<tr>
										<td><%=listeDesReservationsVehiculePassees.get(i).getDateTimeDeDebut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
										<td><%=listeDesReservationsVehiculePassees.get(i).getDateTimeDeFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
										<td><%=listeDesReservationsVehiculePassees.get(i).getImmatriculation()%></td>
										<td><%=listeDesReservationsVehiculePassees.get(i).getMarque()%></td>
										<td><%=listeDesReservationsVehiculePassees.get(i).getModele()%></td>
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
							
							<% } else { %>
								<p>Aucune réservation enregistrée.</p>
							<% } %>

						</div>

					</div>

				</div>
			</div>
	</div>
	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp"%>
<%@include file="../../jsp/dependanceScript.jsp"%>
           
</body>
</html>