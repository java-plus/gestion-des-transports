<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.model.AnnonceCovoiturage,fr.diginamic.model.Collaborateur,java.time.format.DateTimeFormatter"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

<h1>Vos annonces</h1>
<a href="/gdt/controller/collaborateur/creerannonce/" class="btn btn-success float-right">Créer une nouvelle annonce</a>
<div class="m-3 mt-4">
	<h5 class="mt-5">Annonces en cours</h5>
	
		<%
			List<AnnonceCovoiturage> listeDesAnnoncesEnCours = (List<AnnonceCovoiturage>) request
						.getAttribute("listeDesAnnoncesEnCours");
			List<Integer> listeDesNombresDeReservationsEnCours = (List<Integer>) request
					.getAttribute("listeDesNombresDeReservationsEnCours");
			Integer n = 0;
			if(listeDesAnnoncesEnCours != null && listeDesAnnoncesEnCours.size() > 0) {
		%>
	
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Date / heure de départ</th>
				<th scope="col">Lieu de départ</th>
				<th scope="col">Lieu de destination</th>
				<th scope="col">Nombre de voyageurs</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<%
				for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnoncesEnCours) {
			%>
			<tr>
				<td><%=annonceCovoiturage.getDateDeDepart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
				<td><%=annonceCovoiturage.getLieuDeDepart()%></td>
				<td><%=annonceCovoiturage.getLieuDeDestination()%></td>
				<td><%=listeDesNombresDeReservationsEnCours.get(n)%></td>
				<td>
					<button type="submit" class="btn btn-success center-block" onclick="annulerCovoiturage(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">Annuler</button>
				</td>
			</tr>
			<%
				n++;}
			%>
		</tbody>
	</table>
	<% } else { %>
		<p>Aucune réservation enregistrée.</p>
	<% } %>
	
	
	<h5 class="mt-5">Historique</h5>
	
		<%
			List<AnnonceCovoiturage> listeDesAnnoncesPassees = (List<AnnonceCovoiturage>) request
						.getAttribute("listeDesAnnoncesPassees");
			List<Integer> listeDesNombresDeReservationsPassees = (List<Integer>) request
					.getAttribute("listeDesNombresDeReservationsPassees");
			Integer p = 0;
			if(listeDesAnnoncesEnCours != null && listeDesAnnoncesEnCours.size() > 0) {
		%>
	
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Date / heure de départ</th>
				<th scope="col">Lieu de départ</th>
				<th scope="col">Lieu de destination</th>
				<th scope="col">Nombre de voyageurs</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<%
				for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnoncesPassees) {
			%>
			<tr>
				<td><%=annonceCovoiturage.getDateDeDepart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
				<td><%=annonceCovoiturage.getLieuDeDepart()%></td>
				<td><%=annonceCovoiturage.getLieuDeDestination()%></td>
				<td><%=listeDesNombresDeReservationsEnCours.get(p)%></td>
				<td>
					<button type="submit" class="btn btn-success center-block" onclick="annulerCovoiturage(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">Annuler</button>
				</td>
			</tr>
			<%
				n++;}
			%>
		</tbody>
	</table>
	<% } else { %>
		<p>Aucune réservation enregistrée.</p>
	<% } %>
			
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