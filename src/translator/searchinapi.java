package translator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class searchinapi extends readfile {
	
	void sinapi() throws Exception { 
	
	
	
	BufferedWriter bw = ofile("/home/tarashankargupta/workspace/translator/opfromapi.csv");
  
		Translate.setClientId("tara_translator");
		Translate.setClientSecret("tltmkpA3fxU8jC7mMudHxsni0bkkeahmIJmMxaOqgpg=");
		BufferedReader br = rfile();
		String line="";
  while((line = br.readLine()) != null){
	  String[] b = line.split(",");
  
	  String from = b[0];
	  String to = b[1];
	  if(from.equals("")) from="AUTO_DETECT";
	  String converted = Translate.execute(b[2],Language.valueOf(from.toUpperCase()),Language.valueOf(to.toUpperCase()));
	  bw.write(converted+"\n");
	  
  }
  br.close();
  bw.close();
}

}
 