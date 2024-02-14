package PageObjectModel;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.TestUtils;

public class amazonPOM {

	//Declaration of Webdriver
	WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 5000);

	//Page Object Model Class Constructor 
	public amazonPOM(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Object Model Web Elements
	By hamburgerClick = By.xpath("//a[@id='nav-hamburger-menu']/i"); 
	By tvClick = By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]");
	By television = By.xpath("//a[contains(text(),'Televisions')]");
	By samsungFilter = By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[17]/ul[1]/li[3]/span[1]/a[1]/div[1]/label[1]");
	By filterdropdown = By.xpath("//span[contains(text(),'Featured')]");
	By hightoLow = By.xpath("//a[contains(text(),'Price: High to Low')]");
	By secondHighest = By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h2[1]/a[1]/span[1]");
	By aboutItem =   By.xpath("//h1[contains(text(),'About this item')]");
	By section = By.xpath("//*[contains(@class, 'a-unordered-list a-vertical a-spacing-mini')]");
	
	//This Method Clicks on the Hamburger Button to display Menu
	public void hamburgerClick() throws InterruptedException {
	
			driver.findElement(hamburgerClick).click();
			Thread.sleep(1000);
	
	}
		//This Method Performs the Actions that lead to the Filtetr and Selection of Samsung TV 
		public void TelevisionClick() throws InterruptedException {
		
				driver.findElement(tvClick).click();
				Thread.sleep(500);
				driver.findElement(television).click();
				Thread.sleep(10000);
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(samsungFilter));
				
				driver.findElement(samsungFilter).click();
				Thread.sleep(10000);
				driver.findElement(filterdropdown).click();
				Thread.sleep(10000);
				driver.findElement(hightoLow).click();
				Thread.sleep(10000);
				driver.findElement(secondHighest).click();
				Thread.sleep(10000);

	}
		//Assertion and Console Log of Information of Samsung after Window Switch
		public void SwitchedWindowAssert() throws InterruptedException {
			
			//convert web Element to String
			String Aboutitem = driver.findElement(aboutItem).getText();
			System.out.println(">>>>>" +Aboutitem);
			//Assertion of Expected result "About this item" and actual result 
			assertEquals(Aboutitem, "About this item");
			Thread.sleep(5000);
			String sectionlog = driver.findElement(section).getText();
			//Output or Console log of About this item section
			System.out.println(sectionlog);
			
	
	}
	

}
