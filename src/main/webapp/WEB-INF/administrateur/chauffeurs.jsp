<%@page import="fr.diginamic.model.Chauffeur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

            <h1>Gérer les chauffeurs</h1>
            <div class="m-3 mt-4"></div>
            <!-- HERE -->
            <div class="p-0 pl-3 row">
                <div class="col-12 col-md-6" style="max-width: 500px;">
                    <h5 class="p-2">Filtre</h5>
                    <div class="form-group text-left row container">
                        <label for="inputMatricule" class="col-4 m-0 p-2">Matricule</label>
                        <input name="inputMatricule" type="text" class="form-control col-8" id="inputMatricule"
                            required>
                    </div>
                    <div class="form-group row container">
                        <label for="inputNom" class="col-4 m-0 p-2">Nom</label>
                        <input name="inputNom" type="text" class="form-control col-8" id="inputNom" required>
                    </div>
                    <div class="form-group row container">
                        <label for="inputPrenom" class="col-4 m-0 p-2">Prenom</label>
                        <input name="inputPrenom" type="text" class="form-control col-8" id="inputPrenom" required>
                    </div>
                </div>
                <div class="text-right col-12 col-md-6 d-flex justify-content-end">
                    <input id="myInput" type="button" class="btn btn-dark align-self-end" data-toggle="modal" data-target="#exampleModal" value="Ajouter un chauffeur">
                </div>
            </div>

            <div class="row mt-5">
                <div class="col-12 col-xl-6">
                    <div class="card pb-3 shadow">
                        <div class="card-header bg-white">
                            NOM Prénom
                        </div>
                        <div class="card-body row">
                            <img src="https://www.vtc-solutions.com/vtc-assets/uploads/2016/04/Formation-vtc.jpg"
                                alt="photo du chauffeur" class="col-sm-5 col-12 mb-3" style="height:100%;"></img>
                            <div class="col-12 col-sm-7 pr-0">
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Nom
                                    </p>
                                    <p class="col-8 pr-0">
                                        Loyde
                                    </p>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Prénom
                                    </p>
                                    <p class="col-8 pr-0">
                                        Arthur
                                    </p>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Permis
                                    </p>
                                    <p class="col-8 pr-0">
                                        KDJHFKJDBFS
                                    </p>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Email
                                    </p>
                                    <p class="col-8 pr-0">
                                        kdsjf@dskhf.com
                                    </p>
                                </div>
                                <div class="row">
                                    <p class="col-4 pr-0">
                                        Téléphone
                                    </p>
                                    <p class="col-8 pr-0">
                                        06.89.03.03.24
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
                    <div class="modal-body">
                        <form method="POST" action="/gdt/controller/administrateur/chauffeurs/ajouter"
                            class="text-left container">
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
                                <label style="width: 35%" for="permisModal" class="p-2">Permis</label>
                                <input style="width: 75%" type="text" class="form-control" id="permisModal"
                                    name="permisModal" placeholder="numéro de permis" required>
                            </div>

                            <div class="form-group d-flex">
                                <label style="width: 35%" for="emailModal" class="p-2">Email</label>
                                <input style="width: 75%" type="email" class="form-control" id="emailModal"
                                    name="emailModal" placeholder="exemple@mail.com">
                            </div>

                            <div class="form-group d-flex">
                                <label style="width: 35%" for="telephoneModal" class="p-2">Téléphone</label>
                                <input style="width: 75%" type="tel" class="form-control" id="telephoneModal"
                                    name="telephoneModal" placeholder="06.24.24.24.24" pattern="[0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2}">
                            </div>

                            <div class="form-group d-flex">
                                <label style="width: 35%" for="photoModal" class="p-2">Photographie</label>
                                <input style="width: 75%" type="url" class="form-control" id="photoModal"
                                    name="photoModal" placeholder="lien url de l'image">
                            </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-dark" data-dismiss="modal">Annuler</button>
                        <input type="submit" class="btn btn-success" value="Ajouter">
                    </div>
                </div>
            </div>
        </div>
        <!-- FIN MODALE -->
        
	<%@include file="../../jsp/dependanceScript.jsp"%>
	
	</body>
	</html>