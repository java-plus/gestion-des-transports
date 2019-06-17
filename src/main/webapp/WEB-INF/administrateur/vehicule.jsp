<%@ page language="java" pageEncoding="utf8" import=""%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp" %>

<h1>Vehicules</h1>
<div class="m-3 mt-4">
    <div>
            <div class="row ml-3">
                <h5>Filtre</h5>
            </div>
            <div class="row ml-5">
                <div class="col-lg-1">
                    <p class="text-left">Immatriculation:</p>
                </div>
                <div class="col-lg-2">
                    <input type="text" class="form-control" name="immatriculation"
                        placeholder="Entrez une immatriculation">
                </div>
            </div>
            <div class="row form-group ml-5">
                <div class="col-lg-1">
                    <p class="text-left">Marque:</p>
                </div>
                <div class="col-lg-2">
                    <input type="text" class="form-control" name="marque" placeholder="Entrez une marque">
                </div>
            </div>
            <div class="row flex-row-reverse mr-5 ">
                <input type="button" id="ajouterVehicule" class="btn btn-dark "
                    value="Ajouter un véhicule">
            </div>
        </div>

        <div class="mx-5 mt-5 text-center">
            <div class="row">
                <div class="col-sm-3">
                    <div>
                        <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                        <p> AB-123-CD <br>
                            marque - modele <br>
                            categorie
                        </p>
                    </div>
                </div>
                <div class="col-sm-3"><div>
                        <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                        <p> AB-123-CD <br>
                            marque - modele <br>
                            categorie
                        </p>
                    </div>
                </div>
                <div class="col-sm-3"><div>
                        <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                        <p> AB-123-CD <br>
                            marque - modele <br>
                            categorie
                        </p>
                    </div>
                </div>
                <div class="col-sm-3"><div>
                        <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                        <p> AB-123-CD <br>
                            marque - modele <br>
                            categorie
                        </p>
                    </div>
                </div>
            </div>

            <div class="row">
                    <div class="col-3 text-center">
                        <div>
                            <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                            <p> AB-123-CD <br>
                                marque - modele <br>
                                categorie
                            </p>
                        </div>
                    </div>
                    <div class="col-3"><div>
                            <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                            <p> AB-123-CD <br>
                                marque - modele <br>
                                categorie
                            </p>
                        </div>
                    </div>
                    <div class="col-3"><div>
                            <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                            <p> AB-123-CD <br>
                                marque - modele <br>
                                categorie
                            </p>
                        </div>
                    </div>
                    <div class="col-3"><div>
                            <img  src="https://www.novethic.fr/fileadmin/voiture-electrique-volkswagen.jpg" alt="" class="img-thumbnail">
                            <p> AB-123-CD <br>
                                marque - modele <br>
                                categorie
                            </p>
                        </div>
                    </div>
                </div>

        </div>
</div>

<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp" %>