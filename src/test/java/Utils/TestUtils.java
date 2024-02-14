package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import enums.TargetTypeEnum;

public class TestUtils {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static void scrollToElement(String type, String element) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement scrollDown = null;

		TargetTypeEnum targetTypeEnum = TargetTypeEnum.valueOf(type);
		switch (targetTypeEnum) {


		case XPATH:
			scrollDown = ((WebDriver) driver).findElement(By.xpath(element));
			break;

		default:
			scrollDown = ((WebDriver) driver).findElement(By.id(element));
			break;
		}

		jse.executeScript("arguments[0].scrollIntoView();", scrollDown);
		Thread.sleep(3000);
	}


}
