import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FlightApi {
	

	/**
	 * 
	 * @param origin of the flight
	 * @param destination of the flight
	 * @param email to send to
	 * @param price of flight to check
	 */
	public String APICall(String origin, String destination, String email, String price) {
		try {
			HttpResponse<JsonNode> postCreateresponse = Unirest.post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
					.header("X-RapidAPI-Host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
					.header("X-RapidAPI-Key", "a1928a77c1msh587c896a62837fbp1e5cb2jsne4bc0c910566")
					.header("Content-Type", "application/x-www-form-urlencoded")
					.body("cabinClass=business&children=0&infants=0&country=US&currency=USD&locale=en-US&originPlace=SFO-sky&destinationPlace=LHR-sky&outboundDate=2019-12-20&adults=1")
					.asJson();

				List<String> location = postCreateresponse.getHeaders().get("Location");
//				String seshKey = location.get(0).replaceAll("http://partners.api.skyscanner.net/apiservices/pricing/uk2/v1.0/", "");
//				System.out.println(seshKey);
				
				
				String country = "US";
				String currency = "USD";
				String locale = "en-US";
				String originPlace = origin+ "-sky";
				String destinationPLace = destination + "-sky";
				String outBoundDate = "2019-12-20";
				String requiredParams = String.format("/%1$s/%2$s/%3$s/%4$s/%5$s/%6$s", country, currency,locale,originPlace,destinationPLace,outBoundDate);
				String url = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0" + requiredParams;
		
				
				HttpResponse<JsonNode> response = Unirest.get(url)
						.header("X-RapidAPI-Host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
						.header("X-RapidAPI-Key", "a1928a77c1msh587c896a62837fbp1e5cb2jsne4bc0c910566")
						.asJson();
				
				System.out.println(response.getBody().getObject());
				
				String test = getMin(response.getBody().getObject());
				System.out.println(test);
				
				return test;
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return e.toString();
			}
	}
	
	public static String getMin(JSONObject obj){
	    JSONArray quotes =  obj.getJSONArray("Quotes");
	    JSONObject quotesItems = (JSONObject) quotes.get(0);
	    Double minPrice = (Double) quotesItems.get("MinPrice");
	    
	    return Double.toString(minPrice);
	  }

	
}
