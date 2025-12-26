package assignment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class sample {

	public static void main(String[] args) throws Exception {
		        WebDriver driver = new EdgeDriver();
		        driver.get("https://www.google.com");
		        Thread.sleep(10000);
		        driver.quit();
		    }
		

	}

