package java_learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_practice {
@Test
	public void sign_in()
	{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver dr = new ChromeDriver();
		dr.get("http://automationpractice.com/index.php");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		dr.findElement(By.className("login")).click();
		dr.findElement(By.id("email_create")).sendKeys("abbcccddd@gmail.com");
		dr.findElement(By.name("SubmitCreate")).click();
		//dr.findElement(By.id("id_gender1")).isSelected();
		//Name
		dr.findElement(By.id("customer_firstname")).sendKeys("Ragnar");
		dr.findElement(By.id("customer_lastname")).sendKeys("Lothbrok");
		//Password
		dr.findElement(By.xpath("//input[@type='password']")).sendKeys("Vikings");
		//DOB
		WebElement day = dr.findElement(By.id("days"));
		Select dayspecific = new Select(day);
		dayspecific.selectByValue("13");
		//Month
		WebElement month = dr.findElement(By.id("months"));
		Select specificmonth = new Select(month);
		specificmonth.selectByVisibleText("October ");
		//Year
		WebElement year = dr.findElement(By.id("years"));
		Select specificyear = new Select(year);
		specificyear.selectByValue("1997");
		//Company
		dr.findElement(By.id("company")).sendKeys("History");
		//Address
		dr.findElement(By.name("address1")).sendKeys("Kattaget");
		dr.findElement(By.name("address2")).sendKeys("Iceland");
		//city
		dr.findElement(By.name("city")).sendKeys("Valhalla");
		//State
		WebElement state = dr.findElement(By.name("id_state"));
		Select specificstate = new Select(state);
		specificstate.selectByValue("5");
		//postal
		dr.findElement(By.id("postcode")).sendKeys("10008");
		//country
		WebElement country = dr.findElement(By.name("id_country"));
		Select specificcountry = new Select(country);
		specificcountry.selectByValue("21");
		//Mobile
		dr.findElement(By.name("phone_mobile")).sendKeys("9812345678");
		//Address2
		dr.findElement(By.xpath("//input[@name='alias']")).sendKeys("New York");
		//Submit
		dr.findElement(By.id("submitAccount")).click();
		
	}
}
