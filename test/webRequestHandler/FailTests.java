package webRequestHandler;

import static org.junit.Assert.assertFalse;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.junit.Test;

import webhandler.WebRequestHandler;

public class FailTests {
	String city_name1 				= "Lahore3213";
	String city_name2				= "";
	
	WebRequestHandler web_req_handler		= null;
	HttpResponse  response			        = null;
	
	String	city_name_api					= "Arkham City";

	@Test
	public void isValidCityName(){
		assertFalse(WebRequestHandler.isValidCityName(city_name1));
		assertFalse(WebRequestHandler.isValidCityName(city_name2));

	}
	
	/**
	 * Checking the Api, it should throw illegal argument exception.
	 */
	@Test
	public void checkApiResponseWithValidCityName(){

		web_req_handler 	= new  WebRequestHandler();
		response        	= web_req_handler.get_city_info(city_name_api);
		
		web_req_handler.destroy();

	}

}
