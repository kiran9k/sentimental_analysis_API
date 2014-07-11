package sentiment_vivek_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCustomException extends Exception {
	int code;
	HttpURLConnection con;
	String response;
	String conn_type;
	String msg;
	String text;
	public MyCustomException(int responseCode, HttpURLConnection con) {
		// TODO Auto-generated constructor stub
		code=responseCode;
		this.con=con;
		conn_type=con.getContentType();
		try {
			msg=con.getResponseMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getErrorStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		/////////////
		
		Pattern p=Pattern.compile("<p>(.*)</p>");
		Matcher m = p.matcher(response);
		if(m.find())
		{
			
			text=m.group(1);
			
		}
		
		
	}
	public  void printStackTrace()
	{
		System.out.println("Error code: "+code);
		System.out.println("Connection type :"+conn_type);
		System.out.println("Error Message  :"+msg);
		System.out.println(text);	
		
	}
	public String getMessage()
	{
		String output="";
		output+="Error code: "+code+"\n";
		output+="Connection type :"+conn_type+"\n";		
		output+="Error Message "+msg+"\n";
		output+=text;
		return output;
		
	}
}
