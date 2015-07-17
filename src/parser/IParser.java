package parser;

import java.util.List;

import beans.City;

public interface IParser {
	
	/**
	 * A method to consume the response from the Web Handler.
	 */
	public List<City> consume_response(Object data);
}
