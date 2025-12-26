package genericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtil 
{
	/**
	 * This Method is to maximixe the browser
	 * @author Nandan V
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method it to wait till the page /element load
	 * @author Nandan V
	 * @param driver
	 * @param seconds
	 */
	public void waitForPageLoad(WebDriver driver,int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	/**@author Nandan V
	 * This method it to wait till the element to be visible
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntilEleToBeVisible(WebDriver driver,int seconds,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public Select dropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel;
	}
	
	/**
	 * @author Nandan V
	 * This method it to select dropdown by using value 
	 * @param element
	 * @param value
	 */
	public void dropdownUsingValue(WebElement element,String value)
	{
		dropdown(element).selectByValue(value);
	}
	
	
	/**
	 * This method it to select dropdown by using index 
	 * @param element
	 * @param index
	 */
	public void dropdownUsingIndex(WebElement element,int index)
	{
		dropdown(element).selectByIndex(index);
	}
	/**
	 * This method it to select dropdown by using visibleText
	 * @param element
	 * @param text
	 */
	public void dropdownUsingVisibletext(WebElement element,String text)
	{
		dropdown(element).selectByVisibleText(text);
	}
	
	public Actions action(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	/**
	 * This method it to mousehover on the element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		action(driver).moveToElement(element).perform();;
	}
	/**
	 *  This method it to mousehover on the element and click on same element
	 * @author Nandan V
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAndClick(WebDriver driver,WebElement element)
	{
		action(driver).moveToElement(element).click(element).perform();
	}
	/**
	 * This method it to drag and drop the element from one place to another place
	 * @param driver
	 * @param dragelement
	 * @param dropelement
	 */
	public void dragAndDrop(WebDriver driver,WebElement dragelement,WebElement dropelement)
	{
		action(driver).dragAndDrop(dragelement, dropelement).perform();
	}
	/**
	 * This method is used to
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		action(driver).scrollToElement(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		action(driver).doubleClick(element).perform();
	}
	/**
	 * This method will do right click on an element 
	 * @author Nandan V
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		action(driver).contextClick(element).perform();
	}
	/**
	 * This method will click and hold the element 
	 * @author Nandan V
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver,WebElement element)
	{
		action(driver).clickAndHold(element).perform();
	}
	/**
	 * this method is used to click and hold element and release that element to specified webelement
	 * @author Nandan V 
	 * @param driver
	 * @param element
	 * @param targetelement
	 */
	public void clickHoldAndRelease(WebDriver driver,WebElement element,WebElement targetelement)
	{
		action(driver).clickAndHold(element).release(targetelement).perform();
	}
	/**
	 * this Method is used to switch to child window when you know expected title
	 * @author Nandan V
	 * @param driver
	 * @param expTitle
	 */
	public void switchToChildWindow(WebDriver driver,String expTitle)
	{
//		String parentID=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String curwin= it.next();
			String actTitle= driver.switchTo().window(curwin).getTitle();
			if(actTitle.contains(expTitle))
				break;
		}
	}
	/**
	 * This method is used to switchto child window when you know the window handle
	 * @param driver
	 * @param handles
	 * @param parent
	 */
	
	public void switchToChildWindow(WebDriver driver,Set<String> handles,String parent)
	{
		for(String child:handles)
		{
			if(!parent.contains(child))
			{
				driver.switchTo().window(child);
				break;
			}
			
		}
	}
	public void switchToParentWindow(WebDriver driver,String parentid)
	{
		driver.switchTo().window(parentid);
	}
//	frames
	public void switchtoChildFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchtoChildFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
//	alerts
	public void acceptAlert(WebDriver driver)
	{driver.switchTo().alert().accept();}
	public void dismissAlert(WebDriver driver)
	{driver.switchTo().alert().dismiss();}
	public void getTextAlert(WebDriver driver)
	{driver.switchTo().alert().getText();}
	public void sendKeysAlert(WebDriver driver,String text)
	{driver.switchTo().alert().sendKeys(text);}
	
	//javaScript Executor methods
		public JavascriptExecutor javaScriptExecuter(WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			return js;
		}
		
		public void scrollHeight(WebDriver driver) {
			
			javaScriptExecuter(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		//scrollTillElement
		public void scrollUntilEleIsVisibleUsingJSE(WebDriver driver,WebElement element) {
			javaScriptExecuter(driver).executeScript("arguments[0].scrollIntoView();", element);
		}
		
		//click on element
		public void clickOnElementUsingJSE(WebDriver driver,WebElement element) {
			javaScriptExecuter(driver).executeScript("arguments[0].click()", element);
		}
		
		//sendkeys
		public void enterValueIntoTextFieldUsingJSE(WebDriver driver,WebElement element,String value) {
			javaScriptExecuter(driver).executeScript("arguments[0].value=arguments[1]", element,value);
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
