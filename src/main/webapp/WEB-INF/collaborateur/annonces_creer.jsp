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
	<%
		String lieuDepart = (String) request.getAttribute("lieuDepart");
		String lieuArrive = (String) request.getAttribute("lieuArrive");
		String immatriculation = (String) request.getAttribute("immatriculation");
		String modele = (String) request.getAttribute("modele");
		String marque = (String) request.getAttribute("marque");
		String messageErreur = (String) request.getAttribute("messageErreur");
		Integer nbPlaceDispo = (Integer) request.getAttribute("nbPlaceDispo");
	%>
	<h1>Creer une annonce de covoiturage</h1>
	<form method="POST"
		action="/gdt/controller/collaborateur/creerannonce/">
		<div class="container">
			<div class="card">


				<div class="card-body">
					<div class="card-header">Itineraire</div>


					<div class="form-group">
						<label for="adresseDeDepart">Adresse de départ</label> <input
							type="text" class="form-control" id="adresseDeDepart"
							name="adresseDeDepart"
							placeholder="adresse (ex: Nantes, Bordeaux...)"
							<%if (lieuDepart != null) {%> value="<%=lieuDepart%>" <%}%>>
					</div>
					<div class="form-group">
						<label for="adresseDeDestination">Adresse de destination</label> <input
							type="text" class="form-control" id="adresseDeDestination"
							name="adresseDeDestination"
							placeholder="adresse (ex: Nantes, Bordeaux...)"
							<%if (lieuArrive != null) {%> value="<%=lieuArrive%>" <%}%>>
					</div>
					<p class="card-text" >durée du trajet</p><p id="duree"></p>
					<p class="card-text">distance en km</p><p id="distance"></p>

					<div class="card-header">Vehicule</div>


					<%
						if (messageErreur != null) {
					%>
					<p class="card-text text-danger"><%=messageErreur%></p>
					<%
						}
					%>


					<div class="form-group">
						<label for="immatriculationModal">Immatriculation:</label> <input
							type="text" class="form-control" id="immatriculationModal"
							name="immatriculationVehicule"
							placeholder="immatriculation (xx-123-xx)"
							<%if (immatriculation != null) {%> value="<%=immatriculation%>"
							<%}%>>
					</div>
					<div class="form-group">
						<label for="marqueModal">Marque:</label> <input type="text"
							class="form-control" id="marqueModal" name="marqueVehicule"
							placeholder="marque" <%if (marque != null) {%> value="<%=marque%>"
							<%}%>>
					</div>
					<div class="form-group">
						<label for="modeleModal">Modele:</label> <input type="text"
							class="form-control" id="modeleModal" name="modeleVehicule"
							placeholder="modèle" <%if (modele != null) {%> value="<%=modele%>"
							<%}%>>
					</div>
					<div class="form-group">
						<label for="nbPlacesModal">Nombre de places disponibles:</label> <input
							type="number" class="form-control" id="nbPlacesModal"
							name="nbPlacesVehicule" placeholder="nombre de place"
							<%if (nbPlaceDispo != null) {%> value="<%=nbPlaceDispo%>" <%}%>>
					</div>

					<div class="card-header">Date et horaire</div>

					<div class="row ">

						<div class="col-2"></div>
						<div class="col-8">
							<div class="row ">
								<div class="col-6">
									<div class="form-group">
										<label for="exampleFormControlSelect3">Date de départ</label>
										<input type="date" class="form-control" name="dateDeDepart"
											id="dateDeDepart">
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="exampleFormControlSelect1">Depart</label> <select
											name="selectedHeureDeDepart" class="form-control"
											id="exampleFormControlSelect1" onChange="">

											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>


										</select>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="exampleFormControlSelect1">Depart</label> <select
											name="selectedMinuteDeDepart" class="form-control"
											id="exampleFormControlSelect1" onChange="">

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
						<input type="button" class="btn btn-success" value="Enregistrer"
							data-toggle="modal" data-target="#exampleModal">
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
						<h5 class="modal-title" id="exampleModalLabel">Confirmation
							de votre annonce</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">

						<p>Départ :</p>
						<p>Destination :</p>
						<p>Immatriculation :</p>
						<p>Marque :</p>
						<p>Modèle :</p>
						<p>Nb places disponibles :</p>
						<p>Date / Heure :</p>
						<div class="modal-footer">
							<a href="/gdt/controller/collaborateur/annonces/"><button type="button" class="btn btn-dark" data-dismiss="modal">Annuler</button></a>
							<input type="submit" class="btn btn-success" value="Confirmer">
						</div>


					</div>
				</div>
			</div>
	</form>

	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>

	<script>
    $("#adresseDeDepart").change(function(){
        console.log("j’ai changé");
            $.ajax({
                url: "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+document.getElementById('adresseDeDepart').value+"&destinations="+document.getElementById('adresseDeDestination').value+"&key=AIzaSyBrXhHfdvdv1-lZnGwMxHMmxgtFuELKoGQ",
                dataType: "json",
                success: (result) => {
                   
                    	let htmlDistance = result.rows[0].elements[0].distance.text;
                    let htmlDuree = result.rows[0].elements[0].duration.text;
                    
                    $("#duree").html(htmlDuree);
                    $("#distance").html(htmlDistance);
                }
            });
            
    })
    
    $("#adresseDeDestination").change(function(){
        console.log("j’ai changé");
            $.ajax({
                url: "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+document.getElementById('adresseDeDepart').value+"&destinations="+document.getElementById('adresseDeDestination').value+"&key=AIzaSyBrXhHfdvdv1-lZnGwMxHMmxgtFuELKoGQ",
                dataType: "json",
                success: (result) => {
                    
                    
                    	let htmlDistance = result.rows[0].elements[0].distance.text;
                    let htmlDuree = result.rows[0].elements[0].duration.text;
                    
                    $("#duree").html(htmlDuree);
                    $("#distance").html(htmlDistance);
                }
            });
            
    })
    </script>

</body>
</html>