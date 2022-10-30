package testcase.dataprovider;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import clg.college.ReadDataFromExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public ChromeDriver driver;
	public String ExcelFileName;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCondition(String url, String username, String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

	}

	@AfterMethod

	public void postCondition() {
		// driver.close();
	}

	@DataProvider(name = "fetch")
	public String[][] fetchDataForcreate() throws IOException {
		String[][] data = ReadDataFromExcel.readExcel(ExcelFileName);
		return data;

	}

}
