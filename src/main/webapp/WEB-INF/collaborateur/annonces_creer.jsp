<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.model.AnnonceCovoiturage,fr.diginamic.model.Collaborateur,java.util.HashSet,java.util.Set"%>
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
	<h1>Creer une annonce de covoiturage</h1>
	<div class="container">
		<div class="card">
			<form method="POST"
				action="/gdt/controller/collaborateur/annonce/creer/">

				<div class="card-body">
					<div class="card-header">Itineraire</div>


					<div class="form-group">
						<label for="adresseDeDepart">Adresse de départ</label> <input
							type="text" class="form-control" id="adresseDeDepart"
							name="adresseDeDepart"
							placeholder="adresse (ex: Nantes, Bordeaux...)" required>
					</div>
					<div class="form-group">
						<label for="adresseDeDepart">Adresse de départ</label> <input
							type="text" class="form-control" id="adresseDeDepart"
							name="adresseDeDepart"
							placeholder="adresse (ex: Nantes, Bordeaux...)" required>
					</div>
					<p class="card-text">durée du trajet</p>
					<p class="card-text">distance en km</p>

					<div class="card-header">Vehicule</div>

					<div class="form-group">
						<label for="immatriculationModal">Immatriculation:</label> <input
							type="text" class="form-control" id="immatriculationModal"
							name="immatriculationModal"
							placeholder="immatriculation (xx-123-xx)"
							pattern="[a-zA-Z]{2}-[0-9]{3}-[a-zA-Z]{2}" required>
					</div>
					<div class="form-group">
						<label for="marqueModal">Marque:</label> <input type="text"
							class="form-control" id="marqueModal" name="marqueModal"
							placeholder="marque" required>
					</div>
					<div class="form-group">
						<label for="modeleModal">Modele:</label> <input type="text"
							class="form-control" id="modeleModal" name="modeleModal"
							placeholder="modèle" required>
					</div>
					<div class="form-group">
						<label for="nbPlacesModal">Nombre de places disponibles:</label> <input
							type="number" class="form-control" id="nbPlacesModal"
							name="nbPlacesModal" placeholder="nombre de place">
					</div>

					<div class="card-header">Date et horaire</div>

					<div class="row ">

						<div class="col-2"></div>
						<div class="col-8">
							<div class="row ">
								<div class="col-6">
									<div class="form-group">
										<label for="exampleFormControlSelect3">Destination</label> <input
											type="date" class="form-control" name="date"
											id="dateReservationVehiculeSociete" required>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="exampleFormControlSelect1">Depart</label> <select
											name="selectedLieuDeDepart" class="form-control"
											id="exampleFormControlSelect1"
											onChange="rechercheAvecCritere()">

											<option value="00">00</option>
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
											<option value="40">40</option>
											<option value="50">50</option>

										</select>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="exampleFormControlSelect1">Depart</label> <select
											name="selectedLieuDeDepart" class="form-control"
											id="exampleFormControlSelect1"
											onChange="rechercheAvecCritere()">

											<option value="00">00</option>
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
											<option value="40">40</option>
											<option value="50">50</option>

										</select>
									</div>
								</div>
							</div>
							<div class="col-2"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-dark" data-dismiss="modal">Fermer</button>
						<input type="button" class="btn btn-success" value="Enregistrer" data-toggle="modal" data-target="#exampleModal">
					</div>
				</div>
		</div>
		</form>
	</div>
	
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmation de votre annonce</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form method="POST" action="/gdt/controller/administrateur/vehicules/">
        <p>Départ : </p>
        <p>Destination : </p>
        <p>Immatriculation : </p>
        <p>Marque : </p>
        <p>Modèle : </p>
        <p>Nb places disponibles : </p>
        <p>Date / Heure : </p>
        <div class="modal-footer">
						<button type="button" class="btn btn-dark" data-dismiss="modal">Annuler</button>
						<input type="button" class="btn btn-success" value="Confirmer" data-toggle="modal" data-target="#exampleModal">
					</div>
					
      </form>
    </div>
  </div>
</div>

	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>
</body>
</html>