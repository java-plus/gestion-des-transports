<%@page import="fr.diginamic.model.Vehicule"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

<h1>Vehicules</h1>
<div class="m-3 mt-4">
	<div>
		<div class="row ml-3">
			<h5>Filtre</h5>
		</div>
		<div class="row ml-5">
			<div class="col-lg-2">
				<p class="text-left">Immatriculation:</p>
			</div>
			<div class="col-lg-3">
				<input type="text" class="form-control" id="immatriculation"
					name="immatriculation" placeholder="Entrez une immatriculation">
			</div>
		</div>
		<div class="row form-group ml-5">
			<div class="col-lg-2">
				<p class="text-left">Marque:</p>
			</div>
			<div class="col-lg-3">
				<input type="text" class="form-control" id="marque" name="marque"
					placeholder="Entrez une marque">
			</div>
		</div>
		<div class="row flex-row-reverse mr-5 ">
			<input type="button" id="ajouterVehicule" class="btn btn-dark" data-toggle="modal" data-target="#exampleModal"
				value="Ajouter un véhicule">
		</div>
	</div>

	<div class="mx-5 mt-5 text-center" id="vehicules">
		<div class="row">
			<%
				List<Vehicule> listeVehicule = (List<Vehicule>) request.getAttribute("listeDesVehicules");
				for (Vehicule vehicule : listeVehicule) {
			%>
			<a class="col-md-3 text-dark btn urlDetails" data-url="/gdt/controller/administrateur/vehicules/vehicule/<%= vehicule.getImmatriculation() %>" href="/gdt/controller/administrateur/vehicules/vehicule/<%= vehicule.getImmatriculation() %>">
				<div>
					<img src=<%=vehicule.getPhoto()%> alt="" class="img-thumbnail">
					<p>
						<%=vehicule.getImmatriculation()%>
						<br>
						<%=vehicule.getMarque()%>
						-
						<%=vehicule.getModele()%>
						<br>
						<%=vehicule.getCategorie()%>
					</p>
				</div>
			</a>
			<%
				}
			%>


		</div>
	</div>
	
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ajout d’un véhicule</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form method="POST" action="/gdt/controller/administrateur/vehicules/">
        <div class="form-group">
            <label for="immatriculationModal">Immatriculation:</label>
            <input type="text" class="form-control" id="immatriculationModal" name="immatriculationModal" placeholder="immatriculation (xx-123-xx)" pattern="[a-zA-Z]{2}-[0-9]{3}-[a-zA-Z]{2}" required>
        </div>
        <div class="form-group">
            <label for="marqueModal">Marque:</label>
            <input type="text" class="form-control" id="marqueModal" name="marqueModal" placeholder="marque" required>
        </div>
        <div class="form-group">
            <label for="modeleModal">Modele:</label>
            <input type="text" class="form-control" id="modeleModal" name="modeleModal" placeholder="modèle" required>
        </div>
        <div class="form-group">
            <label for="categorieModal">Categorie:</label>
            <select class="form-control" id="categorieModal" name="categorieModal" required>
                <option value="Micro-urbaines">Micro-urbaines</option>
                <option value="Mini-citadines">Mini-citadines</option>
                <option value="Citadines polyvalentes">Citadines polyvalentes</option>
                <option value="Compactes">Compactes</option>
                <option value="Berlines Taille S">Berlines Taille S</option>
                <option value="Berlines Taille M">Berlines Taille M</option>
                <option value="Berlines Taille L">Berlines Taille L</option>
                <option value="SUV, Tout-terrains et Pick-up">SUV, Tout-terrains et Pick-up</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="nbPlacesModal">Nombre de places:</label>
            <input type="number" class="form-control" id="nbPlacesModal" name="nbPlacesModal" placeholder="nombre de place">
        </div>

        <div class="form-group">
            <label for="photoModal">Photo:</label>
            <input type="text" class="form-control" id="photoModal" name="photoModal" placeholder="url">
        </div>
    
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">Fermer</button>
        <input type="submit" class="btn btn-success" value="Enregistrer" >
      </div>
      </form>
    </div>
  </div>
</div>

	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>

	<script>
	$("#immatriculation").change(function(){
		    $.ajax({
		        url: "/gdt/controller/refreshImmatriculation?immatriculation="+document.getElementById('immatriculation').value,
		        dataType: "json",
		        success: (result) => {        	
		        	let html = '<div class="mx-5 mt-5 text-center" id="vehicules">';
		        	html+= '<div class="row">'
		        	result.forEach((vehicule)=>
		        	{
		        		html+= '<a class="col-md-3 text-dark btn urlDetails" href="/gdt/controller/administrateur/vehicules/vehicule/'+ vehicule.immatriculation + '">';
		        		html+='<div>';
	                    html+='<div>';
	                        html+='<img  src="'+vehicule.photo;
	                        html+='"alt="photo de voiture" class="img-thumbnail">';
	                        html+='<p>'+vehicule.immatriculation+'<br>';
	                        html+=vehicule.marque+' - '+vehicule.modele+'<br>';
	                        html+= vehicule.categorie;
	                        html+='</p></div></div></a>';	
		        	});

		            $("#vehicules").html(html);
		        }
		    });
	
	})
	</script>
	
	<script>
	$("#marque").change(function(){
		    $.ajax({
		        url: "/gdt/controller/refreshMarque?marque="+document.getElementById('marque').value,
		        dataType: "json",
		        success: (result) => {
		        	let html = '<div class="mx-5 mt-5 text-center" id="vehicules">';
		        	html+= '<div class="row">'
		        	console.log(result);
		        	result.forEach((vehicule)=>
		        	{
		        		html+= '<a class="col-md-3 text-dark btn urlDetails" href="/gdt/controller/administrateur/vehicules/vehicule/'+ vehicule.immatriculation + '">';
		        		html+='<div>';
	                    html+='<div>';
	                        html+='<img  src="'+vehicule.photo;
	                        html+='"alt="" class="img-thumbnail">';
	                        html+='<p>'+vehicule.immatriculation+'<br>';
	                        html+=vehicule.marque+' - '+vehicule.modele+'<br>';
	                        html+= vehicule.categorie;
	                        html+='</p></div></div>';	
		        	});

		            $("#vehicules").html(html);
		        }
		    });
	
	})
	</script>

	<script>
    function ajouterNouveauVehicule() {
		

    	immatriculation="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    		marque="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    			modele="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    				categorie="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    					nombreDePlaces="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    						photo="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
		
		
			
		document.location.href = "http://localhost:8080/gestion-transports/admin/vehicules/ajout?immatriculation="
				+ immatriculation + "&marque=" + marque + "&modele=" + modele+ "&categorie="+ categorie+ "&nombreDePlaces=" + nombreDePlaces+ "&photo=" + photo;

	}
    
function modifierStatutVehicule() {
		

    	immatriculation="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    		marque="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    			modele="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    				categorie="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    					nombreDePlaces="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
    						photo="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
		
		
			
		document.location.href = "http://localhost:8080/gestion-transports/admin/vehicules/ajout?immatriculation="
				+ immatriculation + "&marque=" + marque + "&modele=" + modele+ "&categorie="+ categorie+ "&nombreDePlaces=" + nombreDePlaces+ "&photo=" + photo;

	}
    </script>
	</body>
	</html>
