package model;

public class WeatherBean {
	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
	private String temperatureStr;
	
	private String date;	

	public WeatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;
	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}
	
	public void setCloudsStr(String cloudsStr) {
	this.cloudsStr = cloudsStr;
	}

	public String getTemperatureStr() {
	return temperatureStr;
	}

	public void setTemperatureStr(String temperatureStr) {
		this.temperatureStr = temperatureStr;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
