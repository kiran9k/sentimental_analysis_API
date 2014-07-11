package sentiment_vivek_api;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

public class Sentimental_analysis {
	public static String response_string;
	public static String confidence;
	public static String sentiment;
	
	public static ArrayList<String> get_sentiment(String s) throws IOException, MyCustomException, ParserConfigurationException, SAXException, ParseException
	{
		ArrayList<String> result =new ArrayList<String>();
		if(s.length()==0)
		{
			System.out.println("Error : input string length is 0");
			return result;
		}
		if(s!=null)
		{
			//proceed 
			//call vivek api
			send_request.send(s);
			if(response_string==null)
			{
				//return
				return result;
			}
			else
			{
			//	System.out.println(response_string);
				//get json data
				read_json.json_reader(response_string);
				//check for error in data
				if(sentiment==null)
				{
					System.out.println("error in parsing ");
					sentiment=null;
				}
				result.add(sentiment);
				result.add(confidence);
				//	System.out.println(sentiment);
				//return result
				//return error code 
				return result;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//entry leads to here !!
		if(args.length>0)
		{
			//System.out.println(args[0]);
			try 
			{
				get_sentiment(args[0]);//input);
				if(sentiment!=null)
				{		
					System.out.println("Sentence : "+args[0]);
					System.out.println("Sentiment of given sentences : "+sentiment );
					System.out.println("Accuracy of prediction :"+confidence +" %");
					
				}				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyCustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("No content provided for sentiment analysis");
		}
		
	}

}
