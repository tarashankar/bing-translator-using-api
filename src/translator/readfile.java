package translator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readfile extends writefile {
	BufferedReader rfile() throws IOException {
			
			
			BufferedReader br = new BufferedReader(new FileReader("input1.csv"));
			
				return br;
			
			
	}

}
