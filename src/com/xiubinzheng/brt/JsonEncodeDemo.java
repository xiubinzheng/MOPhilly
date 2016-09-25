package com.xiubinzheng.brt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonEncodeDemo {
	/**NOTE: there is an error within this method*/
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);

			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {
		/*there is an error within the json readall method*/
		String address = "2140 Market St";
		String formattedAddress = address.replace(" ", "%20");
		
		String propertyAddressSearchURL = "http://api.phila.gov/opa/v1.1/address/" + formattedAddress + "/?format=json";
		String workingLink = "http://api.phila.gov/opa/v1.1/nearby/-75.17577099716434/39.94975933671865/400?format=json";
		String serviceList311URL = "http://www.publicstuff.com/api/open311/services/4086.[format]?jurisdiction_id=philadelphia-pa";
		String obitreeURL ="http://obittree.com/obituary/ajax/record-request.php?pageNum=30&query%5BFirstName%5D=&query%5BLastName%5D=&query%5BCountry%5D=US&query%5BProvince%5D=PA&query%5BCity%5D=philadelphia&query%5BDateFrom%5D=2016-0-1&query%5BDateTo%5D=2016-8-13&recordDate=";
	
		
		
		System.out.println(propertyAddressSearchURL);
		JSONObject propertyAddressSearchJSON = readJsonFromUrl(propertyAddressSearchURL);
		System.out.println(propertyAddressSearchJSON.toString());
		System.out.println(" above is jason ");

		JSONArray currentLocationJSONArray = (JSONArray) propertyAddressSearchJSON.getJSONObject("data")
				.getJSONArray("properties");


		String Longitude = String.valueOf(currentLocationJSONArray.getJSONObject(0).getJSONObject("geometry").get("x"));
		String latitute = String.valueOf(currentLocationJSONArray.getJSONObject(0).getJSONObject("geometry").get("y"));
		System.out.println(Longitude);
		System.out.println(latitute);
		
		String geoSearchURL = "http://api.phila.gov/opa/v1.1/nearby/" + Longitude + "/" + latitute + "/400?format=json";
		System.out.println(geoSearchURL);                         
		
		JSONObject geoSearchJSON = readJsonFromUrl(geoSearchURL);
		//http://api.phila.gov/opa/v1.1/nearby/-75.176600095803238/39.953683166183325/400?format=json
		JSONArray geoSearchJSONArray = (JSONArray) geoSearchJSON.getJSONObject("data").getJSONArray("properties");
		System.out.println("count: "+geoSearchJSONArray.length());
		for (int i = 0; i < geoSearchJSONArray.length(); i++) {

			String desc = geoSearchJSONArray.getJSONObject(i).getJSONObject("characteristics").getString("description");
			
			if (desc.contains("VACANT LAND")) {
				System.out.println("geoObject: "+geoSearchJSONArray.getJSONObject(i));
				System.out.println(desc);
			}

		}

	}

	private static void plotLocation(String string) {
		// TODO Auto-generated method stub

	}

	private static void getCurrentGeometry() {
		// TODO Auto-generated method stub

	}

}