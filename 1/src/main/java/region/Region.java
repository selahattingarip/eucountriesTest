package region;

import static com.jayway.restassured.RestAssured.get;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.sun.tools.xjc.Language;

import bsh.Console;
import io.restassured.RestAssured;

public class Region {

	@Test
	public void testResponseCode1() throws JSONException
	{ 
		//make get request to fetch JSON data
				Response resp = get("http://restcountries.eu/rest/v1/name/turkey");
				
				//Fetching response in JSON
				JSONArray jsonResponse = new JSONArray(resp.asString());
				
				//Fetching value of nativename parameter
				String nativeName = jsonResponse.getJSONObject(0).getString("nativeName");
				
				//Check that nativename is Turkc
				Assert.assertEquals(nativeName, "Türkiye");
	}
	
	@Test
	public void testResponseCode2() throws JSONException
	{ 
		//make get request to fetch JSON data
				Response resp = get("https://restcountries.eu/rest/v2/region/europe");
				
				//Fetching response in JSON
				JSONArray jsonResponse = new JSONArray(resp.asString());
				
				//Fetching value of languages parameter
					//String nativeName = jsonResponse.getJSONObject(9).getJSONArray("languages");
					JSONArray language = jsonResponse.getJSONObject(9).getJSONArray("languages");
					String nativename = language.getJSONObject(1).getString("nativeName");
							
					//Check that nativename is Turkce
					Assert.assertEquals(nativename, "Türkçe");
						
				
	}

	


@Test
public void testResponseCode3() throws JSONException
{ 
	//make get request to fetch JSON data
			Response resp = get("https://restcountries.eu/rest/v2/region/europe");
			
			//Fetching response in JSON
			JSONArray jsonResponse = new JSONArray(resp.asString());
			
			//Fetching value of languages parameter
				//String nativeName = jsonResponse.getJSONObject(9).getJSONArray("languages");
				JSONArray language = jsonResponse.getJSONObject(9).getJSONArray("languages");
				String nativename = language.getJSONObject(1).getString("name");
						
				//Check that name is Turkish
				Assert.assertEquals(nativename, "Turkish");
					
			
}
	
	@Test
	public void testResponseCode4() throws JSONException
	{ 
		//make get request to fetch JSON data
				Response resp = get("https://restcountries.eu/rest/v2/region/europe");
				
				//Fetching response in JSON
				JSONArray jsonResponse = new JSONArray(resp.asString());
				
				//deneme amacli, sonradan sil
				//Fetching value of languages parameters
					//String nativeName = jsonResponse.getJSONObject(9).getJSONArray("languages");
					JSONArray language = jsonResponse.getJSONObject(9).getJSONArray("languages");
					
					//deneme amacli, sonradan sil
					try {
						String iso = language.getJSONObject(1).getString("nativeName");
						 System.out.println("string");
						 Assert.assertEquals(iso, "Türkçe");
						} catch (Exception e){
						 System.out.println("not string");
						}
							
					//deneme amacli, sonradan sil
					Object iso = language.getJSONObject(1).get("iso639_2");
					if(iso instanceof String) {
						System.out.println("string");
					}
					
					//BUNU KULLAN:
					Object isod = language.getJSONObject(1).get("iso639_2");
					assertTrue(isod instanceof String);
	}


	
}
