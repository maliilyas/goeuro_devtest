package webhandler;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 
 * @author Ali 
 * The basic web app handler using Apache HttpClient.
 */
public class WebRequestHandler {

	public static String api_query = "http://api.goeuro.com/api/v2/position/suggest/en/%s";
	private CloseableHttpClient http_client  = null;
	private HttpGet http_get					= null;
	private CloseableHttpResponse response	= null;

	public  CloseableHttpResponse get_city_info(String city_name){
		if(isValidCityName(city_name)){
			api_query = String.format(api_query, city_name);
			http_client = HttpClients.createDefault();
			http_get    = new HttpGet(api_query);
			try {
				response    = http_client.execute(http_get);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


		}else throw new IllegalArgumentException("The City Name is not Valid!");

		return response;
	}
	/**
	 * Naive city name validity check, since the api will be interacted from here.
	 * @param city_name
	 * @return
	 */
	public static boolean isValidCityName(String city_name){
		if(!city_name.equals("") && !city_name.matches(".*[0-9].*"))
			return true;
		else
			return false;

	}
	/**
	 * Closing all the open streams and setting to null so can be garbage collected.
	 */
	public void destroy(){
		try{
			if(http_client != null )
				http_client.close();
			if(response != null)
				response.close();
		}catch(IOException io){
			io.printStackTrace();

		}
		http_client = null;
		http_get    = null;
		response    = null;
	}


}
