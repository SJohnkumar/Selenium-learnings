package java_learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	@Test
	public void myntra_purchase() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		// RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		// Login
		driver.get("https://www.myntra.com/");
		// Search Box
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Sunglasses", Keys.ENTER);
		// Find
		driver.findElement(
				By.xpath("//section//div[contains(@class,'brand-container')]//span[contains(@class,'iconSearch')]"))
				.click();
		// Search Polaroid
		driver.findElement(By.xpath("//div[contains(@class,'filterSearchBox')]//input")).sendKeys("polaroid");
		// Select Polaroid
		driver.findElement(By.xpath("//ul[@class='brand-list']//label[contains(@class,'ertical-filters')]")).click();
		// Size
		List<WebElement> glasssize = driver.findElements(By.xpath("//h4[text()='Men Rectangle Sunglasses']"));
		int noofglass = glasssize.size();
		System.out.println(noofglass);
		// Mouse Over
		Thread.sleep(3000);
		WebElement frst_product = driver.findElement(By.xpath("(//h3[@class='product-brand'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(frst_product).perform();
		// Click Similar Items
		driver.findElement(By.xpath("//span[text()='VIEW SIMILAR']/..")).click();
		// To Find no.of.similar items
		List<WebElement> no_of_similar = driver.findElements(By.xpath("//ul[contains(@class,'similarGrid')]//h4"));
		int similar_items = no_of_similar.size();
		System.out.println(similar_items);
		driver.close();

	}
}
