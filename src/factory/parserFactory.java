package factory;

import parser.IParser;
import parser.jsonParser;
/**
 * 
 * @author Ali 
 * The factory is used to initiate different parser, if in future the api mite need to parse,
 * xml or other data type.
 */
public class parserFactory {
	
	public static IParser parser(byte parser_type){
		if (parser_type == constants.json_parser)
			return  new jsonParser();
		else if (parser_type == constants.xml_parser)
			return null; // null should be replaced with proper parser if need arises.
		else throw new IllegalArgumentException("Could Not Find Appropriate Parser!");
	}

}
