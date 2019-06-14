<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
</head>
<body>
	<h1>"/administrateur/vehicules"</h1>


	<script type="text/javascript">

    <!--/ methode redirigeant vers la servlet AjouterVehicule.java via une url de la forme 
    /gestion-transports/admin/vehicules/ajout
    ?immatriculation=AD123AED
    &marque=ford
    &modele=focus
    &categorie=5e
    &nombreDePlaces=42
    &photo=url
    		/-->
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