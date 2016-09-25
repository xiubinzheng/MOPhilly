package com.xiubinzheng.brt;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BrtCrossReference {

	public static void main(String[] args) throws IOException, JSONException {

		String obittreeUrl = "http://www.obittree.com/obituary/ajax/record-request.php?pageNum=1&query%5BFirstName%5D=&query%5BLastName%5D=&query%5BCountry%5D=US&query%5BProvince%5D=PA&query%5BCity%5D=philadelphia&query%5BDateFrom%5D=2016-7-4&query%5BDateTo%5D=2016-8-11&recordDate=";

		JSONObject obittreeJSONObject = new JSONObject(
				IOUtils.toString(new URL(obittreeUrl), Charset.forName("UTF-8")));
		JSONArray obittreeJSONArray = obittreeJSONObject.getJSONArray("data");
		System.out.println("obittreeJSONObject: " + obittreeJSONObject);

		for (int i = 0; i < obittreeJSONArray.length(); i++) {
			System.out.println("obittreeJSONArray: " + obittreeJSONArray.getJSONObject(i));
			String currentName = obittreeJSONArray.getJSONObject(i).get("name").toString();

			System.out.println(currentName);
			//System.out.println(currentName.replaceAll("[^A-Za-z0-9 ]", "").trim().replace("  ", "%20"));
			String formattedCurrentName = StringUtils.replaceEach(currentName.replaceAll("[^A-Za-z0-9 ]", "").trim(), new String[]{"   ","  "," "}, new String[]{"%20","%20","%20"});
			String propertyUrl = "https://api.phila.gov/opa/v1.1/owner/"
					+ formattedCurrentName + "?format=json";
			System.out.println(propertyUrl);
			JSONObject PropertyJSONObject = new JSONObject(
					IOUtils.toString(new URL(propertyUrl), Charset.forName("UTF-8")));
			if (PropertyJSONObject.getJSONObject("data").getJSONArray("properties").length() > 0) {

				System.out.println("not null");
				
				  System.out.println(PropertyJSONObject.getJSONObject("data").
				  getJSONArray("properties").getJSONObject(0)
				  .getJSONObject("ownership") + " "+PropertyJSONObject.getJSONObject("data").
				  getJSONArray("properties").getJSONObject(0).get("full_address"));
				 
			}
		}

	}
}
