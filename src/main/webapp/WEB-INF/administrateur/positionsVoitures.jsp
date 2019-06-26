<%@page import="fr.diginamic.model.Vehicule"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf8"%>


<!DOCTYPE html>
<html>
  <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 50%;
        width: 50%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>
    var geocoder;
    var map;
    var address = "new york city";

    function initMap() {
        geocoder = new google.maps.Geocoder();

        var uluru = { lat: -25.363, lng: 131.044 };
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 4,
            center: uluru
        });
        var marker = new google.maps.Marker({
            position: {lat: 47, lng: 5},
            map: map
        });
        
        <%
		List<Vehicule> listeVehicule = (List<Vehicule>) request.getAttribute("listeDesVehicules");
		for (Vehicule vehicule : listeVehicule) {
	%>
	codeAddress("<%=vehicule.getPosition()%>");
	
	
	<%
		}
	%>
        
        
        codeAddress(address);
        codeAddress("quimper");
    }

    function codeAddress(address) {

        geocoder.geocode({ 'address': address }, function (results, status) {
            console.log(results);
            var latLng = { lat: results[0].geometry.location.lat(), lng: results[0].geometry.location.lng() };
            console.log(latLng);
            if (status == 'OK') {
                var marker = new google.maps.Marker({
                    position: latLng,
                    map: map
                });
                console.log(map);
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    }
      
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBt-XbijUXTWCsqeOhOW-TQDOoRTmbZcdw&callback=initMap"
    async defer></script>
  </body>
</html>