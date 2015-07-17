package webRequestHandler;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.junit.Test;

import beans.City;
import factory.constants;
import factory.parserFactory;
import factory.writerFactory;
import parser.IParser;
import webhandler.WebRequestHandler;
import writer.IWriter;

/**
 * 
 * @author Ali 
 * The tests are divided into two packages, one that should pass and the other that should fail.
 */
public class PassTests {
	String city_name1 						= "Lahore";

	String city_name2						= "Postdam";

	String city_name3						= "ArkhamCity";

	String city_name_api           		    = "Berlin"; //Potsdam

	WebRequestHandler web_req_handler		= null;
	HttpResponse  response					= null;


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
		
		IParser json_parser = parserFactory.parser(constants.json_parser);
		List<City> cities = json_parser.consume_response(response);
		IWriter writer    = writerFactory.writer(constants.csv_writer);
		writer.write_file(cities);
		web_req_handler.destroy();

	}

}
