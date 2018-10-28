package region;

import static com.jayway.restassured.RestAssured.get;

import org.codehaus.groovy.classgen.asm.indy.IndyBinHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class CapitalNameAze {
	
@Test
public void nameCapitalBorder() throws JSONException {
    
    boolean containsIRN = false, containsTUR = false;
    // make get request to fetch JSON data
    Response resp = RestAssured.get("https://restcountries.eu/rest/v2/capital/ankara");

    // Fetching response in JSON
    JSONArray jsonResponse = new JSONArray(resp.asString());
    //Get borders information of Ankara
    JSONArray borders = jsonResponse.getJSONObject(0).getJSONArray("borders");

    int ankBordersSize = borders.length();
    
    //Iterate through Ankara's borders to find AZE
    		for(int k=0; k<ankBordersSize; k++)
    			{
                    if(borders.getString(k).equals("AZE")){
                                    //Make a request to name service with AZE
                                    Response nameResp = RestAssured.get("https://restcountries.eu/rest/v2/name/"+borders.getString(k));
                                    
                                    JSONArray nameJsonResponse = new JSONArray(nameResp.asString());
                                    String name = nameJsonResponse.getJSONObject(0).getString("name");
                                    String capital = nameJsonResponse.getJSONObject(0).getString("capital");
                                    JSONArray azeBorders = nameJsonResponse.getJSONObject(0).getJSONArray("borders");
                                    
                                    int azeBordersSize = azeBorders.length();
                                    
                                    for(int t=0; t<azeBordersSize;t++)
                                    {
                                           if(azeBorders.getString(t).equals("IRN"))
                                           	{
                                             containsIRN = true;
                                           	}
                                           	if(azeBorders.getString(t).equals("TUR"))
                                           	{
                                             containsTUR = true;
                                           	}
                                                    
                                    }
                                    
                                    Assert.assertEquals(name,"Azerbaijan");
                                    Assert.assertEquals(capital, "Baku");
                                    Assert.assertEquals(containsIRN&&containsTUR, true);
                                    
                    }
                    
    			}

}
}

