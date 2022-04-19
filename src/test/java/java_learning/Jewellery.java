package java_learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jewellery {
	@Test
	
	public void bangles() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		//URL Launch
		driver.get("https://thejewelleryroom.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//MouseOver - All Jewells
		//driver.findElement(By.xpath("//h1[text()='Jewellery']")).sendKeys(Keys.DOWN,Keys.DOWN);
		 driver.findElement(By.xpath("//a[text()='All Jewellery']")).click();
		 JavascriptExecutor jre = (JavascriptExecutor)driver;
		 jre.executeScript("Arguments[0].ScrollIntoview;", driver.findElement(By.xpath("(//span[text()='Bangles'])[1]")));
		
		
	}

}
