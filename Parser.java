public class Parser{
  private static Double minPrice;
  private static JSONObject obj;

  public Parser(JSONObject obj){
    this.obj = obj;
  }

  public static Double getMin(){
    Double min = (Double) obj.get("Quotes");
    return minPrice;
  }

  public static void main(String[] args) {
    // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        System.out.println("Minimum Price among all airlines: " + getMin());


  }


}
