package sentiment_vivek_api;

import java.lang.reflect.Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class read_json {

	public static void json_reader(String s) throws ParseException
	{
		
	      JSONParser parser=new JSONParser();
	      Object obj = parser.parse(s);
	      
	      JSONObject array = (JSONObject)obj;
	      // System.out.println("The 2nd element of array");
	      Object x=array.get("result");
	      obj = parser.parse(x.toString());
	      array = (JSONObject)obj;
	      Sentimental_analysis.confidence=array.get("confidence").toString();
	      Sentimental_analysis.sentiment=array.get("sentiment").toString();      
		
	}

}
