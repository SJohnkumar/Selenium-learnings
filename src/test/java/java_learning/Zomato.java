package java_learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zomato {
	@Test
	public void A2B() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch URL
		driver.get("https://www.zomato.com/chennai");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//Select A2B Restaurant
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for restaurant')]")).sendKeys("A2B");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for restaurant')]")).click();
		driver.findElement(By.xpath("//p[text()='A2B Veg Restaurant']")).click();
		//Check open or Closed
		String status = driver.findElement(By.xpath("//span[text()='Open now']")).getText();
		System.out.println(status);
		//Click Order online
		driver.findElement(By.linkText("Order Online")).click();
		//Select Sweets
		driver.findElement(By.xpath("(//p[contains(text(),'Sweets')])[1]")).click();
		List <WebElement> price = driver.findElements(By.xpath("//span[@class='sc-17hyc2s-1 cCiQWA']"));
		WebElement sweet_price;
		for(int i =0;i<10;i++)
		{
		sweet_price = price.get(i);
		System.out.println(sweet_price);
	}
}
}
