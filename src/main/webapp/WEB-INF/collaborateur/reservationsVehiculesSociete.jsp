<%@page import="fr.diginamic.model.Vehicule"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>


<a href="/controller/collaborateur/reservations/">
        << Retour à la liste</a> <h1>Réserver un véhicule</h1>
            <div class="m-3 mt-4">

                <div id="accordion">
                    <div class="car ">
                        <div class="card-header bg-dark text-light" id="headingOne">
                            <h5 class="mb-0">
                                <button class="btn btn-link text-light" data-toggle="collapse" data-target="#collapseOne"
                                    aria-expanded="true" aria-controls="collapseOne">
                                    Covoiturage
                                </button>
                            </h5>
                        </div>

                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                            data-parent="#accordion">
                            <div class="card-body">
                            </div>
                        </div>
                    </div>
                    <div class="card ">
                        <div class="card-header bg-dark " id="headingTwo">
                            <h5 class="mb-0">
                                <button class="btn btn-link collapsed text-light" data-toggle="collapse" data-target="#collapseTwo"
                                    aria-expanded="false" aria-controls="collapseTwo">
                                    Véhicule de société
                                </button>
                            </h5>
                        </div>
                        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                            <div class="card-body container ">
                                <form action="#" method="POST" >
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <label>Date/heure de réservation:</label>
                                        </div>
                                        <div class="col-lg-2">
                                            <input type="date" class="form-control-sm" name="date"
                                                id="dateReservationVehiculeSociete" required>
                                        </div>
                                        <div class="col-lg-2">
                                            <select name="heure" class="form-control-sm"
                                                id="heureReservationVehiculeSociete" required>
                                                <option value="0">00</option>
                                                <option value="1">01</option>
                                                <option value="2">02</option>
                                                <option value="3">03</option>
                                                <option value="4">04</option>
                                                <option value="5">05</option>
                                                <option value="6">06</option>
                                                <option value="7">07</option>
                                                <option value="8">08</option>
                                                <option value="9">09</option>
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
                                            <select name="minute" class="form-control-sm"
                                                id="minuteReservationVehiculeSociete" required>
                                                <option value="0">00</option>
                                                <option value="10">10</option>
                                                <option value="20">20</option>
                                                <option value="30">30</option>
                                                <option value="40">40</option>
                                                <option value="50">50</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="col-lg-2">
                                            <label>Date/heure de retour:</label>
                                        </div>
                                        <div class="col-lg-2">
                                            <input type="date" class="form-control-sm" name="date"
                                                id="dateRetourReservationVehiculeSociete" required>
                                        </div>
                                        <div class="col-lg-2">
                                            <select name="heure" class="form-control-sm"
                                                id="heureRetourReservationVehiculeSociete" required>
                                                <option value="0">00</option>
                                                <option value="1">01</option>
                                                <option value="2">02</option>
                                                <option value="3">03</option>
                                                <option value="4">04</option>
                                                <option value="5">05</option>
                                                <option value="6">06</option>
                                                <option value="7">07</option>
                                                <option value="8">08</option>
                                                <option value="9">09</option>
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
                                            <select name="minute" class="form-control-sm"
                                                id="minuteRetourReservationVehiculeSociete" required>
                                                <option value="0">00</option>
                                                <option value="10">10</option>
                                                <option value="20">20</option>
                                                <option value="30">30</option>
                                                <option value="40">40</option>
                                                <option value="50">50</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="row mt-5 d-flex justify-content-center">
                                        <div class="col-6 ">
                                            <div id="carouselExampleIndicators" class="carousel slide" data-interval="false"
                                                data-ride="carousel">
                                                <ol class="carousel-indicators">
                                                    <li data-target="#carouselExampleIndicators" data-slide-to="0"
                                                        class="active"></li>
                                                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                                </ol>
                                                <div class="carousel-inner">
                                                    <div class="carousel-item active">
                                                        <img class="d-block w-100"
                                                            src="https://images.caradisiac.com/images/3/9/3/6/163936/S0-essai-video-bmw-serie-6-gt-le-revanche-535612.jpg"
                                                            alt="First slide">
                                                            <div class="carousel-caption d-none d-md-block">
                                                                    <h5>test</h5>
                                                                    <p>test</p>
                                                                  </div>
                                                    </div>
                                                    <div class="carousel-item">
                                                        <img class="d-block w-100"
                                                            src="https://images.caradisiac.com/images/3/9/3/6/163936/S0-essai-video-bmw-serie-6-gt-le-revanche-535612.jpg"
                                                            alt="Second slide">
                                                            <div class="carousel-caption d-none d-md-block">
                                                                    <h5>test</h5>
                                                                    <p>test</p>
                                                                  </div>
                                                    </div>
                                                    <div class="carousel-item">
                                                        <img class="d-block w-100"
                                                            src="https://images.caradisiac.com/images/3/9/3/6/163936/S0-essai-video-bmw-serie-6-gt-le-revanche-535612.jpg"
                                                            alt="Third slide">
                                                            <div class="carousel-caption d-none d-md-block bg-dark">
                                                                    <h5>test</h5>
                                                                    <p>test</p>
                                                                  </div>
                                                    </div>
                                                </div>
                                                <a class="carousel-control-prev" href="#carouselExampleIndicators"
                                                    role="button" data-slide="prev">
                                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                    <span class="sr-only">Previous</span>
                                                </a>
                                                <a class="carousel-control-next" href="#carouselExampleIndicators"
                                                    role="button" data-slide="next">
                                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                    <span class="sr-only">Next</span>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                    <div class="card ">
                        <div class="card-header bg-dark" id="headingThree">
                            <h5 class="mb-0">
                                <button class="btn btn-link collapsed text-light" data-toggle="collapse"
                                    data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    Véhicule avec chauffeur privé
                                </button>
                            </h5>
                        </div>
                        <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                            data-parent="#accordion">
                            <div class="card-body">
                            </div>
                        </div>
                    </div>
                </div>


            </div>



<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp"%>
<%@include file="../../jsp/dependanceScript.jsp"%>

</body>
</html>