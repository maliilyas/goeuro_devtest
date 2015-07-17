package parser;

import java.util.List;

import beans.City;

public interface IParser {
	
	/**
	 * 
	 */
	public List<City> get_parsed_data(Object data);
}
