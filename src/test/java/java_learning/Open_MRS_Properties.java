package java_learning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Open_MRS_Properties extends Launch_Application {


	public Open_MRS_Properties() throws IOException {
		FileInputStream fis = new FileInputStream("./src/main/resources/locators.properties");
		prop.load(fis);
	}

	@Test
	public void locators() {
		launch();

		driver.get(prop.getProperty("URL"));

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath(prop.getProperty("pass_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("Isolation")).click();
//		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
	}

}
