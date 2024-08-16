package Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;

public class AmazonProductSearch {

//	public static void main(String[] args) {
		WebDriver driver = null;
		
		 @BeforeTest  
		public void setuptest() {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-search-engine-choice-screen");
		    driver = new ChromeDriver(chromeOptions);
			System.setProperty("WebDriver.chrome.driver", "D:/eclipse/workspace-sts-Examples/CucumberJava/src/test/resources/driver/chromedriver.exe");

			
			driver.manage().timeouts().implicitlyWait (40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		
		@Test
		public void user_is_on_amazon_browser_version() throws InterruptedException {
			
		
	       driver.get("https://www.amazon.in");
	       

			WebElement E = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
			Actions act = new Actions(driver);
			act.moveToElement(E).perform();
			
			
			driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("9007853769");
			driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Punu*17#");
		    driver.findElement(By.id("signInSubmit")).click();
	    
		    WebElement Searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		    Searchbox.sendKeys("Rubber plant");
		    
		    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		    driver.findElement(By.linkText("Rubber plant indoor live plant big size (Pack of 1)")).click();

		   // driver.findElement(By.name("proceedToRetailCheckout")).click();

	}
		 @ AfterTest
		public void teardown() {
			
			driver.close();
			driver.quit();
		}

}
