package parser;

import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.json.JSONObject;

import beans.City;

public class JsonParser implements IParser{




	@Override
	public List<City> consume_response(Object data) {
		List<City> cities = null;
		if(data != null){
			if(data instanceof HttpResponse){
				//Expecting the json response
				try {
					JSONObject json = new JSONObject(((HttpResponse) data).getEntity());
					for(Iterator iterator = json.keySet().iterator(); iterator.hasNext();) {
					    String key = (String) iterator.next();
					    System.out.println(json.get(key));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		}
		return cities;
	}





}
