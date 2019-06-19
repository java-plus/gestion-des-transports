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
	<form method="POST" action="/gdt/controller/collaborateur/creerannonce/">
	<div class="container">
		<div class="card">
			

				<div class="card-body">
					<div class="card-header">Itineraire</div>


					<div class="form-group">
						<label for="adresseDeDepart">Adresse de départ</label> <input
							type="text" class="form-control" id="adresseDeDepart"
							name="adresseDeDepart"
							placeholder="adresse (ex: Nantes, Bordeaux...)" >
					</div>
					<div class="form-group">
						<label for="adresseDeDestination">Adresse de destination</label> <input
							type="text" class="form-control" id="adresseDeDepart"
							name="adresseDeDestination"
							placeholder="adresse (ex: Nantes, Bordeaux...)" >
					</div>
					<p class="card-text">durée du trajet</p>
					<p class="card-text">distance en km</p>

					<div class="card-header">Vehicule</div>

					<div class="form-group">
						<label for="immatriculationModal">Immatriculation:</label> <input
							type="text" class="form-control" id="immatriculationModal"
							name="immatriculationVehicule"
							placeholder="immatriculation (xx-123-xx)"
							pattern="[a-zA-Z]{2}-[0-9]{3}-[a-zA-Z]{2}" >
					</div>
					<div class="form-group">
						<label for="marqueModal">Marque:</label> <input type="text"
							class="form-control" id="marqueModal" name="marqueVehicule"
							placeholder="marque" >
					</div>
					<div class="form-group">
						<label for="modeleModal">Modele:</label> <input type="text"
							class="form-control" id="modeleModal" name="modeleVehicule"
							placeholder="modèle" >
					</div>
					<div class="form-group">
						<label for="nbPlacesModal">Nombre de places disponibles:</label> <input
							type="number" class="form-control" id="nbPlacesModal"
							name="nbPlacesVehicule" placeholder="nombre de place">
					</div>

					<div class="card-header">Date et horaire</div>

					<div class="row ">

						<div class="col-2"></div>
						<div class="col-8">
							<div class="row ">
								<div class="col-6">
									<div class="form-group">
										<label for="exampleFormControlSelect3">Date de départ</label> <input
											type="date" class="form-control" name="dateDeDepart"
											id="dateDeDepart" >
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="exampleFormControlSelect1">Depart</label> <select
											name="selectedHeureDeDepart" class="form-control"
											id="exampleFormControlSelect1"
											onChange="">

											<option value="00">01</option>
											<option value="10">02</option>
											<option value="20">03</option>
											<option value="30">04</option>
											<option value="40">05</option>
											<option value="50">06</option>
											<option value="00">07</option>
											<option value="10">08</option>
											<option value="20">09</option>
											<option value="30">10</option>
											<option value="40">11</option>
											<option value="50">12</option>
											<option value="00">13</option>
											<option value="10">14</option>
											<option value="20">15</option>
											<option value="30">16</option>
											<option value="40">17</option>
											<option value="50">18</option>
											<option value="00">19</option>
											<option value="10">20</option>
											<option value="20">21</option>
											<option value="30">22</option>
											<option value="40">23</option>
											

										</select>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="exampleFormControlSelect1">Depart</label> <select
											name="selectedMinuteDeDepart" class="form-control"
											id="exampleFormControlSelect1"
											onChange="">

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
      
        <p>Départ : </p>
        <p>Destination : </p>
        <p>Immatriculation : </p>
        <p>Marque : </p>
        <p>Modèle : </p>
        <p>Nb places disponibles : </p>
        <p>Date / Heure : </p>
        <div class="modal-footer">
						<button type="button" class="btn btn-dark" data-dismiss="modal">Annuler</button>
						<input type="submit" class="btn btn-success" value="Confirmer" >
					</div>
					
      
    </div>
  </div>
</div>
</form>

	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>
</body>
</html>