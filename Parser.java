package test.test1;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Parser{
	  private static Double minPrice;
	  private static JSONObject obj;

	  public Parser(JSONObject obj){
	    this.obj = obj;
	  }

	  public static Double getMin(){
	    JSONArray quotes = (JSONArray) obj.get("Quotes");
	    JSONObject quotesItems = (JSONObject) quotes.get(0);
	    minPrice = (Double) quotesItems.get("MinPrice");
	    
	    return minPrice;
	  }

	  public static void main(String[] args) throws Exception{
	    // parsing file "JSONExample.json"
	        Object obj = new JSONParser().parse(new FileReader("flightTracker.json"));

	        // typecasting obj to JSONObject
	        JSONObject jo = (JSONObject) obj;
	        
	        Parser parser = new Parser(jo);

	        System.out.println("Minimum Price among all airlines: " + getMin());
	  }


	}

