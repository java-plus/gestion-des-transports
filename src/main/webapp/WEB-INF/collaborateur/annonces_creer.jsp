<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.model.AnnonceCovoiturage,fr.diginamic.model.Collaborateur,java.util.HashSet,java.util.Set"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

	<%
		String lieuDepart = (String) request.getAttribute("lieuDepart");
		String lieuArrive = (String) request.getAttribute("lieuArrive");
		String immatriculation = (String) request.getAttribute("immatriculation");
		String modele = (String) request.getAttribute("modele");
		String marque = (String) request.getAttribute("marque");
		String messageErreur = (String) request.getAttribute("messageErreur");
		Integer nbPlaceDispo = (Integer) request.getAttribute("nbPlaceDispo");
	%>
	
	<a href="/gdt/controller/collaborateur/annonces" class="text-success p-2 btn mb-3 font-weight-bold"> << Retour à la liste</a>
        
	<h1 class="mb-4">Publier une annonce</h1>
	<form method="POST" action="/gdt/controller/collaborateur/creerannonce/">
		<div class="container">
			<div class="card mb-1">
				<div class="card-header bg-dark text-light">
					<h5>Itinéraire</h5>
				</div>
				<div class="card-body">
					<div class="form-group row px-5">
						<label for="adresseDeDepart" class="text-right col-lg-3 py-1">Adresse de départ*</label>
						<input type="text" class="form-control col-lg-9" id="adresseDeDepart" required
								name="adresseDeDepart" placeholder="adresse (ex: Nantes, Bordeaux...)" onChange="contentChange()"
								<%if (lieuDepart != null) {%> value="<%=lieuDepart%>" <%}%>
						>
					</div>
						
					<div class="form-group row px-5">
						<label for="adresseDeDestination" class="text-right col-lg-3 py-1">Adresse de destination*</label>
						<input type="text" class="form-control col-lg-9" id="adresseDeDestination" required
								name="adresseDeDestination" placeholder="adresse (ex: Nantes, Bordeaux...)"
								<%if (lieuArrive != null) {%> value="<%=lieuArrive%>" <%}%> onChange="contentChange()">
					</div>
					<div class="form-group row px-5">
						<p class="card-text text-right col-lg-3 py-1" >Durée du trajet</p>
						<p id="duree" class="form-control col-lg-9"></p>
					</div>
					<div class="form-group row px-5">
						<p class="card-text text-right col-lg-3 py-1">Distance en km</p>
						<p id="distance" class="form-control col-lg-9"></p>
					</div>
				</div>
			</div>

			<div class="card mb-1">
				<div class="card-header bg-dark text-light">
					<h5>Véhicule</h5>
				</div>
						
				<div class="card-body">
					<%
						if (messageErreur != null) {
					%>
					<p class="card-text text-danger"><%=messageErreur%></p>
					<%
						}
					%>

					<div class="form-group row px-5">
						<label for="immatriculationModal" class="text-right col-lg-3 py-1">Immatriculation*</label> 
						<input type="text" id="immatriculationModal" id="immatriculationModal"
							name="immatriculationVehicule" class="form-control col-lg-9"
							placeholder="immatriculation (xx-123-xx)" pattern="[a-zA-Z]{2}-[0-9]{3}-[a-zA-Z]{2}" required
							<%if (immatriculation != null) {%> value="<%=immatriculation%>"	<%}%> onChange="contentChange()">
					</div>
					<div class="form-group row px-5">
						<label for="marqueModal" class="text-right col-lg-3 py-1">Marque*</label>
						<input type="text" class="form-control col-lg-9" id="marqueModal" name="marqueVehicule" required
						placeholder="marque" <%if (marque != null) {%> value="<%=marque%>" <%}%> onChange="contentChange()">
					</div>
					<div class="form-group row px-5">
						<label for="modeleModal" class="text-right col-lg-3 py-1">Modele*</label>
						<input type="text"
							class="form-control col-lg-9" id="modeleModal" name="modeleVehicule" required
							placeholder="modèle" <%if (modele != null) {%> value="<%=modele%>" <%}%> onChange="contentChange()">
					</div>
					<div class="form-group row px-5">
						<label for="nbPlacesModal" class="text-right col-lg-3 py-1">Nombre de places disponibles*</label>
						<input type="number" class="form-control col-lg-9" id="nbPlacesModal" required
							name="nbPlacesVehicule" placeholder="nombre de places"
							<%if (nbPlaceDispo != null) {%> value="<%=nbPlaceDispo%>" <%}%> onChange="contentChange()">
					</div>
				</div>
			</div>
					
			<div class="card mb-1">
			
				<div class="card-header bg-dark text-light">
					<h5>Date et horaire</h5>
				</div>

				<div class="row card-body">
				
					<div class="form-group col-6 d-flex">
						<p for="exampleFormControlSelect3" class="text-right p-2 d-block">Date/heure*</p>
						<input type="date" class="form-control" name="dateDeDepart" id="dateDeDepart" onChange="contentChange()" required>
						<label for="dateDeDepart"><i class="fas fa-calendar-alt p-2"></i></label>
					</div>
					
					<div class="form-group col-6 d-flex">
						<select	name="selectedHeureDeDepart" class="form-control" id="selectedHeureDeDepart" onChange="contentChange()" required>
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
							<p class="p-2">h</p>
							<select	name="selectedMinuteDeDepart" class="form-control" id="selectedMinuteDeDepart" onChange="contentChange()" required>
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
			
			<button type="button" class="btn btn-success float-right mt-2 mb-5" id="btnPublier"
					data-toggle="modal" data-target="#exampleModal" disabled>Publier</button>
					
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
						<p>Départ : <span id="departSpan"></span></p>
						<p>Destination : <span id="destinationSpan"></span></p>
						<p>Immatriculation : <span id="immatriculationSpan"></span></p>
						<p>Marque : <span id="marqueSpan"></span></p>
						<p>Modèle : <span id="modeleSpan"></span></p>
						<p>Nb places disponibles : <span id="placesSpan"></span></p>
						<p>Date / Heure : <span id="dateHeuresSpan"></span></p>
						<div class="modal-footer">
							<a href="/gdt/controller/collaborateur/annonces/"><button type="button" class="btn btn-dark" data-dismiss="modal">Annuler</button></a>
							<input type="submit" class="btn btn-success" value="Confirmer">
						</div>
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
    	$.ajax({
            url: "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+document.getElementById('adresseDeDepart').value+"&destinations="+document.getElementById('adresseDeDestination').value+"&key=AIzaSyBrXhHfdvdv1-lZnGwMxHMmxgtFuELKoGQ",
            dataType: "json",
            success: (result) => {

                var distanceMiles= result.rows[0].elements[0].distance.text;
                
                
                /([0-9]+)/.exec(distanceMiles);
                
                
                
                
                //J'utilise une condition ternaire =>
                
                let htmlDuree = result.rows[0].elements[0].duration.text;
                let htmlDistance = (RegExp.$1 * 1.61).toFixed(2) + " km";
                


                $("#duree").html(htmlDuree);
                $("#distance").html(htmlDistance);
            }
        });
            
    })
    
    $("#adresseDeDestination").change(function(){
    	$.ajax({
            url: "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+document.getElementById('adresseDeDepart').value+"&destinations="+document.getElementById('adresseDeDestination').value+"&key=AIzaSyBrXhHfdvdv1-lZnGwMxHMmxgtFuELKoGQ",
            dataType: "json",
            success: (result) => {

                var distanceMiles= result.rows[0].elements[0].distance.text;
                
                
                /([0-9]+)/.exec(distanceMiles);
                
                
                
                
                //J'utilise une condition ternaire =>
                
                let htmlDuree = result.rows[0].elements[0].duration.text;
                let htmlDistance = (RegExp.$1 * 1.61).toFixed(2) + " km";
                    


                $("#duree").html(htmlDuree);
                $("#distance").html(htmlDistance);
            }
        });
            
    })
    
    let adresseDeDepart = "";
    let adresseDeDestination = "";
    let immatriculationModal = "";
    let marqueModal = "";
    let modeleModal = "";
    let nbPlacesModal = "";
    let dateDeDepart = "";
    let selectedHeureDeDepart = "";
    let selectedMinuteDeDepart = "";
    let btnPublier = document.getElementById("btnPublier");
    					
	function contentChange() {
    	
	    adresseDeDepart = document.getElementById("adresseDeDepart").value;
	    adresseDeDestination = document.getElementById("adresseDeDestination").value;
	    immatriculationModal = document.getElementById("immatriculationModal").value;
	    marqueModal = document.getElementById("marqueModal").value;
	    modeleModal = document.getElementById("modeleModal").value;
	    nbPlacesModal = document.getElementById("nbPlacesModal").value;
	    dateDeDepart = document.getElementById("dateDeDepart").value;
	    selectedHeureDeDepart = document.getElementById("selectedHeureDeDepart").value;
	    selectedMinuteDeDepart = document.getElementById("selectedMinuteDeDepart").value;

	 	document.getElementById('departSpan').innerHTML = adresseDeDepart;
		document.getElementById('destinationSpan').innerHTML = adresseDeDestination;
		document.getElementById('immatriculationSpan').innerHTML = immatriculationModal;
		document.getElementById('marqueSpan').innerHTML = marqueModal;
		document.getElementById('modeleSpan').innerHTML = modeleModal;
		document.getElementById('placesSpan').innerHTML = nbPlacesModal;
		document.getElementById('dateHeuresSpan').innerHTML = dateDeDepart + " " + selectedHeureDeDepart + " h " + selectedMinuteDeDepart;
    	if(adresseDeDepart != "" && adresseDeDestination != "" && immatriculationModal != "" && marqueModal != "" && modeleModal != "" && nbPlacesModal != "" && dateDeDepart != "" && selectedHeureDeDepart != "" && selectedMinuteDeDepart != "") {
    		btnPublier.removeAttribute("disabled");
    	} else {
    		btnPublier.setAttribute("disabled", "");
    	}
    };
				
    </script>

</body>
</html>