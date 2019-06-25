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



				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">date départ</th>
							<th scope="col">lieu départ</th>
							<th scope="col">lieu arrivée</th>
							<th scope="col">Nombre de voyageurs</th>
							
							

						</tr>
					</thead>
					<tbody>



						<%
							List<AnnonceCovoiturage> listeDesAnnonces = (List<AnnonceCovoiturage>) request
									.getAttribute("listeDesAnnonces");
						List<Integer> listeDesNombresDeReservations = (List<Integer>) request
								.getAttribute("listeDesNombresDeReservations");
						Integer n = 0;
							for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnonces) {
						%>
						<tr>


							<td><%=annonceCovoiturage.getDateDeDepart()%></td>
							<td><%=annonceCovoiturage.getLieuDeDepart()%></td>
							<td><%=annonceCovoiturage.getLieuDeDestination()%></td>
							<td><%=listeDesNombresDeReservations.get(n)%></td>
								
							
						
							<td>
								<button type="submit" class="btn btn-primary center-block" onclick="annulerCovoiturage(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">Supprimer</button>
							</td>
						</tr>
						<%
							n++;}
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