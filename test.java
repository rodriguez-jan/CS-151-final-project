import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class test {
	public static void main(String args[]) {
	try {
			HttpResponse<JsonNode> response = Unirest.post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
					.header("X-RapidAPI-Host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
					.header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
					.header("Content-Type", "application/x-www-form-urlencoded")
					.field("inboundDate", "2019-09-10")
					.field("cabinClass", "business")
					.field("children", 0)
					.field("infants", 0)
					.field("country", "US")
					.field("currency", "USD")
					.field("locale", "en-US")
					.field("originPlace", "SFO-sky")
					.field("destinationPlace", "LHR-sky")
					.field("outboundDate", "2019-09-01")
					.field("adults", 1)
					.asJson();
			System.out.println(response);
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello World");

	}
}
