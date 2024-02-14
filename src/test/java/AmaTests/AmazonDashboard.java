package AmaTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectModel.amazonPOM;
import Utils.TestUtils;


public class AmazonDashboard {
	static WebDriver driver;

//Run this method before runnning the first method in this Class
	@BeforeTest
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//Launch URL
		String baseUrl = "https://www.amazon.in/";
		driver.get(baseUrl);
		//Maximize Current Windows
		driver.manage().window().maximize();
	}
	
	@Test
	 public void AmazonOperation() throws Exception {
		//instantiation of the page Object Model Class
		amazonPOM page = new amazonPOM(driver);
		
		page.hamburgerClick();
		Thread.sleep(1000);
		page.TelevisionClick();
		
		//Switch Windows to the second window launch
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		page.SwitchedWindowAssert();   
		
	}
	//Execute after the last Method in this Class
	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
	
	}


