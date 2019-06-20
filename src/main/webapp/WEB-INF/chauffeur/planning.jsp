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
		<tbody>
			<tr>
				<th scope="row">00h00</th>
				<td id="0"></td>
			</tr>
			<tr>
				<th scope="row">01h00</th>
				<td id="1"></td>
			</tr>
			<tr>
				<th scope="row">02h00</th>
				<td id="2"></td>
			</tr>
			<tr>
				<th scope="row">03h00</th>
				<td id="3"></td>
			</tr>
			<tr>
				<th scope="row">04h00</th>
				<td id="4"></td>
			</tr>
			<tr>
				<th scope="row">05h00</th>
				<td id="5"></td>
			</tr>
			<tr>
				<th scope="row">06h00</th>
				<td id="6"></td>
			</tr>
			<tr>
				<th scope="row">07h00</th>
				<td id="7"></td>
			</tr>
			<tr>
				<th scope="row">08h00</th>
				<td id="8"></td>
			</tr>
			<tr>
				<th scope="row">09h00</th>
				<td id="9"></td>
			</tr>
			<tr>
				<th scope="row">10h00</th>
				<td id="10"></td>
			</tr>
			<tr>
				<th scope="row">11h00</th>
				<td id="11"></td>
			</tr>
			<tr>
				<th scope="row">12h00</th>
				<td id="12"></td>
			</tr>
			<tr>
				<th scope="row">13h00</th>
				<td id="13"></td>
			</tr>
			<tr>
				<th scope="row">14h00</th>
				<td id="14"></td>
			</tr>
			<tr>
				<th scope="row">15h00</th>
				<td id="15"></td>
			</tr>
			<tr>
				<th scope="row">16h00</th>
				<td id="16"></td>
			</tr>
			<tr>
				<th scope="row">17h00</th>
				<td id="17"></td>
			</tr>
			<tr>
				<th scope="row">18h00</th>
				<td id="18"></td>
			</tr>
			<tr>
				<th scope="row">19h00</th>
				<td id="19"></td>
			</tr>
			<tr>
				<th scope="row">20h00</th>
				<td id="20"></td>
			</tr>
			<tr>
				<th scope="row">21h00</th>
				<td id="21"></td>
			</tr>
			<tr>
				<th scope="row">22h00</th>
				<td id="22"></td>
			</tr>
			<tr>
				<th scope="row">23h00</th>
				<td id="23"></td>
			</tr>
		</tbody>
	</table>
</div>


<%-- CONTENU FIN HTML (FIN MAIN, FOOTER) --%>
<%@include file="../../jsp/layout_footer.jsp"%>
<%@include file="../../jsp/dependanceScript.jsp"%>

<script>

document.getElementById("precedent").addEventListener("click",()=>{
	$.ajax({
        url: "/gdt/controller/chauffeur/refreshPlanning?date="+document.getElementById("date").innerText+"&demande=precedent",
        dataType: "json",
        success: (result) => {
        	console.log(result);
        	result.forEach(resa => {
                console.log(resa.besoinChauffeur);
                console.log(resa.dateTimeDeDebut.date.day);
                console.log(resa.dateTimeDeDebut.time.hour);
            });
        	
        	
        }
    });
	});

document.getElementById("suivant").addEventListener("click",()=>console.log("suivant"));


</script>

</body>
</html>