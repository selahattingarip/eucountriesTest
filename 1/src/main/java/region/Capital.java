package region;

import static com.jayway.restassured.RestAssured.get;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.jayway.restassured.response.Response;
import com.sun.tools.xjc.Language;

import bsh.Console;
import io.restassured.RestAssured;

public class Capital {

	@Test
	public void ankaraRegion() throws JSONException
	{ 
		//make get request to fetch JSON data
		Response resp = get("https://restcountries.eu/rest/v2/capital/Ankara");
				
		//Fetching response in JSON
		JSONArray jsonResponse = new JSONArray(resp.asString());
				
		//Fetching value of region parameter
		String region = jsonResponse.getJSONObject(0).getString("region");
				
		//Check that region is Asia
		Assert.assertEquals(region, "Asia");
	}
	
	@Test
	public void ankaraBorders() throws JSONException
	{ 
		//make get request to fetch JSON data
		Response resp = get("https://restcountries.eu/rest/v2/capital/Ankara");
		
		//Fetching response in JSON
		JSONArray jsonResponse = new JSONArray(resp.asString());
		
		//Fetching value of border parameter
		JSONArray border = jsonResponse.getJSONObject(0).getJSONArray("borders");
		
		//Check array lengtf of Borders
		/*
		int uzunluk = border.length();
		Assert.assertEquals(8, uzunluk);
		*/
		Assert.assertEquals(8,border.length());
		
	}
	
}





