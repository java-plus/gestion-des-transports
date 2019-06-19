<%@page import="fr.diginamic.model.Vehicule"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>
<style>
.carousel-caption {
    position: relative;
    left: 0;
    top: 0;
}
</style>

<a href="/controller/collaborateur/reservations/">
        << Retour à la liste</a> <h1>Réserver un véhicule</h1>
            <div class="m-3 mt-4">

                <div id="accordion">
                    <div class="car ">
                        <a href="/gdt/collaborateur/annonces/creer">
                        <div class="card-header bg-dark text-light" id="headingOne">
                            <h5 class="mb-0">
                                <button class="btn btn-link collapsed text-light" data-toggle="collapse"
                                    data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                    Covoiturage
                                </button>
                            </h5>
                        </div>
						</a>
                        <div id="collapseOne" class="collapse " aria-labelledby="headingOne"
                            data-parent="#accordion">
                            <div class="card-body">
                            </div>
                        </div>
                    </div>
                    <div class="card ">
                        <div class="card-header bg-dark " id="headingTwo">
                            <h5 class="mb-0">
                                <button class="btn btn-link text-light show" data-toggle="collapse"
                                    data-target="#collapseTwo " aria-expanded="true" aria-controls="collapseTwo">
                                    Véhicule de société
                                </button>
                            </h5>
                        </div>
                        <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordion">
                            <div class="card-body container ">
                                <form action="/gdt/controller/collaborateur/reserverVehiculeSociete/" method="POST" id="form">
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <label>Date/heure de réservation:</label>
                                        </div>
                                        <div class="col-lg-2">
                                            <input type="date" class="form-control-sm" name="datedepart"
                                                id="dateReservationVehiculeSociete" required>
                                        </div>
                                        <div class="col-lg-2">
                                            <select name="heuredepart" class="form-control-sm"
                                                id="heureReservationVehiculeSociete" required>
                                                <option></option>
                                                <option value="00">00</option>
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
                                            </select> <label>h</label>
                                            <select name="minutedepart" class="form-control-sm"
                                                id="minuteReservationVehiculeSociete" required>
                                                <option></option>
                                                <option value="00">00</option>
                                                <option value="10">10</option>
                                                <option value="20">20</option>
                                                <option value="30">30</option>
                                                <option value="40">40</option>
                                                <option value="50">50</option>
                                            </select>
                                        </div>
                                        <div class="col-lg-2">
                                            <input type="checkbox" class="form-check-input " name="chauffeur" id="checkboxChauffeur" value="1">
                                            <label class="form-check-label" for="checkboxChauffeur">Avec chauffeur</label>
                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="col-lg-2">
                                            <label>Date/heure de retour:</label>
                                        </div>
                                        <div class="col-lg-2">
                                            <input type="date" class="form-control-sm" name="datearrive"
                                                id="dateRetourReservationVehiculeSociete" required>
                                        </div>
                                        <div class="col-lg-2">
                                            <select name="heurearrive" class="form-control-sm"
                                                id="heureRetourReservationVehiculeSociete" required>
                                                <option></option>
                                                <option value="00">00</option>
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
                                            </select> <label>h</label>
                                            <select name="minutearrive" class="form-control-sm"
                                                id="minuteRetourReservationVehiculeSociete" required>
                                                <option></option>
                                                <option value="00">00</option>
                                                <option value="10">10</option>
                                                <option value="20">20</option>
                                                <option value="30">30</option>
                                                <option value="40">40</option>
                                                <option value="50">50</option>
                                            </select>
                                        </div>

                                    </div>
									<% List<Vehicule> listeVehicule=(List<Vehicule>)request.getAttribute("listeVehicule"); %>
                                    <div class="row mt-5 d-flex justify-content-center">
                                        <div class="col-6 ">
                                            <div class="bd-example">
                                                <div id="carouselExampleCaptions" class="carousel slide"
                                                    data-interval="false">
                                                    <ol class="carousel-indicators">
                                                        <li data-target="#carouselExampleCaptions"
                                                            data-id="<%=listeVehicule.get(0).getId() %>" class="active"></li>
                                                        <% for(int i=1;i<listeVehicule.size();i++){ %>
                                                        <li data-target="#carouselExampleCaptions"
                                                            data-id="<%=listeVehicule.get(i).getId() %>"></li>
                                                            <%} %>               
                                                    </ol>
                                                    <div class="carousel-inner">
                                                        <div class="carousel-item active">
                                                            <img src="<%=listeVehicule.get(0).getPhoto() %>"
                                                                class="d-block w-100" alt="">
                                                            <div
                                                                class="carousel-caption d-none d-block bg-dark mb-4 py-0">
                                                                <p class="m-0"><%=listeVehicule.get(0).getImmatriculation() %></p>
                                                                <p class="m-0"><%=listeVehicule.get(0).getMarque() %> - <%=listeVehicule.get(0).getModele() %></p>
                                                                <p class="pb-2"><%=listeVehicule.get(0).getCategorie() %></p>
                                                            </div>
                                                        </div>
                                                        <%for(int i=1;i<listeVehicule.size();i++){ %>
                                                        <div class="carousel-item">
                                                            <img src="<%=listeVehicule.get(i).getPhoto() %>"
                                                                class="d-block w-100" alt="">
                                                            <div
                                                                class="carousel-caption d-none d-block bg-dark mb-4 py-0">
                                                                <p class="m-0"><%=listeVehicule.get(i).getImmatriculation() %></p>
                                                                <p class="m-0"><%=listeVehicule.get(i).getMarque() %> - <%=listeVehicule.get(i).getModele()%></p>
                                                                <p class="pb-2"><%=listeVehicule.get(i).getCategorie() %></p>
                                                            </div>
                                                        </div>
                                                        <%} %>
                                                      
                                                    </div>
                                                    <a class="carousel-control-prev" href="#carouselExampleCaptions"
                                                        role="button" data-slide="prev">
                                                        <span class="carousel-control-prev-icon"
                                                            aria-hidden="true"></span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                    <a class="carousel-control-next" href="#carouselExampleCaptions"
                                                        role="button" data-slide="next">
                                                        <span class="carousel-control-next-icon"
                                                            aria-hidden="true"></span>
                                                        <span class="sr-only">Next</span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-1 container">
                                        <input type="submit" class="btn btn-success" value="Reserver">
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                    
                </div>


            </div>
            
            
<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp"%>
<%@include file="../../jsp/dependanceScript.jsp"%>


            <script>
                $("#form").submit(function (eventObj) {
                    $("<input />").attr("type", "hidden")
                        .attr("name", "id")
                        .attr("value", $('#carouselExampleCaptions .carousel-indicators li.active').data('id'))
                        .appendTo("#form");
                    return true;
                });
            </script>
            
</body>
</html>