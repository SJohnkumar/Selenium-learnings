package java_learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bank {
	@Test
	public void bank_loan() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.bankbazaar.com/personal-loan.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		//Type of Employment
		driver.findElement(By.xpath("//input[@value ='SALARIED']")).click();
		//Company
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Infosys");
		//Choose 2nd in the List
		WebElement search = driver.findElement(By.xpath("//input[@role='combobox']"));
		driver.findElement(By.xpath("//span[@class='Select-arrow']")).click();
		search.sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER);
		Thread.sleep(5000);
		//Get the Average Value
		String i_value =driver.findElement(By.xpath("//div[contains(@class,'handle-label')]//span[text()='0']")).getText();
		int initial = Integer.parseInt(i_value);
		 System.out.println("Initial Value"+initial);
		 String end_value = driver.findElement(By.xpath("//div[@aria-valuemax='120000']")).getAttribute("aria-valuemax");
		 System.out.println("EndValue"+end_value);
		 int end = Integer.parseInt(end_value);
		 int average = (initial+end)/2;
		 System.out.println(average);
		 String average_value = String.valueOf(average);
		 driver.findElement(By.xpath("//input[@name='netMonthlyIncome']")).sendKeys(average_value);
		 driver.findElement(By.linkText("Continue")).click();
		 //Pincode
		 driver.findElement(By.xpath("//input[@placeholder='PIN Code']")).sendKeys("600001");
		 driver.findElement(By.id("slideBtn")).click();
		 //Validate Mobile Number Screen
		 //driver.findElement(By.name("mobileNumber")).click();
		driver.findElement(By.name("mobileNumber")).sendKeys("12345");
		 String mobile_title = driver.findElement(By.id("slideCustomTitle")).getText();
		 System.out.println(mobile_title);
		 driver.findElement(By.xpath("//div[@id='slideBtn']")).click();
		 String Error = driver.findElement(By.className("errorMessage")).getText();
		 String Expected = "Are you sure that is your number?";
		 //Validation
		 if(Error.equalsIgnoreCase(Expected))
				 {
			 System.out.println("Invalid Number");
		 }
		 
		
		
		
	}

}
