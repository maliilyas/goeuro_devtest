package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import beans.City;

public class JsonParser implements IParser{




	@Override
	public List<City> consume_response(Object data) {
		List<City> cities = null;
		if(data != null){
			if(data instanceof HttpResponse){
				//Expecting the json response
				try {
					//
					String jsonStr 			= EntityUtils.toString(((HttpResponse) data).getEntity());
					JSONTokener jsonTokener = new JSONTokener(jsonStr);
					JSONArray jsonArray		= new JSONArray(jsonTokener);
					
					cities					= new ArrayList<City>(jsonArray.length());
					int length				= jsonArray.length();
					
					for(int i = 0 ; i  < length ; i++){
						JSONObject jsonCity = (JSONObject) jsonArray.get(i);
						City city			= new City();
						city.set_id(Integer.toString(jsonCity.getInt("_id")));
						city.setName(jsonCity.getString("name"));
						city.setType(jsonCity.getString("type"));
						
						
						JSONObject jsonCityGeoPos = (JSONObject) jsonCity.get("geo_position");
						city.setLongitutde(Double.toString(jsonCityGeoPos.getDouble("longitude")));
						city.setLat(Double.toString(jsonCityGeoPos.getDouble("latitude")));
						
						cities.add(city);
						
					}
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return cities;
	}





}
