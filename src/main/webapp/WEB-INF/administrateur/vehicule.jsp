<%@page import="fr.diginamic.model.Vehicule"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

<h1>
	<a href="/gdt/controller/collaborateur/vehicules" class="text-success">Vehicules</a>
	> Immatriculation
</h1>
<div class="m-3 mt-4">
	<div class="row mt-md-5 mb-md-5">
		<div class="col-md-4">
			<img
				src="https://www.challenges.fr/assets/img/2018/08/27/cover-r4x3w1000-5b84072224873-pbc18-conference-09-jpg.jpg">
		</div>
		<div class="col-md-4 mt-md-0 mt-3">
			<div class="row">
				<p class="col-md-4 col-6">Marque</p>
				<p class="col-md-8 col-6">LALALA</p>
			</div>
			<div class="row">
				<p class="col-md-4 col-6">Modèle</p>
				<p class="col-md-8 col-6">LALALA</p>
			</div>
			<div class="row">
				<p class="col-md-4 col-6">Catégorie</p>
				<p class="col-md-8 col-6">LALALA</p>
			</div>
		</div>
	</div>

	<h5 class="mb-3">Prochaines réservations</h5>

	<table class="table table-bordered table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col" class="p-2">Date / heure début</th>
				<th scope="col" class="p-2">Date / heure fin</th>
				<th scope="col" class="p-2">Responsable</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th class="p-1 pl-2">1</th>
				<td class="p-1 pl-2">Mark</td>
				<td class="p-1 pl-2">Otto</td>
			</tr>
		</tbody>
	</table>

	<h5 class="mb-3 mt-5">Historique des réservations</h5>

	<table class="table table-bordered table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col" class="p-2">Date / heure début</th>
				<th scope="col" class="p-2">Date / heure fin</th>
				<th scope="col" class="p-2">Responsable</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th class="p-1 pl-2">1</th>
				<td class="p-1 pl-2">Mark</td>
				<td class="p-1 pl-2">Otto</td>
			</tr>
		</tbody>
	</table>
</div>

</body>
</html>

<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp"%>
<%@include file="../../jsp/dependanceScript.jsp"%>