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
			<input type="button" id="ajouterVehicule" class="btn btn-dark "
				value="Ajouter un véhicule">
		</div>
	</div>

	<div class="mx-5 mt-5 text-center" id="vehicules">
		<div class="row">
			<%
				List<Vehicule> listeVehicule = (List<Vehicule>) request.getAttribute("listeDesVehicules");
				for (Vehicule vehicule : listeVehicule) {
			%>
			<div class="col-md-3">
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
			</div>
			<%
				}
			%>


		</div>
	</div>

	<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
	<%@include file="../../jsp/layout_footer.jsp"%>
	<%@include file="../../jsp/dependanceScript.jsp"%>


	<!--/ methode redirigeant vers la servlet AjouterVehicule.java via une url de la forme 
    /gestion-transports/admin/vehicules/ajout
    ?immatriculation=AD123AED
    &marque=ford
    &modele=focus
    &categorie=5e
    &nombreDePlaces=42
    &photo=url
    		/-->
	<script>
	$("#immatriculation").change(function(){
		    $.ajax({
		        url: "/gdt/controllers/refreshImmatriculation?immatriculation="+document.getElementById('immatriculation').value,
		        dataType: "json",
		        success: (result) => {
		        	let html = '<div class="mx-5 mt-5 text-center" id="vehicules">';
		        	html+= '<div class="row">'
		        	console.log(result);
		        	result.forEach((vehicule)=>
		        	{
		        		html +='<div class="col-md-3">';
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
	$("#marque").change(function(){
		    $.ajax({
		        url: "/gdt/controllers/refreshMarque?marque="+document.getElementById('marque').value,
		        dataType: "json",
		        success: (result) => {
		        	let html = '<div class="mx-5 mt-5 text-center" id="vehicules">';
		        	html+= '<div class="row">'
		        	console.log(result);
		        	result.forEach((vehicule)=>
		        	{
		        		html +='<div class="col-md-3">';
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