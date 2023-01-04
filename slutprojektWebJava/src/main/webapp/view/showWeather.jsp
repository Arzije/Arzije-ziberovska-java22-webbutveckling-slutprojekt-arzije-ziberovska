<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.WeatherBean"%>
    <%@page import="model.GettheWeather"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
		
<section class="main"> 
	<section class="inputs">
		<div class="weather-search">
			<form id="helloWorld" action="OWservlet" method="get">
				<label style="color: black" for="city">City: </label>
				<input type="text" name="city" /><br /> 
				<label style="color: black" for="country">Country: </label>
				<input type="text" name="country" /><br /> 
				<input type="submit" value="go" />
			</form>
		</div>
	</section>
			
	<section class="display-weather">
		<% 
		 	WeatherBean wBean = (WeatherBean) request.getAttribute("wBean");
			out.print("<h3> The weather in " + wBean.getCityStr() + " is now a " + wBean.getCloudsStr()+ ".</h3>");
			out.print("<h3> It is " + wBean.getTemperatureStr() + " °C.</h3>");	 
			out.print("<h3> The date is " + wBean.getDate() + ".</h3>");	 
		%>
					
	</section>
		
		<h3>Previous searches:</h3>
	
	<section class="display-searches">
		<%
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("accept")) {
					String[] temp = cookie.getValue().split("_");
					for (String showSearches : temp){
						out.println("<a>"+ showSearches + "</a>");
					}
				}
			} 
		%>	
			
	</section>

</section>
<script src="main.js"></script> 
</body>
</html>