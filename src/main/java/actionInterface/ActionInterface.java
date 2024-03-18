package actionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

	//Added all user actions abstract methods to achieve Abstraction
	
	public  void scrollByVisibilityOfElement(WebDriver driver,WebElement ele);
	public void click(WebDriver driver,WebElement ele );
	public boolean isDisplayed(WebDriver driver,WebElement ele);
	public boolean type(WebElement ele,String text);
	public boolean findElement(WebDriver driver,WebElement ele);
	public boolean isSelected(WebDriver driver,WebElement ele);
	public boolean isEnabled(WebDriver driver , WebElement ele);
	public boolean selectBySendkeys(String value,WebElement ele);
	public boolean selectByIndex(WebElement ele,int index);
	public boolean selectByValue(WebElement ele,String value);
	public boolean selectByVisibleText(String visibleText,WebElement ele);
	public boolean mouseHoverByJavaScript(WebElement locator);
	public boolean JSClick(WebDriver driver,WebElement ele);
	public boolean switchToFrameByIndex(WebDriver driver,int index);
	public boolean switchToFrameById(WebDriver driver,String IDValue);
	public boolean switchToFrameByName(WebDriver driver,String nameValue);
	public boolean switchToDefaultFrame(WebDriver driver);
	public void mouseOverElement(WebDriver driver,WebElement ele);
	public boolean moveToElement(WebDriver driver,WebElement ele);
	public boolean mouseover(WebDriver driver,WebElement ele);
	public boolean draggable(WebDriver driver,WebElement source,int x,int y);
	public boolean dragAndDrop(WebDriver driver,WebElement source,WebElement target);
	public boolean slider(WebDriver driver,WebElement source,int x,int y);
	public boolean rightClick(WebDriver driver,WebElement ele);
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle,int count);
	public boolean switchtoNewWindow(WebDriver driver);
	public boolean switchToOldWindow(WebDriver driver);
	public int getColumnCount(WebElement col);
	public int getRowCount(WebElement row);
	public boolean alert(WebDriver driver);
	public boolean lunchURL(WebDriver driver,String url);
	public boolean isAlertPresent(WebDriver driver);
	public String getCurrentURL(WebDriver driver);
	public String getTitle(WebDriver driver);
	public boolean click1(WebElement locator,String locatorName);
	public void fluentWait(WebDriver driver,WebElement ele, int timeOut);
	public void expliciWait(WebDriver driver,WebElement ele,int timeOut);
	public void implicitWait(WebDriver driver,int timeOut);
	public void pageLoadTimeOut(WebDriver driver,int timeOut);
	public String screenshot(WebDriver driver,String fileName);
	public String getCurrentTime();
	
	
	
	
}
