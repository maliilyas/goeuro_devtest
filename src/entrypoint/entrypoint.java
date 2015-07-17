package entrypoint;

import java.util.List;

import org.apache.http.HttpResponse;

import beans.City;
import factory.constants;
import factory.parserFactory;
import factory.writerFactory;
import parser.IParser;
import webhandler.WebRequestHandler;
import writer.IWriter;

public class EntryPoint {

	public static String city_name			= "";

	public static void main(String [] args){
		if(args.length != 1){
			throw new IllegalArgumentException("There Should be only one name for the City!");
		}else{
			try{
				WebRequestHandler web_req_handler		= null;
				HttpResponse  response			= null;
				city_name = args[0];
				web_req_handler 	= new  WebRequestHandler();
				response        	= web_req_handler.get_city_info(city_name);
				String status 	= response.getStatusLine().getReasonPhrase();
				 	   
				if(status.equals("OK")){
					IParser json_parser = parserFactory.parser(constants.json_parser);
					List<City> cities = json_parser.consume_response(response);
					IWriter writer    = writerFactory.writer(constants.csv_writer);
					writer.write_file(cities);
					web_req_handler.destroy();
				}else{
					System.out.println((String.format("The request status is %s and not Ok.",status)));
				}

			}catch(IndexOutOfBoundsException e){
				e.printStackTrace();
			}
		}
	}

}
