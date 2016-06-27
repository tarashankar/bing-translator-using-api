package translator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.*;

import com.memetix.mst.language.Language;

public class SimpleHTTPPOSTRequester extends writefile {

	
	public void makeHTTPPOSTRequest() throws IOException, JSONException {

		BufferedWriter bw = ofile("/home/tarashankargupta/workspace/translator/opfromhttp.csv");
		URL url1 = new URL("https://datamarket.accesscontrol.windows.net/v2/OAuth2-13");
		HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
		
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String id=URLEncoder.encode("tara_translator", "UTF-8");
		String pass=URLEncoder.encode("tltmkpA3fxU8jC7mMudHxsni0bkkeahmIJmMxaOqgpg=", "UTF-8");	
				
		String urlParameters = "grant_type=client_credentials&client_id="+id+"&client_secret="+pass+"&scope=http://api.microsofttranslator.com";
		conn.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String s1=new String(response);
		
		JSONObject obj=new JSONObject(s1);
		String access_token=(String) obj.get("access_token");
		
		

		String line="";
		BufferedReader br = new BufferedReader(new FileReader("input1.csv"));
		while((line = br.readLine()) != null){
			  String[] b = line.split(",");
			  String text = b[2];		  
			  if(b[0].equals("")) b[0]="English";
			  Language fr = Language.valueOf(b[0].toUpperCase());
				Language tr = Language.valueOf(b[1].toUpperCase());
				String from = fr.toString();
				String to = tr.toString();
				
			 
		

		String uri = "http://api.microsofttranslator.com/v2/Http.svc/Translate?text=" + URLEncoder.encode(text, "UTF-8") + "&from=" + from + "&to=" + to;
		String authToken = "Bearer" + " " + access_token;

		URL urll=new URL(uri);	
		HttpURLConnection conn1 = (HttpURLConnection) urll.openConnection();
		conn1.setRequestMethod("GET");
		conn1.setRequestProperty("Authorization",authToken);
		BufferedReader in1 = new BufferedReader(
        new InputStreamReader(conn1.getInputStream()));
		String line1="";
		StringBuffer response1 = new StringBuffer();

		while ((line1 = in1.readLine()) != null) {
			response1.append(line1);
		}
		in1.close();
		String s2=response1.toString();
		s2 = s2.substring(s2.indexOf(">") + 1);
		s2 = s2.substring(0, s2.indexOf("<"));		
		System.out.println(s2);	
		bw.write(s2+"\n");
		}
		br.close();
		bw.close();
		
		
	}

}