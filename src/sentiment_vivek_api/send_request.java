package sentiment_vivek_api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class send_request {

	public static void send(String text) throws IOException, MyCustomException, ParserConfigurationException, SAXException 
	{
		String USER_AGENT = "Mozilla/5.0";
		String url = "http://sentiment.vivekn.com/api/text/";
		 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setConnectTimeout(5000);//timeout of 5secs 
		
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		con.setDoOutput(true);
		
		String urlParameters = "txt="+text;
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		int responseCode = con.getResponseCode();
	
		//con.connect();
		if(responseCode==200)
		{
			//no problem .working fine ..
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			con.disconnect();
			//return response.toString();
			Sentimental_analysis.response_string=response.toString();
		}
		else
		{	
			Sentimental_analysis.response_string=null;
			throw new MyCustomException(responseCode,con);			
		}		
	}
}
