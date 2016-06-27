package translator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writefile {
	BufferedWriter ofile(String ofapi) throws IOException {
	
	File file = new File(ofapi); 
	if (!file.exists()) {
		file.createNewFile();
	}

	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	return bw;
	}

}
