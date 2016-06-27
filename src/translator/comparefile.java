package translator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.annotations.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class comparefile {
	@SuppressWarnings("deprecation")
	@Test
	public static void compare() throws FileNotFoundException {
	
	File file1 = new File("opfromweb.csv");
	File file2 = new File("opfromhttp.csv");
	Scanner inputFile1 = new Scanner (file1);
    @SuppressWarnings("resource")
	Scanner inputFile2 = new Scanner (file2);

    // While there is another line to read.
    while(inputFile1.hasNext())
    {
    	String s1 = inputFile1.nextLine();
    	String s2 = inputFile2.nextLine();
    	System.out.println("from web: "+s1+"\nfrom api: "+s2);
    	Assert.assertEquals(s1, s2);
    
    	
    }
	
	
}
}
