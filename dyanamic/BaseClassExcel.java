package testng.data.excel.dyanamic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassExcel {
	public  RemoteWebDriver driver;
	public String ExcelFileName;
	
	@Parameters({"url","username","password","browser"})
	@BeforeMethod
	public void preCondition(String url,String username,String password,String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))	{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
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
	//It denotes the data1 to be executed
//	@DataProvider(name="fetch",indices=1)
	@DataProvider(name="fetch")

	public String[][] fetchData() throws IOException {
		String[][] data = ReadExcelData.readExcel(ExcelFileName);
		return data;
		
		
		
	}
	
//	Steps
	
//	testng.data.excel.dyanamic.CreateLead1
//	setUp0 ms
//	testng.data.excel.dyanamic.EditLead1
//	setUp16 ms
//	testng.data.excel.dyanamic.CreateLead1
//	preCondition(http://leaftaps.com/opentaps/, DemoSalesManager, crmsfa, chrome)2367 ms
//	createNewLead(Capgemini, Vino, B, 86)14878 ms
//	postCondition23991 ms
//	preCondition(http://leaftaps.com/opentaps/, DemoSalesManager, crmsfa, chrome)23995 ms
//	createNewLead(Infosys, Bahath, A, 89)45500 ms
//	postCondition53898 ms
//	testng.data.excel.dyanamic.EditLead1
//	preCondition(http://leaftaps.com/opentaps/, DemoSalesManager, crmsfa, chrome)54106 ms
//	editLead(86, TCS)78949 ms
//	postCondition103132 ms
//	preCondition(http://leaftaps.com/opentaps/, DemoSalesManager, crmsfa, chrome)103136 ms
//	editLead(89, Wipro)138410 ms
//	postCondition

}