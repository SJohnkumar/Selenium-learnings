package java_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_MRQ {

	public void Register()
	{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("https://o3.openmrs.org/openmrs/spa/login");
		//User Name
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Impatient Ward
		driver.findElement(By.xpath("//span[text()='Inpatient Ward']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
}
