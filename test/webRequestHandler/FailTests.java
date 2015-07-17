package webRequestHandler;

import static org.junit.Assert.*;

import org.junit.Test;

import webhandler.WebRequestHandler;

public class FailTests {
	String city_name1 				= "Lahore3213";
	String city_name2				= "";

	@Test
	public void isValidCityName(){
		assertFalse(WebRequestHandler.isValidCityName(city_name1));
		assertFalse(WebRequestHandler.isValidCityName(city_name2));

	}

}
