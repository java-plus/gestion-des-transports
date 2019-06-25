<%@page import="fr.diginamic.model.Employe"%>
<%@ page pageEncoding="utf8" language="java"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- DEPENDENCES CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css'/>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap"
	rel="stylesheet">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.6.2/css/all.min.css' />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">


<title>Gestion des transports</title>
</head>

<body>
	<%
		Employe utilisateur = (Employe) session.getAttribute("utilisateur");
		String statut = utilisateur.getStatut();
	%>
	<header class="row">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark col-8">
			<a class="navbar-brand text-success ml-2 mr-2 bg-dark" href="/gdt/login"
				id="logo">G.T.</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav text-center">
					<%
						if (statut.equals("admin") || statut.equals("collaborateur")) {
					%>
					<a class="nav-item nav-link"
						href="http://localhost:8080/gdt/controller/collaborateur/reservations">Vos
						réservations</a> <a class="nav-item nav-link"
						href="http://localhost:8080/gdt/controller/collaborateur/annonces">Vos
						annonces</a> 
						<%-- <a class="nav-item nav-link"
						href="http://localhost:8080/gdt/controller/collaborateur/statistiques">Statistiques</a>
						 ---%>
					<%
						}
					%>
					<%
						if (statut.equals("admin")) {
					%>
					<a class="nav-item nav-link"
						href="http://localhost:8080/gdt/controller/administrateur/vehicules">Véhicules</a>
					<a class="nav-item nav-link"
						href="http://localhost:8080/gdt/controller/administrateur/chauffeurs">Chauffeurs</a>
					<%
						}
					%>
					<%
						if (statut.equals("chauffeur")) {
					%>
					<a class="nav-item nav-link"
						href="http://localhost:8080/gdt/controller/chauffeur/planning">Planning</a>
					<%--<a class="nav-item nav-link"
						href="http://localhost:8080/gdt/controller/chauffeur/occupation">Occupation</a>
					--%>
					<%
						}
					%>
				</div>
			</div>
		</nav>
		<div class="text-center col-4 bg-success p-2">
			<p class="text-dark m-0">
				Bonjour
				<%=utilisateur.getNom().toUpperCase()%>
				<%=utilisateur.getPrenom()%></p>
			<a class="text-success bg-dark p-1"
				href="http://localhost:8080/gdt/logout">Se déconnecter</a>
		</div>
	</header>

	<main class="p-3 m-3 text-dark">
	<div class="container">