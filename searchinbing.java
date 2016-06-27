package translator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class searchinbing extends readfile{
	void sinbing() throws IOException, InterruptedException {
	
	BufferedWriter bw = ofile("/home/tarashankargupta/workspace/translator/opfromweb.csv");
	
	WebDriver driver = new FirefoxDriver();
		driver.get("https://www.bing.com/translator");
		List <WebElement>  list = driver.findElements(By.className("LS_HeaderTitle"));
		BufferedReader br = rfile();
		String line="";
  while((line = br.readLine()) != null){
	  String[] b = line.split(",");
  
	  String from = b[0];
	  String to = b[1];String go;
            if(from.equals("")) 
            	{from="Auto-Detect";
            	go = "//td[text()='"+from+"']";
            	}
            else
   			go = "(//td[text()='"+from+"'])[1]";
   			String go2 = "(//td[text()='"+to+"'])[2]";
   			list.get(0).click();
   			Thread.sleep(2000);
   			
   			driver.findElement(By.xpath(go)).click();
   			
   			list.get(1).click();
   			Thread.sleep(2000);  			
   			
   			driver.findElement(By.xpath(go2)).click();
   			driver.findElement(By.className("srcTextarea")).sendKeys(b[2]);
   			Thread.sleep(2000); 
   			String opweb = driver.findElement(By.xpath("(//div[@paragraphname='paragraph0']/span)[2]")).getText();
   			bw.write(opweb+"\n");
   			driver.findElement(By.className("srcTextarea")).clear();
      }
      br.close();
      bw.close();
      
      
      driver.quit();
}

}
