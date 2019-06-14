<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>"/chauffeur/occupation"</h1>
    
    <script type="text/javascript">
    function afficherNouveauGraphique() {
		dateDeDebut = new Date();
		dateDeFin = new Date();

		dateDeDebut="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
		dateDeFin="" //selection de la variable via document.forms[0].selectedGrad.value par exemple, je sais pas trop en fait
		
		// Conversion des variables sous la forme ddMMYYYY
		// pour correspondre aux critères de doGet du servlet AfficherGraphiqueChauffeur
		dateDeDebut=factoriser(dateDeDebut);
		dateDeFin=factoriser(dateDeFin);
			
		document.location.href = "http://localhost:8080/gestion-transports/chauffeur/occupation?utilisateur="
				+ utilisateur + "&dateDeDebut=" + dateDeDebut + "&dateDeFin=" + dateDeFin;

	}
</script>
</body>
</html>