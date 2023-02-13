package pPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoOneTest {
	WebDriver driver;
	@Test
	public void sampleTest() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
		prop.load(fis);
		
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}
	@AfterMethod
	public void closure() {
		driver.quit();
	}

}
