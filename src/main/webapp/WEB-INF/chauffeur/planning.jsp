<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="fr.diginamic.model.Vehicule"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>
<%-- CONTENU DEBUT HTML (HEAD + HEADER ...) --%>
<%@include file="../../jsp/layout_header.jsp"%>

<%
	LocalDate date = (LocalDate) request.getAttribute("date");
	if (date == null) {
		date = LocalDate.now();
	}
%>
<div class="row mx-5">
	<h1>Planning</h1>
</div>

<div class="container">
	<div class="row justify-content-end mx-5 ">
		<button class="btn" id="precedent">
			<i class="fas fa-chevron-left"></i>
		</button>
		<h5 class="py-3 mb-0" id="date"><%=date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))%></h5>
		<button class="btn" id="suivant">
			<i class="fas fa-chevron-right"></i>
		</button>
	</div>
	<table class="table table-bordered table-sm">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Heure</th>
				<th scope="col">Reservation</th>
			</tr>
		</thead>
		<tbody class="bg-light">
			<tr>
				<th scope="row">00h00</th>
				<td class="bg-light" id="0"></td>
			</tr>
			<tr>
				<th scope="row">01h00</th>
				<td class="bg-light" id="1"></td>
			</tr>
			<tr>
				<th scope="row">02h00</th>
				<td class="bg-light" id="2"></td>
			</tr>
			<tr>
				<th scope="row">03h00</th>
				<td class="bg-light" id="3"></td>
			</tr>
			<tr>
				<th scope="row">04h00</th>
				<td class="bg-light" id="4"></td>
			</tr>
			<tr>
				<th scope="row">05h00</th>
				<td class="bg-light" id="5"></td>
			</tr>
			<tr>
				<th scope="row">06h00</th>
				<td class="bg-light" id="6"></td>
			</tr>
			<tr>
				<th scope="row">07h00</th>
				<td class="bg-light" id="7"></td>
			</tr>
			<tr>
				<th scope="row">08h00</th>
				<td class="bg-light" id="8"></td>
			</tr>
			<tr>
				<th scope="row">09h00</th>
				<td class="bg-light" id="9"></td>
			</tr>
			<tr>
				<th scope="row">10h00</th>
				<td class="bg-light" id="10"></td>
			</tr>
			<tr>
				<th scope="row">11h00</th>
				<td class="bg-light" id="11"></td>
			</tr>
			<tr>
				<th scope="row">12h00</th>
				<td class="bg-light" id="12"></td>
			</tr>
			<tr>
				<th scope="row">13h00</th>
				<td class="bg-light" id="13"></td>
			</tr>
			<tr>
				<th scope="row">14h00</th>
				<td class="bg-light" id="14"></td>
			</tr>
			<tr>
				<th scope="row">15h00</th>
				<td class="bg-light" id="15"></td>
			</tr>
			<tr>
				<th scope="row">16h00</th>
				<td class="bg-light" id="16"></td>
			</tr>
			<tr>
				<th scope="row">17h00</th>
				<td class="bg-light" id="17"></td>
			</tr>
			<tr>
				<th scope="row">18h00</th>
				<td class="bg-light" id="18"></td>
			</tr>
			<tr>
				<th scope="row">19h00</th>
				<td class="bg-light" id="19"></td>
			</tr>
			<tr>
				<th scope="row">20h00</th>
				<td class="bg-light" id="20"></td>
			</tr>
			<tr>
				<th scope="row">21h00</th>
				<td class="bg-light" id="21"></td>
			</tr>
			<tr>
				<th scope="row">22h00</th>
				<td class="bg-light" id="22"></td>
			</tr>
			<tr>
				<th scope="row">23h00</th>
				<td class="bg-light" id="23"></td>
			</tr>
		</tbody>
	</table>
</div>


<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp"%>
<%@include file="../../jsp/dependanceScript.jsp"%>

<script>

$( document ).ready(()=>{
	$.ajax({
        url: "/gdt/controller/chauffeur/refreshPlanning?date="+document.getElementById("date").innerText+"&demande=actuel",
        dataType: "json",
        success: (result) => {
        	for(let j=0 ;j<24;j++){
            	document.getElementById(j).className = "bg-light";
            }
        	majPlanning(result);
        	
        	
        }
    });
});

document.getElementById("precedent").addEventListener("click",()=>{
	$.ajax({
        url: "/gdt/controller/chauffeur/refreshPlanning?date="+document.getElementById("date").innerText+"&demande=precedent",
        dataType: "json",
        success: (result) => {
        	for(let j=0 ;j<24;j++){
            	document.getElementById(j).className = "bg-light";
            	document.getElementById(j).innerText = "";
            }
        	majDate(-1);
        	majPlanning(result);
   	
        }
    });
	});

document.getElementById("suivant").addEventListener("click",()=>{
	$.ajax({
        url: "/gdt/controller/chauffeur/refreshPlanning?date="+document.getElementById("date").innerText+"&demande=suivant",
        dataType: "json",
        success: (result) => {
        	for(let j=0 ;j<24;j++){
            	document.getElementById(j).className = "bg-light";
            	document.getElementById(j).innerText = "";
            	
            }
        	majDate(1);
        	majPlanning(result);
       	
        }
    });
	});



function majDate(valeurChangement) {
    let dateActuelle = document.getElementById("date").innerText;
            let elementDate = dateActuelle.split("/");
            let tmp = parseInt(elementDate[0]);
            let date = new Date(elementDate[2],elementDate[1]-1,tmp+valeurChangement);         
            let jour = date.getDate();
            let mois = date.getMonth()+1;
            let annee = date.getFullYear();
            if (jour<10) {
                jour = "0"+jour;
            }
            if(mois<10){
                mois = "0"+mois;
            }
            const chaineDate = jour+"/"+mois+"/"+annee;
            document.getElementById("date").innerText=chaineDate;
}

function majPlanning(listeResa) {
	console.log(listeResa);
    listeResa.forEach((resa)=>{
        const debut = resa.dateTimeDeDebut.time.hour;
        const fin = resa.dateTimeDeFin.time.hour;
        let description ='<h5 class ="text-light"> début :'+debut+' h ';
        description += resa.dateTimeDeDebut.time.minute+" min |";
        description += " fin : "+fin+" h ";
        description += resa.dateTimeDeFin.time.minute+" min </h5>";
        document.getElementById(debut).innerHTML = description;
        
        if(resa.besoinChauffeur == 1){
        	
        	let bouton = '<button id="accept" data-id="'+resa.id+'" type="submit" class="float-right btn btn-light">Accepter la demande</button>';
        	document.getElementById(debut).innerHTML += bouton;
        	ajouterEventListener();
        }
        for (let i = debut; i <= fin; i++) {
            document.getElementById(i).className = "bg-primary";
            
        }
    })
}
function ajouterEventListener(){
document.getElementById("accept").addEventListener("click",(event)=>{
	const id = event.target.getAttribute("data-id");
	console.log(event.target.getAttribute("data-id"));
	
	document.location.href = '/gdt/controller/chauffeur/accepterReservation?id='+id;
	
	});
	}
</script>

</body>
</html>