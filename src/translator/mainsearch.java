package translator;

public class mainsearch {	
		
	public static void main(String args[]) throws Exception {
		
		searchinapi sp = new searchinapi();
		searchinbing sb = new searchinbing();
		sb.sinbing();
		sp.sinapi();
		SimpleHTTPPOSTRequester sp1 = new SimpleHTTPPOSTRequester();
		sp1.makeHTTPPOSTRequest();
		comparefile.compare();
		
	}
		
}
	   		
	  
	