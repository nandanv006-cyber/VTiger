package genericUtilities;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

//import org.testng.annotations.Parameters; 
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;

public class BaseClass {

	public DatabaseUtils dLib = new DatabaseUtils();
	public FileUtils fLib = new  FileUtils();
	public ExcelUtils eLib = new  ExcelUtils();
	public JavaUtils jLib = new  JavaUtils();
	public WebDriverUtil wLib = new  WebDriverUtil();
	
	public WebDriver  driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws Throwable
	{
		dLib.connectToDB();
	}
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(String BROWSER) throws Throwable
	{
//		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("firefox");
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		driver.get(URL);
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 10);
		sdriver = driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToAppln() throws Throwable
	{
		String USERNAME=fLib.readDataFromPropertyFile("username");
		String PASSWORD=fLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
	}
	@AfterMethod(alwaysRun = true)
	public void logoutFromAppln()
	{
		HomePage hp = new HomePage(driver);
		hp.clicksignoutLink(driver);
		
	}
	@AfterClass(alwaysRun = true)
	public void logout() {
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void disConnectToDB() throws Exception  {
		dLib.disconnectDB();
	}


}
	
	

