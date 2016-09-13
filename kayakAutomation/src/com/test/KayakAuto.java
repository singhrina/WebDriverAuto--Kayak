package com.test;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.util.ScreenShots;
//import org.openqa.selenium.support.ui.Select;

public class KayakAuto{

	@Test
	public static void FlightBooking(){
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	driver .get("https://www.kayak.com/");
	driver.manage().window().maximize();
	ScreenShots.takescreenshot(driver, "kayak/hotelPage");
	driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MICROSECONDS);
	WebElement flighTtab=driver.findElement(By.linkText("Flights"));
	flighTtab.click();
	for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);}
	driver.manage().timeouts().implicitlyWait( 5,TimeUnit.SECONDS);
	WebElement from = driver.findElement(By.name("origin"));
	from.clear();
	Actions actions = new Actions(driver);
	actions.moveToElement(from).perform();
	from.sendKeys("dfw");
    driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MILLISECONDS);
	WebElement to = driver.findElement(By.xpath("//input[@name='destination']"));
	Actions action = new Actions(driver);
	action.moveToElement(to).perform();
	to.sendKeys("sfo");
	
    driver.manage().timeouts().implicitlyWait( 2000,TimeUnit.MILLISECONDS);
    WebElement depart= driver.findElement(By.xpath("//*[contains(@id,'travelDates-start')]"));
	depart.click();
	driver.findElement(By.xpath(".//*[@id='datepicker']/div[3]/span[2]/span[2]/span[3]/span[7]/span")).click();
	driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MILLISECONDS);
   
	 WebElement returns = driver.findElement(By.xpath("//*[contains(@id,'travelDates-end')]"));
     returns.click();
     driver.findElement(By.xpath(".//*[@id='datepicker']/div[3]/span[2]/span[2]/span[4]/span[5]/span")).click();
     driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MILLISECONDS);
	 
     /*WebElement travelers = driver.findElement(By.xpath(".//*[@class='fieldBlock travelersBlock']"));
	 travelers.click();
	 driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MILLISECONDS);
	
	// WebElement cabinType = driver.findElement(By.xpath("//*[@class='Common-Widgets-Dropdown cabinDropdown formDropdown']"));
	//cabinType.click();
	 driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MILLISECONDS);

	/*Select cabinType1 = new Select(driver.findElement(By.xpath(".//*[@id='jK-x-cabinType-select']/option[3]")));
	cabinType1.selectByValue("b");*/
	driver.findElement(By.linkText("1 adult, Economy"));
	 driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MILLISECONDS);
	
	/* WebElement ButtonForAdult = driver.findElement(By.xpath("//*[contains(@class, 'icon plus')]"));
	 Actions action3 = new Actions(driver);
	 action3.moveToElement(ButtonForAdult).perform();
		action3.click();*/
		//driver.manage().timeouts().implicitlyWait( 10000,TimeUnit.MILLISECONDS);
	 ScreenShots.takescreenshot(driver, "beforeSearch");
	 WebElement searchButton = driver.findElement(By.xpath(".//div[@class='fieldBlock buttonBlock']/button"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", searchButton);
	ScreenShots.takescreenshot(driver, "searchButton");
	} 

	}

