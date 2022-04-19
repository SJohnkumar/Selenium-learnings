package java_learning;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	@Test
	
	public void ajio_shop()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Select Women
		WebElement women =driver.findElement(By.linkText("WOMEN"));
		Actions action = new Actions(driver);
		action.moveToElement(women).perform();
		//Select Brand
		WebElement brand = driver.findElement(By.linkText("BRANDS"));
		action.moveToElement(brand).perform();
		List <WebElement> brandsize = driver.findElements(By.linkText("AJIO GOLD BRANDS"));
		int newbrandsize = brandsize.size();
		System.out.println(newbrandsize);
		System.out.println(brandsize);
		
		
	}
}
