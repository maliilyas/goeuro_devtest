package webRequestHandler;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;

import webhandler.WebRequestHandler;

/**
 * 
 * @author Ali 
 * The tests are divided into two packages, one that should pass and the other that should fail.
 */
public class PassTests {
	String city_name1 						= "Lahore";
	
	String city_name2						= "Postdam";
	
	String city_name3						= "Arkham City";
	
	String city_name_api           		    = "Postdom";
	
	WebRequestHandler web_req_handler		= null;
	CloseableHttpResponse response			= null;
	
	
	/**
	 * Testing the valid city name
	 */
	
	@Test
	public void isValidCityName(){
		assertTrue(WebRequestHandler.isValidCityName(city_name1));
		assertTrue(WebRequestHandler.isValidCityName(city_name2));
		assertTrue(WebRequestHandler.isValidCityName(city_name3));

	}
	
	/**
	 * Checking the status of response , should be Ok/200
	 */
	@Test
	public void checkApiResponseWithValidCityName(){
		
		web_req_handler 	= new  WebRequestHandler();
		response        	= web_req_handler.get_city_info(city_name_api);
		StatusLine status 	= response.getStatusLine();
		assertEquals(status.getReasonPhrase(),"OK");
		try {
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		web_req_handler.destroy();
		 
		
	}

}
