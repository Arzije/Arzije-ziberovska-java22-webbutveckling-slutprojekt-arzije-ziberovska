<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.WeatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather App</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<section class="main"> 
		<section class="inputs">
			<div class="weather-search">		
				<form action="OWservlet" method="get">
					<label style="color: black" for="city">City: </label> 
					<input type="text" name="city" /><br /> 
					<label style="color: black" for="country">Country: </label> 
					<input type="text" name="country" /><br /> 
					<input type="submit" value="GO" />
				</form>
			</div>
		</section>
	</section>	

	<div class="cookie-container">
		<p>We use cookies.....</p>
		<button class="button-accept">Okay</button> 
		<button class="button-reject">Not okay!</button>
	</div>	
<script src="main.js"></script>
</body>
</html>