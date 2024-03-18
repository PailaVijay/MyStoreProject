
	package com.MyStore.actionDrivers;

	import java.io.File;
	import java.sql.Date;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoAlertPresentException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.MyStore.base.BaseClass;

	import actionInterface.ActionInterface;

	public class Action1 extends BaseClass {

		
		

		public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[].scrollIntoView();", ele);
			
		}

		public static void click(WebDriver driver, WebElement ele) {
			Actions act= new Actions(driver);
			act.moveToElement(ele).click().build().perform();
			
		}

		public static boolean isDisplayed(WebDriver driver, WebElement ele) {
			boolean flag=false;
			flag=findElement(driver,ele);
			if(flag)
			{
				flag=ele.isDisplayed();
				if(flag)
				{
					System.out.println("The element is Displayed");
				}
				else
				{
					System.out.println("The element is not Displayed");
				}
			}
			else
			{
				System.out.println("Not displayed ");
			}
			
			return flag;
		}

		public static boolean type(WebElement ele, String text) {
			boolean flag=false;
			try {
			flag=ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag=true;
			}catch(Exception e)
			{
				System.out.println("Location Not found");
				flag = false;
			}finally {
				if (flag) {
					System.out.println("Successfully entered value");
				} else {
					System.out.println("Unable to enter value");
				}
			  }
			return flag;
		}
		public static boolean findElement(WebDriver driver, WebElement ele) {
			boolean flag=false;
			try {
			ele.isDisplayed();
			flag =true;
			}catch(Exception e)
			{
				flag=false;
			}
			finally {
				if(flag)
				{
					System.out.println("Successfully found element at");
				}
				else
				{
					System.out.println("Unable to locate element at");
				}
			}
			return flag;
			
		}

		public static boolean isSelected(WebDriver driver, WebElement ele) {
			boolean flag=false;
			flag =findElement(driver,ele);
			
			if(flag)
			{
				flag=ele.isSelected();
				if(flag)
				{
					System.out.println("the element is selected");
				}
				else
				{
					System.out.println("the element is not selected");
				}
			}
			else
			{
				System.out.println("not selected");
			}
			return flag;
		}

		public static boolean isEnabled(WebDriver driver, WebElement ele) {
			boolean flag=false;
			flag =findElement(driver,ele);
			
			if(flag)
			{
				flag=ele.isEnabled();
				if(flag)
				{
					System.out.println("the element is enabled");
				}
				else
				{
					System.out.println("the element is not enabled");
				}
			}
			else
			{
				System.out.println("not enabled");
			}
			return false;
		}

		public static boolean selectBySendkeys(String value, WebElement ele) {
			boolean flag = false;
			try {
				ele.sendKeys(value);
				flag = true;
				return true;
			} catch (Exception e) {

				return false;
			} finally {
				if (flag) {
					System.out.println("Select value from the DropDown");		
				} else {
					System.out.println("Not Selected value from the DropDown");
					// throw new ElementNotFoundException("", "", "")
				}
			}
			
			
		}

		public static boolean selectByIndex(WebElement ele, int index) {
			boolean flag=false;
			try {
			Select sel= new Select(ele);
			sel.selectByIndex(index);
			flag=true;
			return true;
			}catch(Exception e)
			{
				return false;
			}finally {
				if(flag)
				{
					System.out.println("Optinon slected by index");
				}else
				{
					System.out.println("Option not selected by index");
				}
				
			}
			
			
		}

		public static boolean selectByValue(WebElement ele, String value) {
			boolean flag=false;
			try {
			Select sel= new Select(ele);
			sel.selectByValue(value);
			flag=true;
			return true;
			}catch(Exception e)
			{
				return false;
			}finally {
				if(flag)
				{
					System.out.println("Option selected by value");
				}
				else
				{
					System.out.println("Option not selected by value");
				}
			}
			
			
		}

		public static boolean selectByVisibleText(String visibleText, WebElement ele) {
			boolean flag = false;
			try {
			Select sel= new Select(ele);
			sel.selectByVisibleText(visibleText);
			flag=true;
			return true;
			}catch(Exception e)
			{
				return false;
			}finally {
				if(flag)
				{
					System.out.println("Option selected by visible text");
				}else
				{
					System.out.println("Option not selected by visible text");
				}
			}
			
			
			
		}

		public static boolean mouseHoverByJavaScript(WebElement locator) {
			boolean flag=false;
			try {
			WebElement mo=locator;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
			}catch(Exception e)
			{
				return false;
			}finally {
				if (flag) {
					System.out.println("MouseOver Action is performed");
				} else {
					System.out.println("MouseOver Action is not performed");
				}
			}
		
		}

		public static boolean JSClick(WebDriver driver, WebElement ele) {
			boolean flag=false;
			try {
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
			flag=true;
			}catch(Exception e)
			{
				throw e;
			}finally {
				if (flag) {
					System.out.println("Click Action is performed");
				} else if (!flag) {
					System.out.println("Click Action is not performed");
				}
			}
			return flag;
		}

		public static boolean switchToFrameByIndex(WebDriver driver, int index) {
			
			boolean flag=false;
			try {
			new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag=true;
			return true;
			}catch(Exception e)
			{
				return false;
			}finally {
				if(flag)
				{
					System.out.println("Frame with index \"" + index + "\" is selected");
				}
				else
				{
					System.out.println("Frame with index \"" + index + "\" is not selected");
				}
			}
			
			
			
		}

		public static boolean switchToFrameById(WebDriver driver, String IDValue) {
			boolean flag=false;
			try {
			driver.switchTo().frame(IDValue);
			flag= true;
			return true;
			}catch(Exception e){
				return false;
			}finally {
				if(flag)
				{
					System.out.println("Frame with Id \"" + IDValue + "\" is selected");
				}
				else
				{
					System.out.println("Frame with Id \"" + IDValue + "\" is not selected");
				}
			}
			
			
			
		}

		public static boolean switchToFrameByName(WebDriver driver, String nameValue) {
			boolean flag=false;
			try {
			driver.switchTo().frame(nameValue);
			flag=true;
			return true;
			}catch(Exception e)
			{
				return false;
			}finally {
				if(flag)
				{
					System.out.println("Frame with Name \"" + nameValue + "\" is selected");
				}
				else if(!flag)
				{
					System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
				}
			}
			
			
		}

		public static boolean switchToDefaultFrame(WebDriver driver) {
			boolean flag=false;
			try {
			driver.switchTo().defaultContent();
			flag=true;
			return true;
			}catch(Exception e)
			{
				return false;
			}finally {
				if(flag)
				{
					// SuccessReport("SelectFrame ","Frame with Name is selected");
				} else if (!flag) {
					// failureReport("SelectFrame ","The Frame is not selected");
				}
			}
			
			
		}

		public static void mouseOverElement(WebDriver driver, WebElement ele) {
			boolean flag=false;
			try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag=true;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if(flag)
				{
					System.out.println(" MouserOver Action is performed on ");
				} else {
					System.out.println("MouseOver action is not performed on");
				}
			}
		}

		public static boolean moveToElement(WebDriver driver, WebElement ele) {
			boolean flag=false;
			try {
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("argumants[0].scrollIntoView(true);", ele);
				
				Actions act= new Actions(driver);
				act.moveToElement(ele).build().perform();
				flag=true;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return flag;
			
		}

		public static boolean mouseover(WebDriver driver, WebElement ele) {
			boolean flag = false;
			try {
				new Actions(driver).moveToElement(ele).build().perform();
				flag = true;
				return true;
			} catch (Exception e) {
				return false;
			} 
			
		}

		public static boolean draggable(WebDriver driver, WebElement source, int x, int y) {
			boolean flag=false;
			try {
			new Actions(driver).moveToElement(source, x, y).build().perform();
			Thread.sleep(5000);
			flag=true;
			return true;
			}catch(Exception e)
			{
				return false;
			} finally {
				if (flag) {
					System.out.println("Draggable Action is performed on \""+source+"\"");			
				} else if(!flag) {
					System.out.println("Draggable action is not performed on \""+source+"\"");
				}
			
		}
		}

		public static boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
			boolean flag = false;
			try {
				new Actions(driver).dragAndDrop(source, target).perform();
				flag = true;
				return true;
			} catch (Exception e) {

				return false;
			} finally {
				if (flag) {
					System.out.println("DragAndDrop Action is performed");
				} else if(!flag) {
					System.out.println("DragAndDrop Action is not performed");
				}
			}
			
		}

		public static boolean slider(WebDriver driver, WebElement ele, int x, int y) {
			boolean flag = false;
			try {
				// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
				// .perform();
				new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
				Thread.sleep(5000);
				flag = true;
				return true;
			} catch (Exception e) {

				return false;
			} finally {
				if (flag) {
					System.out.println("Slider Action is performed");
				} else {
					System.out.println("Slider Action is not performed");
				}
			}
			
		}

		public static boolean rightClick(WebDriver driver, WebElement ele) {
			boolean flag = false;
			try {
				Actions clicker = new Actions(driver);
				clicker.contextClick(ele).perform();
				flag = true;
				return true;
				// driver.findElement(by1).sendKeys(Keys.DOWN);
			} catch (Exception e) {

				return false;
			} finally {
				if (flag) {
					System.out.println("RightClick Action is performed");
				} else {
					System.out.println("RightClick Action is not performed");
				}
			}
			
		}

		public static boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
			boolean flag=false;
			try {
			Set<String> windowList = driver.getWindowHandles();
			String[] array=windowList.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
			
		}

		public static boolean switchtoNewWindow(WebDriver driver) {
			boolean flag = false;
			try {

				Set<String> s=driver.getWindowHandles();
				Object popup[]=s.toArray();
				driver.switchTo().window(popup[1].toString());
				flag = true;
				return flag;
			} catch (Exception e) {
				flag = false;
				return flag;
			} finally {
				if (flag) {
					System.out.println("Window is Navigated with title");				
				} else {
					System.out.println("The Window with title: is not Selected");
				}
			}
			
		}

		public static boolean switchToOldWindow(WebDriver driver) {
			boolean flag = false;
			try {

				Set<String> s=driver.getWindowHandles();
				Object popup[]=s.toArray();
				driver.switchTo().window(popup[0].toString());
				flag = true;
				return flag;
			} catch (Exception e) {
				flag = false;
				return flag;
			} finally {
				if (flag) {
					System.out.println("Focus navigated to the window with title");			
				} else {
					System.out.println("The Window with title: is not Selected");
				}
			}
			
		}

		public static int getColumnCount(WebElement col) {
			List<WebElement> columns = col.findElements(By.tagName("td"));
			int a = columns.size();
			System.out.println(columns.size());
			for (WebElement column : columns) {
				System.out.print(column.getText());
				System.out.print("|");
			}
			return a;
			
		}

		public static int getRowCount(WebElement row) {
			List<WebElement> rows = row.findElements(By.tagName("tr"));
			int a = rows.size() - 1;
			return a;
			
		}

		public static boolean alert(WebDriver driver) {
			boolean presentFlag = false;
			Alert alert = null;

			try {
				// Check the presence of alert
				alert = driver.switchTo().alert();
				// if present consume the alert
				alert.accept();
				presentFlag = true;
			} catch (NoAlertPresentException ex) {
				// Alert present; set the flag

				// Alert not present
				ex.printStackTrace();
			} finally {
				if (!presentFlag) {
					System.out.println("The Alert is handled successfully");		
				} else{
					System.out.println("There was no alert to handle");
				}
			}

			return presentFlag;
			
		}

		public static boolean lunchURL(WebDriver driver, String url) {
			boolean flag = false;
			try {
				driver.navigate().to(url);
				flag = true;
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				if (flag) {
					System.out.println("Successfully launched \""+url+"\"");				
				} else {
					System.out.println("Failed to launch \""+url+"\"");
				}
			}
			
		}

		public static boolean isAlertPresent(WebDriver driver) {
			try 
			{ 
				driver.switchTo().alert(); 
				return true; 
			}   // try 
			catch (NoAlertPresentException Ex) 
			{ 
				return false; 
			}   // catch 
			
		}

		public static String getCurrentURL(WebDriver driver) {
			boolean flag = false;

			String text = driver.getCurrentUrl();
			if (flag) {
				System.out.println("Current URL is: \""+text+"\"");
			}
			return text;
		}

		public static String getTitle(WebDriver driver) {
			boolean flag = false;

			String text = driver.getTitle();
			if (flag) {
				System.out.println("Title of the page is: \""+text+"\"");
			}
			return text;
		}

		public static boolean click1(WebElement locator, String locatorName) {
			boolean flag = false;
			try {
				locator.click();
				flag = true;
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				if (flag) {
					System.out.println("Able to click on \""+locatorName+"\"");
				} else {
					System.out.println("Click Unable to click on \""+locatorName+"\"");
				}
			}
		}

		public static void fluentWait(WebDriver driver, WebElement ele, int timeOut) {
			Wait<WebDriver> wait = null;
		    try {
		        wait = new FluentWait<WebDriver>((WebDriver) driver)
		        		.withTimeout(Duration.ofSeconds(20))
		        	    .pollingEvery(Duration.ofSeconds(2))
		        	    .ignoring(Exception.class);
		        wait.until(ExpectedConditions.visibilityOf(ele));
		        ele.click();
		    }catch(Exception e) {
		    }
			
		}

		public static void expliciWait(WebDriver driver, WebElement ele, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		}

		public static void implicitWait(WebDriver driver, int timeOut) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
			
		}

		public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
			
		}

		public static String screenshot(WebDriver driver, String fileName) {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + fileName + "_" + dateName + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			// This new path for jenkins
			String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + fileName + "_"
					+ dateName + ".png";
			return newImageString;
		}

		public static String getCurrentTime() {
			String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date(0));
			return currentDate;
		}
		
		
	}

