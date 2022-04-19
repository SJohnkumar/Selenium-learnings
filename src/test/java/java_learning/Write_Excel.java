package java_learning;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Write_Excel extends Launch_Application {
public String excelFileName = "./testdata/sampleTestdata.xlsx" ;
	
	@DataProvider(name="nametobecalled")
	public Object[][] sendData() throws IOException {
		
		return Read_Excel.excelRead(excelFileName);
	}
	
	@Test(dataProvider="nametobecalled")
	public void printTestdata(String name, String mobile,String message) throws InterruptedException {
		launch();
		driver.get("https://oceanacademy.in/");
		driver.findElement(By.xpath("(//i[contains(@class,'fa fa-phone')])[1]/..")).click();
		driver.findElement(By.id("Name")).sendKeys(name);
		driver.findElement(By.id("Email")).sendKeys(mobile);
		driver.findElement(By.id("mes")).sendKeys(message);

		Thread.sleep(3000);
		System.out.println("Data entered successfully");
		
				
		/*
		 * launchurlApplication();
		 * driver.get("https://o3.openmrs.org/openmrs/spa/login");
		 * driver.findElement(By.id("username")).sendKeys(un);
		 * driver.findElement(By.id("password")).sendKeys(pwd);
		 * driver.findElement(By.id("Isolation Ward")).click();
		 * driver.findElement(By.id("loginButton")).click();
		 */
			
	}
	

	
	
	}



