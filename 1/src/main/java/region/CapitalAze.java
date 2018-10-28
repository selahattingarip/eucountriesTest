package region;

import static com.jayway.restassured.RestAssured.get;

import org.codehaus.groovy.classgen.asm.indy.IndyBinHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class CapitalAze {
	
	@Test
	public void testResponseCode1() throws JSONException
	{ 
		//make get request to fetch JSON data
				Response resp = get("https://restcountries.eu/rest/v2");
				
				//Fetching response in JSON
				JSONArray jsonResponse = new JSONArray(resp.asString());
				
				//Fetching value of all cities parameter
					//String nativeName = jsonResponse.getJSONObject(9).getJSONArray("languages");
				
				int count = jsonResponse.length(); // get totalCount of all jsonObjects
				for(int i=0; i<count; i++)
				{
					
					String capital = jsonResponse.getJSONObject(i).getString("capital");
					
					if (capital.equals("Ankara"))
					{
						System.out.println("!!!!!!!!girdi!!!!!!!!!" +capital+"\n ve object bumber="+i);
						JSONArray borders = jsonResponse.getJSONObject(i).getJSONArray("borders");
						
						System.out.println(borders);
						
						int countBorders = borders.length(); // get totalCount of all borders
						for(int y=0; y<countBorders; y++)
						{
							Object level = borders.get(y);
							System.out.println(level);
							if(level.equals("AZE"))
							{
								for(int x=0; x<count; x++)
								{
								String alpha3Code = jsonResponse.getJSONObject(x).getString("alpha3Code");
								
									if ((alpha3Code.equals("AZE"))==true)
									{
										String name = jsonResponse.getJSONObject(x).getString("name");
										Assert.assertEquals(name, "Azerbaijan");
									}
								}
							}
							}
						}
					}	
							
	}			
	


@Test
public void testResponseCode2() throws JSONException
{ 
	//make get request to fetch JSON data
			Response resp = get("https://restcountries.eu/rest/v2");
			
			//Fetching response in JSON
			JSONArray jsonResponse = new JSONArray(resp.asString());

			//Fetching value of all cities parameter
				//String nativeName = jsonResponse.getJSONObject(9).getJSONArray("languages");
			
			int count = jsonResponse.length(); // get totalCount of all jsonObjects
			for(int i=0; i<count; i++)
			{
				
				String capital2 = jsonResponse.getJSONObject(i).getString("capital");
				
				if ((capital2.equals("Ankara"))==true)
				{
					System.out.println("!!!!!!!!girdi!!!!!!!!!" +capital2+"\n ve object bumber="+i);
					JSONArray borders = jsonResponse.getJSONObject(i).getJSONArray("borders");
					
					System.out.println(borders);
					
					int countBorders = borders.length(); // get totalCount of all borders
					for(int y=0; y<countBorders; y++)
					{
						Object level = borders.get(y);
						System.out.println(level);
						if(level.equals("AZE"))
						{
							for(int x=0; x<count; x++)
							{
							String alpha3Code = jsonResponse.getJSONObject(x).getString("alpha3Code");
							
								if ((alpha3Code.equals("AZE"))==true)
								{
									String capitalofAze = jsonResponse.getJSONObject(x).getString("capital");
									Assert.assertEquals(capitalofAze, "Baku");
								}
							}
						}
						}
					}
				}	
						
}


@Test
public void testResponseCode3() throws JSONException
{ 
	//make get request to fetch JSON data
			Response resp = get("https://restcountries.eu/rest/v2");
			
			//Fetching response in JSON
			JSONArray jsonResponse = new JSONArray(resp.asString());

			//Fetching value of all cities parameter
				//String nativeName = jsonResponse.getJSONObject(9).getJSONArray("languages");
			
			int count = jsonResponse.length(); // get totalCount of all jsonObjects
			for(int i=0; i<count; i++)
			{
				
				String capital2 = jsonResponse.getJSONObject(i).getString("capital");
				
				if ((capital2.equals("Ankara"))==true)
				{
					System.out.println("!!!!!!!!girdi!!!!!!!!!" +capital2+"\n ve object bumber="+i);
					JSONArray borders = jsonResponse.getJSONObject(i).getJSONArray("borders");
					
					System.out.println(borders);
					
					int countBorders = borders.length(); // get totalCount of all borders
					for(int y=0; y<countBorders; y++)
					{
						Object level = borders.get(y);
						System.out.println(level);
						if(level.equals("AZE"))
						{
							for(int x=0; x<count; x++)
							{
							String alpha3Code = jsonResponse.getJSONObject(x).getString("alpha3Code");
							
								if ((alpha3Code.equals("AZE"))==true)
								{
									JSONArray bordersAze = jsonResponse.getJSONObject(x).getJSONArray("borders");
									System.out.println(bordersAze);
									
									int uzunluk = bordersAze.length();
                                	boolean isTUR = false;
                                	boolean isIRN = false;	
                                	
                                    for(int z=0; z<uzunluk; z++)
                                    {	
                                    	Object levelAze= bordersAze.get(z);
									
                                    	if(!isTUR && levelAze.equals("TUR")){ isTUR = true; }
                                    	if(!isIRN && levelAze.equals("IRN")){ isIRN = true; }
                                    	
                                    }
                                    Assert.assertTrue(isTUR && isIRN);
								}
							}
						}
						}
					}
				}	
						
}


}

