<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.model.AnnonceCovoiturage,fr.diginamic.model.Collaborateur,java.util.HashSet,java.util.Set"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>


<a href="/gdt/controller/collaborateur/reservations/creer" class="text-success font-weight-bold" >
        << Retour à la liste</a> <h1>Réserver un véhicule</h1>
            <div class="m-3 mt-4">

                <div id="accordion">
                    <div class="card ">
                        
                        <div class="card-header bg-dark text-light " id="headingOne">
                            <h5 class="mb-0">
                                <button class="btn btn-link collapsed text-light" data-toggle="collapse"
                                    data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Covoiturage
                                </button>
                            </h5>
                        </div>
						
                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                            data-parent="#accordion">
                            <div class="card-body">
                            <form method="POST" action="http://localhost:8080/gdt/controller/collaborateur/chercherannonces/">
		<div class="container ">
			<div class="row">

				<p></p>

			</div>
			<div class="row d-flex justify-content-center">

				<h1>Liste des covoiturages</h1>

			</div>
			<div class="row ">

				<div class="col-4">
					<div class="form-group">
						<label for="exampleFormControlSelect1">Depart</label>
						<%
							List<AnnonceCovoiturage> listeDesAnnonces = (List<AnnonceCovoiturage>) request
									.getAttribute("listeDesAnnonces");
							String lieuDeDepart = (String) request.getAttribute("lieuDeDepart");
								
								Integer idUtilisateur = (Integer)request.getAttribute("idUtilisateur");
							Set<String> listeDesLieuDeDepart = new HashSet<String>();
							for (AnnonceCovoiturage annonce : listeDesAnnonces) {
								listeDesLieuDeDepart.add(annonce.getLieuDeDepart());
							}
							listeDesLieuDeDepart.add("indeterminé");
						%>
						<select name="selectedLieuDeDepart" class="form-control"
							id="exampleFormControlSelect1" onChange="rechercheAvecCritere()">
							<%
								for (String depart : listeDesLieuDeDepart) {
							%>

							<option value="<%=depart%>"
								<%if (lieuDeDepart.equals(depart)) {%> selected="selected" <%}%>><%=depart%></option>

							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="col-4">
					<div class="form-group">
						<label for="exampleFormControlSelect2">Destination</label>
						<%
							String lieuDeDestination = (String) request.getAttribute("lieuDeDestination");
								
							Set<String> listeDesLieuDeDestination = new HashSet<String>();
							for (AnnonceCovoiturage annonce : listeDesAnnonces) {
								listeDesLieuDeDestination.add(annonce.getLieuDeDestination());
							}
							listeDesLieuDeDestination.add("indeterminé");
						%>
						<select name="selectedLieuDeDestination" class="form-control"
							id="exampleFormControlSelect1" onChange="rechercheAvecCritere()">
							<%
								for (String destination : listeDesLieuDeDestination) {
							%>

							<option value="<%=destination%>"
								<%if (lieuDeDestination.equals(destination)) {%>
								selected="selected" <%}%>><%=destination%></option>

							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
					<%
								String dateDeDepart = (String) request.getAttribute("dateDeDepart");
								//dateDeDepart = "\"" + dateDeDepart + "\"";
						%>
						<label for="exampleFormControlSelect3">Date</label>
						 <input
							type="date" class="form-control" 
							
							<%if (!dateDeDepart.equals("indeterminé")) {%>
								value="<%=dateDeDepart%>" <%}%>
								 
								 name="date"
							id="dateReservationVehiculeSociete" required onChange="rechercheAvecCritere()">
					</div>
				</div>
			</div>

		</div>
	</form>




	<div class="container mt-5">
		
			



				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">places disponibles</th>
							<th scope="col">date départ</th>
							<th scope="col">lieu départ</th>
							<th scope="col">lieu arrivée</th>
							<th scope="col">durée</th>
							<th scope="col">distance</th>
							<th scope="col">id utilisateur</th>
							<th scope="col">id vehicule</th>
							<th scope="col"></th>

						</tr>
					</thead>
					<tbody>



						<%
							for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnonces) {
						%>
						<tr>


							<td><%=annonceCovoiturage.getIdAnnonceCovoiturage()%></td>
							<td><%=annonceCovoiturage.getNbPlacesDisponibles()%></td>
							<td><%=annonceCovoiturage.getDateDeDepart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))%></td>
							<td><%=annonceCovoiturage.getLieuDeDepart()%></td>
							<td><%=annonceCovoiturage.getLieuDeDestination()%></td>
							<td><%=annonceCovoiturage.getDuree()%></td>
							<td><%=annonceCovoiturage.getDistanceEnKm()%></td>
							<td><%=annonceCovoiturage.getIdUtilisateur()%></td>
							<td><%=annonceCovoiturage.getIdVehicule()%></td>
							<td>
								<button type="submit" class="btn btn-primary center-block" onclick="reserverCovoiturage(<%=annonceCovoiturage.getIdAnnonceCovoiturage()%>)">Reserver</button>
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>

			
			
		
		
							
	</div>
                            </div>
                        </div>
                    </div>
                    <div class="card ">
                    <a href="/gdt/controller/collaborateur/reserverVehiculeSociete">
                        <div class="card-header bg-dark " id="headingTwo">
                            <h5 class="mb-0">
                                <button class="btn btn-link text-light " data-toggle="collapse"
                                    data-target="#collapseTwo " aria-expanded="false" aria-controls="collapseTwo">
                                    Véhicule de société
                                </button>
                            </h5>
                        </div>
                        </a>
                        <div id="collapseTwo" class="collapse " aria-labelledby="headingTwo" data-parent="#accordion">
                            <div class="card-body container ">
                                
                            </div>

                        </div>
                    </div>
                    
                </div>


            </div>


	
	
	<script type="text/javascript">
        function rechercheAvecCritere() {

            lieuDeDestination = "";
            lieuDeDepart = "";
            dateDeDepart="";

            if (document.forms[0].selectedLieuDeDestination.value == "indeterminé") {
                lieuDeDestination = "indeterminé";

            } else {
                lieuDeDestination = document.forms[0].selectedLieuDeDestination.value;
            }
            if (document.forms[0].selectedLieuDeDepart.value == "indeterminé") {
                lieuDeDepart = "indeterminé";

            } else {
                lieuDeDepart = document.forms[0].selectedLieuDeDepart.value;
            }
            if (document.forms[0].date.value=="") {
            	dateDeDepart = "indeterminé";

            } else {
            	dateDeDepart = document.forms[0].date.value;
            }

            document.location.href = "http://localhost:8080/gdt/controller/collaborateur/chercherannoncesAvecCritere?lieuDeDestination="
                    + lieuDeDestination + "&lieuDeDepart=" + lieuDeDepart+ "&dateDeDepart=" + dateDeDepart;

        }
        
    
        function reserverCovoiturage(idAnnonceCovoiturage) {


			document.location.href = "http://localhost:8080/gdt/controller/collaborateur/reserverCovoiturage?idAnnonceCovoiturage="
					+ idAnnonceCovoiturage;

		}

        </script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>

		<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>

</body>
</html>