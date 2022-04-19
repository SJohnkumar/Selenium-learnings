package java_learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public RemoteWebDriver driver;
	// @Test
	// (Not gettng seperate run)
	public void user_login() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");
		driver.findElement(By.id("Isolation Ward")).click();
		driver.findElement(By.id("loginButton")).click();

	}

	//@Test
	public void register() throws InterruptedException {
		Login user = new Login();
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//p[2]/input")).sendKeys("Admin123");
		driver.findElement(By.xpath("//ul//li[5]")).click();
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();

		// Register a patient

		driver.findElement(By.xpath("//a[contains(@id,'registerPatient')]")).click();
		// Name
		driver.findElement(By.name("givenName")).sendKeys("John");
		driver.findElement(By.name("familyName")).sendKeys("Kumar");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		// Gender
		driver.findElement(By.xpath("//option[text()='Male']")).click();
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		// DOB
		driver.findElement(By.id("birthdateDay-field")).sendKeys("13");
		// Month(Drop Down)
		WebElement month = driver.findElement(By.name("birthdateMonth"));
		Select monthselect = new Select(month);
		monthselect.selectByVisibleText("October");
		// Year
		driver.findElement(By.name("birthdateYear")).sendKeys("1988");
		driver.findElement(By.id("next-button")).click();
		// Address
		driver.findElement(By.id("address1")).sendKeys("Pondy");
		driver.findElement(By.id("next-button")).click();
		// Mobile
		driver.findElement(By.name("phoneNumber")).sendKeys("9123456787");
		driver.findElement(By.id("next-button")).click();
		// Relative
		WebElement relative = driver.findElement(By.name("relationship_type"));
		Select relation = new Select(relative);
		relation.selectByVisibleText("Doctor");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Person Name')]")).sendKeys("Ragnar");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		// verify
		String name = driver.findElement(By.xpath("//span[contains(@class,'PersonName')]")).getText();
		System.out.println(name);
		if (name.equalsIgnoreCase("john"))
			System.out.println("John Registered Succesfully...");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'Edit Registration Information')]")).click();

		// Edit Info
		driver.findElement(By.xpath("//i[@id='contactInfo-edit-link']")).click();
		// Address
		WebElement address = driver.findElement(By.xpath("//input[@id='address1']"));
		// Clear Existing data
		address.clear();
		// Enter new Address
		address.sendKeys("Pondicherry");
		// Save the Data
		driver.findElement(By.xpath("//a[@id='save-form']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	@Test
	public void search_patient() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//p[2]/input")).sendKeys("Admin123");
		driver.findElement(By.xpath("//ul//li[5]")).click();
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		//Search Patient
		driver.findElement(By.xpath("//i[@class='icon-search']")).click();
		List <WebElement> row = driver.findElements(By.xpath("(//tbody[@role='alert']"));
		int row_size=row.size();
		System.out.println(row_size);

		
	}
}
