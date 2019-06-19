<%@page import="fr.diginamic.model.Vehicule"%>
<%@page import="fr.diginamic.model.ReservationVoiture"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

<% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); %>
<% Map<ReservationVoiture, String> mapDesResaPassees = (Map<ReservationVoiture, String>) request.getAttribute("mapResaPassees"); %>
<% Map<ReservationVoiture, String> mapDesResaFutures = (Map<ReservationVoiture, String>) request.getAttribute("mapResaFutures"); %>

<h1>
	<a href="/gdt/controller/administrateur/vehicules" class="text-success">Vehicules</a>
	> <%= ((Vehicule) request.getAttribute("vehicule")).getImmatriculation() %>
</h1>
<div class="m-3 mt-4">
	<div class="row mt-md-5 mb-md-5">
		<div class="col-md-4">
			<img
				src="<%= ((Vehicule) request.getAttribute("vehicule")).getPhoto() %>">
		</div>
		<div class="col-md-4 mt-md-0 mt-3">
			<div class="row">
				<p class="col-md-4 col-6">Marque</p>
				<p class="col-md-8 col-6"><%= ((Vehicule) request.getAttribute("vehicule")).getMarque() %></p>
			</div>
			<div class="row">
				<p class="col-md-4 col-6">Modèle</p>
				<p class="col-md-8 col-6"><%= ((Vehicule) request.getAttribute("vehicule")).getModele() %></p>
			</div>
			<div class="row">
				<p class="col-md-4 col-6">Catégorie</p>
				<p class="col-md-8 col-6"><%= ((Vehicule) request.getAttribute("vehicule")).getCategorie() %></p>
			</div>
		</div>
	</div>

	<h5 class="mb-3">Prochaines réservations</h5>
	<% if (request.getAttribute("mapResaPassees") != null && !mapDesResaFutures.isEmpty()) {%>
	<table class="table table-bordered table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col" class="p-2">Date / heure début</th>
				<th scope="col" class="p-2">Date / heure fin</th>
				<th scope="col" class="p-2">Responsable</th>
			</tr>
		</thead>
		<tbody>
		<% for (Map.Entry<ReservationVoiture, String> entry : mapDesResaFutures.entrySet()) { %>
		    <% ReservationVoiture key = entry.getKey();  %>
		    <% String value = entry.getValue(); %>
				<tr>
					<th class="p-1 pl-2"><%= key.getDateTimeDeDebut().format(formatter) %></th>
					<td class="p-1 pl-2"><%= key.getDateTimeDeFin().format(formatter) %></td>
					<td class="p-1 pl-2"><%= value %></td>
				</tr>
		<% } %>
		</tbody>
	</table>
		<% } else { %>
		<p>Aucune réservation enregistrée.</p>
	<% } %>

	<h5 class="mb-3 mt-md-5">Historique des réservations</h5>
	<% if (request.getAttribute("mapResaPassees") != null && !mapDesResaPassees.isEmpty()) {%>
	<table class="table table-bordered table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col" class="p-2">Date / heure début</th>
				<th scope="col" class="p-2">Date / heure fin</th>
				<th scope="col" class="p-2">Responsable</th>
			</tr>
		</thead>
		<tbody>
			<% for (Map.Entry<ReservationVoiture, String> entry : mapDesResaPassees.entrySet()) { %>
			    <% ReservationVoiture key = entry.getKey();  %>
			    <% String value = entry.getValue(); %>
					<tr>
						<th class="p-1 pl-2"><%= key.getDateTimeDeDebut().format(formatter) %></th>
						<td class="p-1 pl-2"><%= key.getDateTimeDeFin().format(formatter) %></td>
						<td class="p-1 pl-2"><%= value %></td>
					</tr>
			<% } %>
		
		</tbody>
	</table>
	<% } else { %>
		<p>Aucune réservation enregistrée.</p>
	<% } %>
</div>

</body>
</html>

<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp"%>
<%@include file="../../jsp/dependanceScript.jsp"%>