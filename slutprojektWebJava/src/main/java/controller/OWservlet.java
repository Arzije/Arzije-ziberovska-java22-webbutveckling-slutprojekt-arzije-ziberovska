package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GettheWeather;
import model.WeatherBean;

@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		
		WeatherBean wBean = new WeatherBean(cityStr, countryStr);

		GettheWeather.getWeather(wBean);
		request.setAttribute("wBean", wBean);

		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("accept")) {
				String oldValue = cookie.getValue();	
				String newValue = cityStr + "_" + countryStr;
				cookie.setValue(oldValue + "_" + newValue);
				response.addCookie(cookie);
			} 
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/showWeather.jsp");
		rd.forward(request, response);
		
	}

}
