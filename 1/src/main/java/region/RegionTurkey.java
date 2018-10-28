package region;

import static com.jayway.restassured.RestAssured.get;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.sun.tools.xjc.Language;

import bsh.Console;
import io.restassured.RestAssured;

public class RegionTurkey {

	public boolean isTurkishforNativeName(JSONObject paramObj) throws JSONException 
	{
		//Fetching value of languages parameter
		JSONArray language = paramObj.getJSONArray("languages");
		
		int countLang=language.length(); // get totalCount of language array in "i"th object. 
        
    	for(int y=0; y<countLang; y++)
    		{
            //Fetch NativeName as a string of "y"th value.
            String nativename = language.getJSONObject(y).getString("nativeName");
                                                   
            	//Check "y"th value of nativename is Turkce.
            	if(nativename.equals("Türkçe"))
            		{
            			//Check that nativename is Turkce.
                      	return true;
                  	}
    		}
    	return false;
		
	}
	
	public boolean isTurkishforName(JSONObject paramObj) throws JSONException 
	{
		//Fetching value of languages parameter
		JSONArray language = paramObj.getJSONArray("languages");
		
		int countLang=language.length(); // get totalCount of language array in "i"th object. 
        
    	for(int y=0; y<countLang; y++)
    		{
            //Fetch NativeName as a string of "y"th value.
            String name = language.getJSONObject(y).getString("name");
                                                   
            	//Check "y"th value of name is Turkish.
            	if(name.equals("Turkish"))
            		{
            			//Check that name is Turkish.
                      	return true;
                  	}
    		}
    	return false;
		
	}
	
	public boolean isTurkishforIso(JSONObject paramObj) throws JSONException 
	{
		//Fetching value of languages parameter
		JSONArray language = paramObj.getJSONArray("languages");
		
		int countLang=language.length(); // get totalCount of language array in "i"th object. 
        
    	for(int y=0; y<countLang; y++)
    		{
            //Fetch iso as a string of "y"th value.
            String iso = language.getJSONObject(y).getString("iso639_2");
                                                   
            	//Check "y"th value of iso is iso639_2 is string.
            	if(iso instanceof String)
            		{
                      	return true;
                  	}
    		}
    	return false;
		
	}
	
	@Test
	public void nativeNameTurkce() throws JSONException
	{ 
		//make get request to fetch JSON data.
		Response resp = get("https://restcountries.eu/rest/v2/region/asia");
				
		//Fetching response in JSON.
		JSONArray jsonResponse = new JSONArray(resp.asString());
				
		int count = jsonResponse.length(); // get totalCount of all jsonObjects.
		
		//create object for nullcheck.
		JSONObject TurkeyObj =  new JSONObject();
		
		for(int i=0; i<count; i++)
		{
			//Fetching value of all name parameters
			String name = jsonResponse.getJSONObject(i).getString("name");
				
				//Check Turkey name is exist.
				if(name.equals("Turkey"))
				{
					TurkeyObj = jsonResponse.getJSONObject(i);
					break;
				}   
				
		}
		
		//If condition is exist then continue.
		if(TurkeyObj != null)
		{
            Assert.assertTrue(isTurkishforNativeName(TurkeyObj));    
		}			
	}
	



@Test
public void nameTurkish() throws JSONException
{ 
	//make get request to fetch JSON data.
	Response resp = get("https://restcountries.eu/rest/v2/region/asia");
			
	//Fetching response in JSON.
	JSONArray jsonResponse = new JSONArray(resp.asString());
			
	int count = jsonResponse.length(); // get totalCount of all jsonObjects.
	
	//create object for nullcheck.
	JSONObject TurkeyObj =  new JSONObject();
	
	for(int i=0; i<count; i++)
	{
		//Fetching value of all name parameters
		String name = jsonResponse.getJSONObject(i).getString("name");
			
			//Check Turkey name is exist.
			if(name.equals("Turkey"))
			{
				TurkeyObj = jsonResponse.getJSONObject(i);
				break;
			}   
			
	}
	
	//If condition is exist then continue.
	if(TurkeyObj != null)
	{
        Assert.assertTrue(isTurkishforName(TurkeyObj));    
	}			
}

	
	@Test
	public void iso() throws JSONException
	{ 
		//make get request to fetch JSON data.
		Response resp = get("https://restcountries.eu/rest/v2/region/asia");
				
		//Fetching response in JSON.
		JSONArray jsonResponse = new JSONArray(resp.asString());
				
		int count = jsonResponse.length(); // get totalCount of all jsonObjects.
		//create object for nullcheck.
		JSONObject TurkeyObj =  new JSONObject();
		
		for(int i=0; i<count; i++)
		{
			//Fetching value of all name parameters
			String name = jsonResponse.getJSONObject(i).getString("name");
				
				//Check Turkey name is exist.
				if(name.equals("Turkey"))
				{
					TurkeyObj = jsonResponse.getJSONObject(i);
					break;
				}   
				
		}
		
		//If condition is exist then continue.
		if(TurkeyObj != null)
		{
	        Assert.assertTrue(isTurkishforIso(TurkeyObj));    
		}

	
}
}
