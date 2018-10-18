package com.yartemp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class Parser {
	
	protected final String sourceURL = "http://yartemp.com/";
	protected String temperature;
	protected String temperatureChange;
	protected String pressure;
	protected String pressureChange;
	protected String light;
	protected String averageTemperature;
	
	public Parser() throws IOException {
		updateDataFromInternet();
	}
	
	String getTemperature(){
		return temperature;
	}
	
	String getTemperatureChange(){
		return temperatureChange;
	}
	
	String getPressure() {
		return pressure;
	}
	
	String getPressureChange() {
		return pressureChange;
	}
	
	String getLight() {
		return light;
	}
	
	String getAverageTemperature() {
		return averageTemperature;
	}
		
    protected Document getPage() throws IOException {
        Document page = Jsoup.parse(new URL(sourceURL), 3000);
        return page;
     }

	public void updateDataFromInternet() throws IOException {
		Document page = getPage();
		Element tableWeather = page.select("div[class=tempInfoDivInner]").first();

		String temp1 = tableWeather.select("span[id=spTemp1]").text();
		String temp2 = tableWeather.select("span[id=spTemp1a]").text();
		temperature = "������� �����������: " + temp1 + temp2 + "�C";

		String tempChange1 = tableWeather.select("span[id=spTemp2]").text();
		String tempChange2 = tableWeather.select("span[id=spTemp2a]").text();
		temperatureChange = "������� �����������: " + tempChange1 + tempChange2 + "�C/���";

		String pressure1 = tableWeather.select("span[id=spPressure]").text();
		pressure = "����������� ��������: " + pressure1 + " �� ��.��.";

		String pressurePerHour = tableWeather.select("span[id=spPressurePerHour]").text();
		pressureChange = "��������� ��������: " + pressurePerHour + " �� ��.��./���";

		String light1 = tableWeather.select("span[id=spLight]").text();
		light = "�����������: " + light1;

		String temperatureLast24Hours = tableWeather.select("span[id=spTemp4]").text();
		averageTemperature = "������� ����������� �� ��������� 24 ����: " + temperatureLast24Hours + "C";

	}
}


