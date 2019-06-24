<%@page import="fr.diginamic.model.Chauffeur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

<% List<Chauffeur> listeDesChauffeurs = (List<Chauffeur>) request.getAttribute("listeDesChauffeurs"); %>

            <h1>Gérer les chauffeurs</h1>
            <div class="m-3 mt-4"></div>
            <!-- HERE -->
            <div class="p-0 pl-3 row">
                <div class="col-12 col-md-6" style="max-width: 500px;">
                    <h5 class="p-2">Filtre</h5>
                    <div class="form-group text-left row container">
                        <label for="matricule" class="col-4 m-0 p-2">Matricule</label>
                        <input name="matricule" type="text" class="form-control col-8" id="matricule">
                    </div>
                    <div class="form-group row container">
                        <label for="nom" class="col-4 m-0 p-2">Nom</label>
                        <input name="nom" type="text" class="form-control col-8" id="nom">
                    </div>
                    <div class="form-group row container">
                        <label for="prenom" class="col-4 m-0 p-2">Prenom</label>
                        <input name="prenom" type="text" class="form-control col-8" id="prenom">
                    </div>
                </div>
                <div class="text-right col-12 col-md-6 d-flex justify-content-end">
                    <input id="myInput" type="button" class="btn btn-dark align-self-end" data-toggle="modal" data-target="#exampleModal" value="Ajouter un chauffeur">
                </div>
            </div>

            <div class="row mt-5" id="chauffeurs">
            
            <% for (Chauffeur chauffeur : listeDesChauffeurs) {  %>
                <div class="col-12 col-xl-6 mb-3">
                    <div class="card pb-3 shadow">
                        <div class="card-header bg-white">
                            <%= chauffeur.getNom().toUpperCase() %>
                            <%= chauffeur.getPrenom() %>
                        </div>
                        <div class="card-body row">
                            <img src="<%= chauffeur.getPhoto() %>"
                                alt="photo du chauffeur" class="col-sm-5 col-12 mb-3" style="height:100%;"></img>
                            <div class="col-12 col-sm-7 pr-0">
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Nom
                                    </p>
                                    <p class="col-8 pr-0">
                                        <%= chauffeur.getNom() %>
                                    </p>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Prénom
                                    </p>
                                    <p class="col-8 pr-0">
                                        <%= chauffeur.getPrenom() %>
                                    </p>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Permis
                                    </p>
                                    <p class="col-8 pr-0">
                                        <%= chauffeur.getPermis() %>
                                    </p>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Email
                                    </p>
                                    <a href="mailto:<%= chauffeur.getEmail() %>" class="text-success"><small class="col-8 pr-0">
                                        <%= chauffeur.getEmail() %>
                                    </small></a>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Téléphone
                                    </p>
                                    <p class="col-8 pr-0">
                                        <%= chauffeur.getTelephone() %>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                
             <% } %>
            </div>

	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	
	        <!-- DEBUT MODALE -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Nouveau chauffeur</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form method="POST" action="/gdt/controller/administrateur/chauffeurs/ajouter">
                    	<div class="modal-body text-left container">
                            <div class="form-group d-flex">
                                <label style="width: 35%" for="matriculeModal" class="p-2">Matricule</label>
                                <input style="width: 75%" type="text" class="form-control w-10" id="matriculeModal"
                                    name="matriculeModal" placeholder="numéro de matricule" required>
                            </div>
                            
                            <div class="form-group d-flex">
                                <label style="width: 35%" for="nomModal" class="p-2">Nom</label>
                                <input style="width: 75%" type="text" class="form-control" id="nomModal" name="nomModal"
                                    placeholder="Dupuis" required>
                            </div>
                            
                            <div class="form-group d-flex">
                                <label style="width: 35%" for="prenomModal" class="p-2">Prénom</label>
                                <input style="width: 75%" type="text" class="form-control" id="prenomModal"
                                    name="prenomModal" placeholder="Jean" required>
                            </div>
                            
                            <div class="form-group d-flex">
                                <label style="width: 35%" for="mdpModal" class="p-2">Mot de passe</label>
                                <input style="width: 75%" type="password" class="form-control" id="mdpModal"
                                    name="mdpModal" placeholder="6 caractères ou plus" pattern=".{6,}" required>
                            </div>
                            
                            <div class="form-group d-flex">
                                <label style="width: 35%" for="permisModal" class="p-2">Permis</label>
                                <input style="width: 75%" type="text" class="form-control" id="permisModal"
                                    name="permisModal" placeholder="numéro de permis" required>
                            </div>

                            <div class="form-group d-flex">
                                <label style="width: 35%" for="emailModal" class="p-2">Email</label>
                                <input style="width: 75%" type="email" class="form-control" id="emailModal"
                                    name="emailModal" placeholder="exemple@mail.com" required>
                            </div>

                            <div class="form-group d-flex">
                                <label style="width: 35%" for="telephoneModal" class="p-2">Téléphone</label>
                                <input style="width: 75%" type="tel" class="form-control" id="telephoneModal"
                                    name="telephoneModal" placeholder="06.24.24.24.24" pattern="[0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2}" required>
                            </div>

                            <div class="form-group d-flex">
                                <label style="width: 35%" for="photoModal" class="p-2">Photographie</label>
                                <input style="width: 75%" type="url" class="form-control" id="photoModal"
                                    name="photoModal" placeholder="lien url de l'image" required>
                            </div>

                    	</div>
	                    <div class="modal-footer">
	                        <button type="button" class="btn btn-dark" data-dismiss="modal">Annuler</button>
	                        <input type="submit" class="btn btn-success">
	                    </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- FIN MODALE -->
        
	<%@include file="../../jsp/dependanceScript.jsp"%>
	
	<!-- JS : REQUETES AJAX POUR LE FILTRE -->
	
	<script>
	$("#matricule").change(function(){
		    $.ajax({
		        url: "/gdt/controller/refreshMatriculeChauffeur?matricule="+document.getElementById('matricule').value,
		        dataType: "json",
		        success: (result) => {
		        	let html = '';
		        	result.forEach((chauffeur)=>
		        	{
		        		html += '<div class="col-12 col-xl-6 mb-3">';
	                    	html+= '<div class="card pb-3 shadow">';
	                    		html+= '<div class="card-header bg-white">' + chauffeur.nom + ' ' + chauffeur.prenom + '</div>'
	                    		html+= '<div class="card-body row">'
	                    			html+= '<img src="' + chauffeur.photo + 'alt="photo du chauffeur" class="col-sm-5 col-12 mb-3" style="height:100%;"></img>'
	                        		html+= '<div class="col-12 col-sm-7 pr-0">'
	                        			html+= '<div class="row">'
	                        				html+= '<p class="col-4 pr-0">Nom</p>'
	                        				html+= '<p class="col-8 pr-0">' + chauffeur.nom + '</p>'
                    					html+= '</div>'
	                        			html+= '<div class="row">'
	                        				html+= '<p class="col-4 pr-0">Prénom</p>'
	                        				html+= '<p class="col-8 pr-0">' + chauffeur.prenom + '</p>'
                       					html+= '</div>'
                       					html+= '<div class="row">'
    	                        			html+= '<p class="col-4 pr-0">Permis</p>'
    	                        			html+= '<p class="col-8 pr-0">' + chauffeur.permis + '</p>'
                           				html+= '</div>'
                           				html+= '<div class="row">'
    	                        			html+= '<p class="col-4 pr-0">Email</p>'
    	                        			html+= '<a href="mailto:' + chauffeur.email + '"class="text-success">'
    	                        				html+= '<small class="col-8 pr-0">' + chauffeur.email + '</small>'
    	                        			html+= '</a>'
                           				html+= '</div>'
                           				html+= '<div class="row">'
        	                        		html+= '<p class="col-4 pr-0">Téléphone</p>'
        	                        		html+= '<p class="col-8 pr-0">' + chauffeur.telephone + '</p>'
                               			html+= '</div>'
                               			html+= '</div></div></div></div>'
	                });

		            $("#chauffeurs").html(html);
		        }
		    });
	
	})
	
	$("#prenom").change(function(){
		    $.ajax({
		        url: "/gdt/controller/refreshPrenomChauffeur?prenom="+document.getElementById('prenom').value,
		        dataType: "json",
		        success: (result) => {
		        	let html = '';
		        	result.forEach((chauffeur)=>
		        	{
		        		html += '<div class="col-12 col-xl-6 mb-3">';
	                    	html+= '<div class="card pb-3 shadow">';
	                    		html+= '<div class="card-header bg-white">' + (chauffeur.nom).toUpperCase() + ' ' + chauffeur.prenom + '</div>'
	                    		html+= '<div class="card-body row">'
	                    			html+= '<img src="' + chauffeur.photo + 'alt="photo du chauffeur" class="col-sm-5 col-12 mb-3" style="height:100%;"></img>'
	                        		html+= '<div class="col-12 col-sm-7 pr-0">'
	                        			html+= '<div class="row">'
	                        				html+= '<p class="col-4 pr-0">Nom</p>'
	                        				html+= '<p class="col-8 pr-0">' + chauffeur.nom + '</p>'
                    					html+= '</div>'
	                        			html+= '<div class="row">'
	                        				html+= '<p class="col-4 pr-0">Prénom</p>'
	                        				html+= '<p class="col-8 pr-0">' + chauffeur.prenom + '</p>'
                       					html+= '</div>'
                       					html+= '<div class="row">'
    	                        			html+= '<p class="col-4 pr-0">Permis</p>'
    	                        			html+= '<p class="col-8 pr-0">' + chauffeur.permis + '</p>'
                           				html+= '</div>'
                           				html+= '<div class="row">'
    	                        			html+= '<p class="col-4 pr-0">Email</p>'
    	                        			html+= '<a href="mailto:' + chauffeur.email + '"class="text-success">'
    	                        				html+= '<small class="col-8 pr-0">' + chauffeur.email + '</small>'
    	                        			html+= '</a>'
                           				html+= '</div>'
                           				html+= '<div class="row">'
        	                        		html+= '<p class="col-4 pr-0">Téléphone</p>'
        	                        		html+= '<p class="col-8 pr-0">' + chauffeur.telephone + '</p>'
                               			html+= '</div>'
                               			html+= '</div></div></div></div>'
	                });

		            $("#chauffeurs").html(html);
		        }
		    });
	
	})
	
	$("#nom").change(function(){
		    $.ajax({
		        url: "/gdt/controller/refreshNomChauffeur?nom="+document.getElementById('nom').value,
		        dataType: "json",
		        success: (result) => {
		        	let html = '';
		        	result.forEach((chauffeur)=>
		        	{
		        		html += '<div class="col-12 col-xl-6 mb-3">';
	                    	html+= '<div class="card pb-3 shadow">';
	                    		html+= '<div class="card-header bg-white">' + (chauffeur.nom).toUpperCase() + ' ' + chauffeur.prenom + '</div>'
	                    		html+= '<div class="card-body row">'
	                    			html+= '<img src="' + chauffeur.photo + 'alt="photo du chauffeur" class="col-sm-5 col-12 mb-3" style="height:100%;"></img>'
	                        		html+= '<div class="col-12 col-sm-7 pr-0">'
	                        			html+= '<div class="row">'
	                        				html+= '<p class="col-4 pr-0">Nom</p>'
	                        				html+= '<p class="col-8 pr-0">' + chauffeur.nom + '</p>'
                    					html+= '</div>'
	                        			html+= '<div class="row">'
	                        				html+= '<p class="col-4 pr-0">Prénom</p>'
	                        				html+= '<p class="col-8 pr-0">' + chauffeur.prenom + '</p>'
                       					html+= '</div>'
                       					html+= '<div class="row">'
    	                        			html+= '<p class="col-4 pr-0">Permis</p>'
    	                        			html+= '<p class="col-8 pr-0">' + chauffeur.permis + '</p>'
                           				html+= '</div>'
                           				html+= '<div class="row">'
    	                        			html+= '<p class="col-4 pr-0">Email</p>'
    	                        			html+= '<a href="mailto:' + chauffeur.email + '"class="text-success">'
    	                        				html+= '<small class="col-8 pr-0">' + chauffeur.email + '</small>'
    	                        			html+= '</a>'
                           				html+= '</div>'
                           				html+= '<div class="row">'
        	                        		html+= '<p class="col-4 pr-0">Téléphone</p>'
        	                        		html+= '<p class="col-8 pr-0">' + chauffeur.telephone + '</p>'
                               			html+= '</div>'
                               			html+= '</div></div></div></div>'
	                });

		            $("#chauffeurs").html(html);
		        }
		    });
	
	})
	</script>
	
	</body>
	</html>