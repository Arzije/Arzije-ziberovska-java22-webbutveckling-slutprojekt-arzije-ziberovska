package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GettheWeather {
	
	public static void getWeather(WeatherBean wBean) throws IOException {
		String API_KEY = "785bb11c17b230ef015b1fd008762e2a";
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&units=metric&APPID=" + API_KEY + "&mode=xml";

		URL line_api_url = new URL(URLtoSend);

		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		String inputLine;

		String ApiResponse = "";

		while ((inputLine = in.readLine()) != null) {

			ApiResponse += inputLine;
		}
		in.close();
	
		Document doc = convertStringToXMLDocument(ApiResponse);

		NodeList firstnodeList = doc.getElementsByTagName("clouds");

		for (int temp = 0; temp < firstnodeList.getLength(); temp++) {
			Node node = firstnodeList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;
				String XMLclouds = eElement.getAttribute("name");
				wBean.setCloudsStr(XMLclouds);
			}
		}
		
		NodeList secondNodeList = doc.getElementsByTagName("temperature");
		
		for (int temp = 0; temp < secondNodeList.getLength(); temp++) {
			Node node = secondNodeList.item(temp);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String XMLtemperature = eElement.getAttribute("value");
				wBean.setTemperatureStr(XMLtemperature);
			}
		}
		
		NodeList thirdNodeList = doc.getElementsByTagName("lastupdate");
		
		for (int temp = 0; temp <thirdNodeList.getLength(); temp++) {
			Node node = thirdNodeList.item(temp);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String XMLdate = eElement.getAttribute("value");
				wBean.setDate(XMLdate);
			}
		}	
	}

	private static Document convertStringToXMLDocument(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
